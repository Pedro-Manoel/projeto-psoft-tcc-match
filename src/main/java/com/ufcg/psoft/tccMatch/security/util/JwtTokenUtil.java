package com.ufcg.psoft.tccMatch.security.util;

import com.ufcg.psoft.tccMatch.model.usuario.Usuario;
import com.ufcg.psoft.tccMatch.security.exception.TokenInvalidoException;
import io.jsonwebtoken.*;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtTokenUtil {

    private final Integer JWT_EXPIRATION_ONE_WEEK = 7 * 24 * 60 * 60 * 1000;
    private final String JWT_SECRET = "zdtlD3JK56m6wTTgsNFhqzjqP";
    private final String JWT_ISSUER = "com.ufcg.psoft.tccMatch";

    public String generateToken(MyUserDetail myUserDetail) {
        return Jwts
                .builder()
                .setSubject(String.format("%s,%s", myUserDetail.getId(), myUserDetail.getUsername()))
                .setIssuer(JWT_ISSUER)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + JWT_EXPIRATION_ONE_WEEK))
                .signWith(SignatureAlgorithm.HS256, JWT_SECRET)
                .compact();
    }

    public String getUsername(String token) {
        Claims claims = Jwts
                .parser()
                .setSigningKey(JWT_SECRET)
                .parseClaimsJws(token)
                .getBody();

        return claims.getSubject().split(",")[0];
    }

    public String getUserId(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(JWT_SECRET)
                .parseClaimsJws(token)
                .getBody();

        return claims.getSubject().split(",")[1];
    }

    public boolean validateToken(String token) {
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
