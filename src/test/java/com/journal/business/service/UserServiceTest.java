package com.journal.business.service;

import com.journal.data.entities.Role;
import com.journal.data.entities.User;
import com.journal.data.repository.UserRepository;
import org.hamcrest.CoreMatchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;
    @MockBean
    private UserRepository userRepository;
    @MockBean
    private MailSender mailSender;
    @MockBean
    private PasswordEncoder passwordEncoder;

    @Test
    public void addUser() {
        User user = new User();
        user.setEmail("test@ex.com");
        boolean isUserAdded = userService.addUser(user);

        assertTrue(isUserAdded);
        assertNotNull(user.getActivationCode());
        assertTrue(CoreMatchers.is(user.getRoles()).matches(Collections.singleton(Role.ANON)));

        verify(userRepository,times(1)).save(user);

        verify(mailSender,times(1))
                .send(
                        ArgumentMatchers.eq(user.getEmail()),
                        anyString(),
                        anyString()
                );
    }

    @Test
    public void addUserFailTest(){
        User user = new User();
        user.setUsername("Me");

        doReturn(new User())
                .when(userRepository)
                .findByUsername("Me");

        boolean isUserAdded = userService.addUser(user);

        assertFalse(isUserAdded);

        verify(userRepository,times(0)).save(any(User.class));

        verify(mailSender,times(0))
                .send(
                        anyString(),
                        anyString(),
                        anyString()
                );
    }

    @Test
    public void activateUserTest(){
        User user = new User();
        user.setActivationCode("activated");

        doReturn(user)
                .when(userRepository)
                .findByActivationCode("code");

        boolean isActivated = userService.activateUser("code");


        assertTrue(isActivated);
        assertNull(user.getActivationCode());

        verify(userRepository,times(1)).save(user);
    }

    @Test
    public void activateUserFailTest(){
        boolean isActivated = userService.activateUser("new code");

        assertFalse(isActivated);
        verify(userRepository,times(0)).save(any(User.class));
    }
}