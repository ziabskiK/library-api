package com.app.spring.service.security;

import com.app.spring.model.user.User;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import java.util.HashMap;
import java.util.Map;

public class TokenService {


    private static final String SECRET_KEY = "superSecret";


    public static String createToken(Long id, String password, String role, String firstName, String lastName, String email) {
        Map<String, Object> header = new HashMap<>();
        header.put("alg", "HS256");
        header.put("typ", "JWT");


        return JWT.create().withHeader(header).withClaim("email", email).withClaim("firstName", firstName).withClaim("lastName", lastName).withClaim("password", password).withClaim("role", role).withClaim("id", id).sign(Algorithm.HMAC256(SECRET_KEY));

    }

    public static String createToken(User user) {
        return createToken(user.getId(), user.getPassword(), user.getRole(), user.getFirstName(), user.getLastName(), user.getEmail());
    }


}
