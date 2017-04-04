package tn.cynapsys.security.util;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import tn.cynapsys.security.userDto.JwtUserDto;

@Component
public class JwtTokenGenerator {
	private static final String secret = "xyZEA1425ZEIxksdjide8Dsdz";
	public static String generateToken(JwtUserDto u) {
        Claims claims = Jwts.claims().setSubject(u.getUsername());
        claims.put("userId", u.getId() + "");
        claims.put("role", u.getRole());
        Date expiration = Date.from(LocalDateTime.now().plusHours(0).toInstant(ZoneOffset.UTC));

        return Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, secret)
                .setExpiration(expiration)
                .compact();
    }

}