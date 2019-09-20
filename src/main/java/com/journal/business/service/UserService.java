package com.journal.business.service;

import com.journal.data.dto.UserDto;
import com.journal.data.entities.Group;
import com.journal.data.entities.Role;
import com.journal.data.entities.User;
import com.journal.data.repository.UserRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final MailSender mailSender;
    private final PasswordEncoder passwordEncoder;

    public UserService(@Lazy UserRepository userRepository, @Lazy MailSender mailSender, @Lazy PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.mailSender = mailSender;
        this.passwordEncoder = passwordEncoder;
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        return Optional
                .ofNullable(userRepository.findByUsername(username))
                .orElseThrow(() -> new UsernameNotFoundException("User with such username not found"));
    }

    public boolean addUser(User user) {
        User dbUser = userRepository.findByUsername(user.getUsername());

        if (null != dbUser) {
            return false;
        }

        user.setActive(true);
        user.setRoles(Collections.singleton(Role.ANON));
        user.setActivationCode(UUID.randomUUID().toString());
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        userRepository.save(user);

        if (!StringUtils.isEmpty(user.getEmail())) {
            String message = String.format(
                    "Hello, %s! \n" +
                            "Welcome to CI-161`s group site. \n" +
                            " if you don`t want just ignore message. \n" +
                            "Please, visit next link: http://localhost:8080/activate/%s",
                    user.getUsername(),
                    user.getActivationCode()
            );

            mailSender.send(user.getEmail(), "Activation code", message);
        }
        return true;
    }

    public boolean activateUser(String code) {
        User user = userRepository.findByActivationCode(code);

        if (user == null) {
            return false;
        }

        Group g = new Group();
        g.setIdentifier("CI-161");

        user.setGroup(g);
        user.setActivationCode(null);

        //TODO для тестов закоментить
        user.getRoles().clear();

        //TODO для тестов закоментить
        user.getRoles().add(Role.APPROVED);

        //user.setRoles(Collections.singleton(Role.APPROVED));

        userRepository.saveAndFlush(user);
        return true;
    }

    public void edit(User user, String username, String email, String group, Map<String, String> form) {

//        User user = userRepository.findByUsername(userDto.getUsername());
        user.setUsername(username);
        user.setEmail(email);
        Group g = new Group();
        g.setIdentifier(group);
        user.setGroup(g);
        user.getGroup().setIdentifier(group);

        Set<String> roles = Arrays.stream(Role.values())
                .map(Role::name).collect(Collectors.toSet());

        user.getRoles().clear();

        for (String key : form.keySet()) {
            if (roles.contains(key)) {
                user.getRoles().add(Role.valueOf(key));
            }
        }
        userRepository.save(user);
    }
}