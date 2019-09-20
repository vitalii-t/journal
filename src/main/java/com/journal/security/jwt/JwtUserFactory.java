package com.journal.security.jwt;

import com.journal.data.entities.User;

public final class JwtUserFactory {

    public static JwtUser createUser(User user){
        return new JwtUser(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getUsername(),
                user.getPassword(),
                user.getEmail(),
                user.isActive(),
                user.getAuthorities()
        );
    }
}