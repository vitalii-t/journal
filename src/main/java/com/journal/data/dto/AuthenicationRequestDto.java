package com.journal.data.dto;

import com.journal.data.entities.Role;
import lombok.Data;

import java.util.Set;

@Data
public class AuthenicationRequestDto {
    private String username;
    private String password;
    private Set<Role> roles;
}