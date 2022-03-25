package com.ufcg.psoft.tccMatch.security.util;

import com.ufcg.psoft.tccMatch.security.error.exception.TokenInvalidoException;
import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtTokenUtil {

    @Value("${jwt_secret}")
    private String JWT_SECRET;

    @Value("${jwt_issuer}")
    private String JWT_ISSUER;

    @Value("${jwt_expiration_one_week}")
    private Integer JWT_EXPIRATION;

    public String generateToken(MyUserDetail myUserDetail) {
        return Jwts
                .builder()
                .setSubject(myUserDetail.getUsername())
                .setIssuer(JWT_ISSUER)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + JWT_EXPIRATION))
                .signWith(SignatureAlgorithm.HS256, JWT_SECRET)
                .compact();
    }

    public String getUsername(String token) {
        Claims claims = Jwts
                .parser()
                .setSigningKey(JWT_SECRET)
                .parseClaimsJws(token)
                .getBody();

        return claims.getSubject();
    }

    public boolean validToken(String token) {
        try {
            Jwts.parser().setSigningKey(JWT_SECRET).parseClaimsJws(token);
            return true;
        } catch (SignatureException ex) {
            throw new TokenInvalidoException("Token com assinatura inválida");
        } catch (MalformedJwtException ex) {
            throw new TokenInvalidoException("Token inválido");
        } catch (ExpiredJwtException ex) {
            throw new TokenInvalidoException("Token expirado");
        } catch (UnsupportedJwtException ex) {
            throw new TokenInvalidoException("Token não suportado");
        }
    }
}
