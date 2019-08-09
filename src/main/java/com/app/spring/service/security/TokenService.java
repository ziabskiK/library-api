package com.app.spring.service.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import java.util.HashMap;
import java.util.Map;

public class TokenService {


    private static final String SECRET_KEY = "superSecret";


    public static String createToken(Long id, String username, String password, String role, String firstName, String lastName, String email) {
        Map<String, Object> header = new HashMap<>();
        header.put("alg", "HS256");
        header.put("typ", "JWT");


        return JWT.create().withHeader(header).withClaim("email", email).withClaim("firstName", firstName).withClaim("lastName", lastName).withClaim("name", username).withClaim("password", password).withClaim("role", role).withClaim("id", id).sign(Algorithm.HMAC256(SECRET_KEY));

    }


}
