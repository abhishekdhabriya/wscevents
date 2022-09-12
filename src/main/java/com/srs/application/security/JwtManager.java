package com.srs.application.security;

import io.jsonwebtoken.Claims;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Date;
import java.util.function.Function;

public interface JwtManager {
    String generateToken(final UserDetails userDetails);
    Date extractExpiration(final String token);
    String extractUsername(final String token);
    <T> T extractClaims(final String token, final Function<Claims, T> claimsResolver);
    Boolean isTokenExpired(final String token);
    Boolean validateToken(final String token, final UserDetails userDetails);


}
