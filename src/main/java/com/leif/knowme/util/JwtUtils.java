package com.leif.knowme.util;

import com.leif.knowme.exception.AuthException;
import com.leif.knowme.pojo.AuthInfo;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;
import java.util.function.Function;

@Component
public class JwtUtils implements Serializable {
    public static final int JWT_TOKEN_VALIDITY = 30 * 60;

    @Value("${jwt.secret}")
    private String secret;

    //retrieve username from jwt token
    public String getUsernameFromToken(String token) throws AuthException {
        return getClaimFromToken(token, Claims::getSubject);
    }

    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) throws AuthException {
        try {
            final Claims claims = getAllClaimsFromToken(token);
            return claimsResolver.apply(claims);
        } catch (ExpiredJwtException e) {
            throw new AuthException("token has expired");
        }
    }

    //for retrieveing any information from token we will need the secret key
    private Claims getAllClaimsFromToken(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    }

    //while creating the token -
    //1. Define  claims of the token, like Issuer, Expiration, Subject, and the ID
    //2. Sign the JWT using the HS512 algorithm and secret key.
    //3. According to JWS Compact Serialization(https://tools.ietf.org/html/draft-ietf-jose-json-web-signature-41#section-3.1)
    //   compaction of the JWT to a URL-safe string
    public AuthInfo doGenerateToken(String subject, Integer second) {

        int availableSeconds = second == null ? JWT_TOKEN_VALIDITY : second;
        Date expiration = new Date(System.currentTimeMillis() + availableSeconds * 1000);
        String token= Jwts.builder().setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(expiration)
                .signWith(SignatureAlgorithm.HS512, secret).compact();
        return new AuthInfo(token,expiration.getTime());
    }

    //validate token
    public Boolean validateToken(String token, String accountId) {
        try {
            final String aid = getUsernameFromToken(token);
            return aid.equals(accountId);
        } catch (AuthException e) {
            return false;
        }
    }

    public AuthInfo doGenerateToken(String accountId) {
        return this.doGenerateToken(accountId, null);
    }
}