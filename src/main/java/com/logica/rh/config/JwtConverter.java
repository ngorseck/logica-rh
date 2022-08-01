package com.logica.rh.config;


import com.logica.rh.domain.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class JwtConverter implements Converter<Jwt, AbstractAuthenticationToken> {

    @Override
    public AbstractAuthenticationToken convert(Jwt jwt) {
        List<String> roles = Optional.ofNullable(jwt.getClaimAsStringList("roles")).orElse(new ArrayList<>());
        List<GrantedAuthority> authorities = roles.stream().
                map(role -> new SimpleGrantedAuthority("ROLE_" + role))
                .collect(Collectors.toList());
        return new UsernamePasswordAuthenticationToken(createUser(jwt), null, authorities);
    }

    private User createUser(Jwt jwt) {
        return new User(jwt.getClaim("given_name"),
                jwt.getClaim("family_name"),
                jwt.getClaim("email"));
    }

}