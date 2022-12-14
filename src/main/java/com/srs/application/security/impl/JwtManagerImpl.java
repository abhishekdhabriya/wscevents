package com.srs.application.security.impl;

import com.srs.application.security.JwtManager;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtManagerImpl implements JwtManager {

    @Value("${app.security.jwt.secret-key}")
    private String secretKey;

    @Value("${app.security.jwt.token-expires-after:36000000}")
    private Integer jwtTokenExpiresAfter;

    @Override
    public String generateToken(final UserDetails userDetails) {
        final Map<String, Object> claims = new HashMap<>();
        return this.createToken(claims, userDetails.getUsername());
    }

    private String createToken(final Map<String, Object> claims, final String subject) throws NumberFormatException {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + this.jwtTokenExpiresAfter.intValue()))
                .signWith(SignatureAlgorithm.HS512, secretKey)
                .compact();
    }

    @Override
    public String extractUsername(final String token) {
        return this.extractClaims(token, Claims::getSubject);
    }

    public Date extractExpiration(final String token) {
        return this.extractClaims(token, Claims::getExpiration);
    }

    @Override
    public <T> T extractClaims(final String token, Function<Claims, T> claimsResolver) {
        final Claims claims = this.extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(final String token) {
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
    }

    @Override
    public Boolean isTokenExpired(final String token) {
        return this.extractExpiration(token).before(new Date());
    }

    @Override
    public Boolean validateToken(final String token, final UserDetails userDetails) {

        if (!isTokenExpired(token)) {
            final String username = this.extractUsername(token);
            return username.equals(userDetails.getUsername());
        } else {
            return false;
        }

    }
}
