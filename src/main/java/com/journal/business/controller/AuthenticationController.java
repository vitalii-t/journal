package com.journal.business.controller;

import com.journal.business.service.UserService;
import com.journal.data.dto.AuthenicationRequestDto;
import com.journal.data.entities.User;
import com.journal.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;
    private final UserService userService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody AuthenicationRequestDto requestDto){
        try {
            String username = requestDto.getUsername();
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, requestDto.getPassword()));
            User user = (User) userService.loadUserByUsername(username);
            if(user==null){
                throw new UsernameNotFoundException("User with such username"+ username +" not found.");
            }
            String token = jwtTokenProvider.createToken(username,new ArrayList<>(user.getRoles()));
            Map<Object,Object> response = new HashMap<>();

            response.put("username",username);
            response.put("token", token);
            response.put("roles",user.getRoles());
            return ResponseEntity.ok(response);
        }catch (AuthenticationException e){
            throw new BadCredentialsException("Invalid username or password");
        }
    }
    @GetMapping("/login")
    public String loginPage(){
        return "login";
    }
}