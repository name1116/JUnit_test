package com.example.boot_test.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {
	private final String SECRET_KEY = "yourSecretKeyHereMustBeAtLeast32BytesLong"; // 비밀 키
	private final Key key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
	
	
	// JWT 토큰 생성
    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username) // 주제 설정 (사용자 이름)
                .setIssuedAt(new Date(System.currentTimeMillis())) // 토큰 발행 시간 설정
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)) // 만료 시간 설정 (10시간)
                .signWith(key, SignatureAlgorithm.HS256) // 서명 알고리즘 및 키 설정
                .compact(); // 토큰 생성
        
    }
    
    // JWT Claim
    private Claims extractAllClaims(String token) {
    	return Jwts.parserBuilder()
    			.setSigningKey(key)
    			.build()
    			.parseClaimsJws(token)
    			.getBody();

    }
    
    public String extractUsername(String token) {
    	Claims claims = extractAllClaims(token);
    	return claims.getSubject();
    }
}



