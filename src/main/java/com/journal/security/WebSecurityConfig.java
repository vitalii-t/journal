package com.journal.security;


import com.journal.business.service.UserService;
import com.journal.security.jwt.JwtConfigurer;
import com.journal.security.jwt.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;
    private final String [] PERMIT_ALL = {"/", "/registration", "/css/**", "/h2_console/**", "/activate/*"};

    @Autowired
    public WebSecurityConfig(@Lazy UserService userService, @Lazy PasswordEncoder passwordEncoder, JwtTokenProvider jwtTokenProvider) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return new BCryptPasswordEncoder(8);
    }
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        String login = "/login";
//        http
//                    .authorizeRequests()
//                    .antMatchers(PERMIT_ALL).permitAll()
//                    .anyRequest().authenticated()
//                .and()
//                    .formLogin()
//                    .loginPage(login)
//                    .permitAll()
//                    .defaultSuccessUrl("/main")
//                    .loginProcessingUrl(login)
//                .and()
//                    .csrf().ignoringAntMatchers("/h2-console/**")   // добавить в защите игнор консоли
//                .and()
//                    .logout()
//                    .logoutUrl("/logout")
//                    .logoutSuccessUrl(login)
//                    .permitAll();

        http.
                httpBasic().disable().
                csrf().disable().
                sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).
                and().authorizeRequests().
                antMatchers(PERMIT_ALL).permitAll().
                anyRequest().authenticated().
                and()
//                .formLogin()
//                .loginPage(login)
//                .permitAll()
//                .defaultSuccessUrl("/main")
//                .loginProcessingUrl(login)
//                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl(login)
                .permitAll().and().apply(new JwtConfigurer(jwtTokenProvider));

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService)
                .passwordEncoder(passwordEncoder);
    }
}