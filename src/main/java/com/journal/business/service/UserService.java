package com.journal.business.service;

import com.journal.data.entities.Group;
import com.journal.data.entities.Role;
import com.journal.data.entities.User;
import com.journal.data.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserService implements UserDetailsService {


    private final UserRepository userRepository;
    private final MailSender mailSender;

    public UserService(UserRepository userRepository, MailSender mailSender) {
        this.userRepository = userRepository;
        this.mailSender = mailSender;
    }


    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username);
    }

    public boolean addUser(User user) {
        User dbUser = userRepository.findByUsername(user.getUsername());

        if (null != dbUser) {
            return false;
        }

        user.setActive(true);
        user.setRoles(Collections.singleton(Role.ANON));
        user.setActivationCode(UUID.randomUUID().toString());
        userRepository.save(user);

        if (!StringUtils.isEmpty(user.getEmail())) {
            String message = String.format(
                    "Hello, %s! \n" +
                            "Welcome to CI-161`s group site. \n" +
                            " if you don`t want just ignore message. \n"+
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

        user.setActivationCode(null);

        user.getRoles().clear();
        user.setRoles(Collections.singleton(Role.APPROVED));

        //userRepository.save(user);
userRepository.flush();
        return true;
    }

    public void edit(User user, String username, String email,String group, Map<String, String> form) {

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