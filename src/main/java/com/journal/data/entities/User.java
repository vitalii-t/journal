package com.journal.data.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Collection;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User implements UserDetails  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "First name can`t be empty")
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @NotBlank(message = "Last name can`t be empty")
    @Column(name = "last_name", nullable = false)
    private String lastName;

    @NotBlank(message = "Username can`t be empty")
    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @NotBlank(message = "Password can`t be empty")
    @Column(name = "password", nullable = false)
    private String password;

    @Transient
    private String passwordConfirmation;

    @Column(name = "activation_code")
    private String activationCode;

    @NotBlank(message = "Email can`t be empty")
    @Email(message = "Email is not correct")
    @Column(name = "email", nullable = false,unique = true)
    private String email;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "group_id")
    private Group group;

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    @Column(name = "roles")
    private Set<Role> roles;

    private boolean active;

    public boolean isAdmin(){
        return roles.contains(Role.ADMIN);
    }
    public boolean isMonitor(){
        return roles.contains(Role.MONITOR);
    }
    public boolean isAnon(){
        return roles.contains(Role.ANON);
    }
    public boolean isApproved(){
        return roles.contains(Role.APPROVED);
    }
    public boolean isStudent(){
        return roles.contains(Role.STUDENT);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRoles();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return active;
    }
}