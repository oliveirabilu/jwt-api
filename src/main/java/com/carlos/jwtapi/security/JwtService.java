package com.carlos.jwtapi.security;

import com.carlos.jwtapi.entity.Role;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Service
public class  JwtService {
    @Value("${api.security.token.secret}")
    private String secret;
    @Value("${api.security.token.expiration}")
    private long expiration;

    private SecretKey getSigningKey(){
        return Keys.hmacShaKeyFor(
                secret.getBytes(StandardCharsets.UTF_8));
    }
    public String gerarToken(String login, Role role){
        return Jwts.builder()
                .subject(login)
                .claim("role", role.name())
                .expiration(new Date(System.currentTimeMillis()+expiration))
                .signWith(getSigningKey())

                .compact();
    }
    public String getSubject(String token){
    var claims = Jwts.parser()
            .verifyWith(getSigningKey())
            .build()
            .parseSignedClaims(token)
            .getPayload();
        return claims.getSubject();
    }

    public String getRole(String token) {
        var claims = Jwts.parser()
                .verifyWith(getSigningKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();

        return claims.get("role", String.class);
    }

}
