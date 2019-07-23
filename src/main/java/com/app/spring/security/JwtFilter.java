package com.app.spring.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.Set;


public class JwtFilter extends BasicAuthenticationFilter {


    protected JwtFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {


        String header = request.getHeader("Authorization");

        UsernamePasswordAuthenticationToken authResult = getAuthenticationByToken(header);

        SecurityContextHolder.getContext().setAuthentication(authResult);
        chain.doFilter(request, response);


    }

    private UsernamePasswordAuthenticationToken getAuthenticationByToken(String header) {

        DecodedJWT jwt;
        String username = "";
        String role = "x";


        if (header != null) {
            jwt = JWT.decode(header.replaceFirst("Bearer ", ""));
            username = jwt.getClaims().get("name").asString();
            role = jwt.getClaims().get("role").asString();
        }

        Set<SimpleGrantedAuthority> simpleGrantedAuthorities = Collections.singleton(new SimpleGrantedAuthority(role));

        return new UsernamePasswordAuthenticationToken(username, null, simpleGrantedAuthorities);
    }

}
