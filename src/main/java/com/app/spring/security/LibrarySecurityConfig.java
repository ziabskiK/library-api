package com.app.spring.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class LibrarySecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/user").authenticated()
                .antMatchers("/admin").hasRole("ADMIN")
                .and()
                .addFilter(new JwtFilter(authenticationManager()));

    }
}
