package com.logica.rh;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtException;
import java.time.Instant;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@TestConfiguration
public class TestSecurityConfig {

    @Bean
    public JwtDecoder jwtDecoder() {
        return new JwtDecoder() {
            @Override
            public Jwt decode(String token) throws JwtException {
                return jwt(token);
            }
        };
    }

    public Jwt jwt(String token) {
        Map<String, Object> headers = new HashMap<>();
        headers.put("alg","RS256");
        Map<String, Object> claims = new HashMap<>();
        claims.put("roles", Collections.singletonList("admin"));
        claims.put("given_name","Mamadou Lamine");
        claims.put("family_name","Ba");
        claims.put("email", "johndoe@example.com");
        return new Jwt(
                token,
                Instant.now(),
                Instant.now().plusSeconds(20),
                headers,
                claims
        );
    }
}