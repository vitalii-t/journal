package com.journal.data.dto;

import com.journal.data.entities.Group;
import com.journal.data.entities.Role;
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

    private String firstName;

    private String lastName;

    private String username;

    private String email;

    private Group group;

    private Set<Role> roles;

}