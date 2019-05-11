package com.journal.data.dto;

import com.journal.data.entities.Group;
import com.journal.data.entities.Role;
import com.journal.data.entities.User;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;
@Setter
@Getter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class UserDto {
    //private Long id;

    private String firstName;

    private String lastName;

    private String username;

    private String password;

    private String activationCode;

    private String email;

    private Group group;

    private Set<Role> roles;

    private boolean active;
}
