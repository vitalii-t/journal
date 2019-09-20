package com.journal.data.dto;

import com.journal.data.entities.Group;
import com.journal.data.entities.Role;
import com.journal.data.entities.User;
import lombok.*;

import java.util.Set;

@Data
public class UserDto {

    private Long id;

    private String firstName;

    private String lastName;

    private String username;

    private Group group;

    private Set<Role> roles;

    public UserDto(User user){
        this.id = user.getId();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.username = user.getUsername();
        this.group = user.getGroup();
        this.roles = user.getRoles();
    }
}