
package com.digitalalibi.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;

@Service
public class JwtService {
    //	Extracts information and validates JWT

    private final SecretKey secretKey;
    private final long expiration;

    public JwtService(
            //generate JWT
            @Value("${jwt.secret}") String secret,
            @Value("${jwt.expiration}") long expiration) {

        this.secretKey = Keys.hmacShaKeyFor(
                Decoders.BASE64.decode(secret)
        );

        this.expiration = expiration;
    }

    public String generateToken(String email) {

        Date currentDate = new Date();

        Date expirationDate = new Date(
                currentDate.getTime() + expiration
        );

        return Jwts.builder()
                .subject(email)
                .issuedAt(currentDate)
                .expiration(expirationDate)
                .signWith(secretKey)
                .compact();
    }

    public String extractEmail(String token){
        //Returns the email stored in the JWT subject.
        return Jwts.parser()
                .verifyWith(secretKey)
                .build()
                .parseClaimsJws(token)
                .getPayload()
                .getSubject();
    }

    public boolean validateToken(String token){
        //Checks whether the JWT is valid.
        try{
            Jwts.parser()
                    .verifyWith(secretKey)
                    .build()
                    .parseClaimsJws(token);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
}
