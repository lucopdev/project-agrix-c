package com.betrybe.agrix.ebytr.staff.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.betrybe.agrix.ebytr.staff.entity.Person;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class TokenService {

  private Algorithm algorithm;

  public TokenService(@Value("${api.security.token.secret}") String secret) {
    algorithm = Algorithm.HMAC256(secret);
  }

  public String generateToken(Person person) {

    return JWT.create()
        .withIssuer("senhaLucas")
        .withSubject(person.getUsername())
        .withExpiresAt(generateExpirationDate())
        .sign(algorithm);
  }

  private Instant generateExpirationDate() {
    return LocalDateTime.now()
        .plusHours(2)
        .toInstant(ZoneOffset.of("-03:00"));
  }

  public String validateToken(String token) {
    return JWT.require(algorithm)
        .withIssuer("senhaLucas")
        .build()
        .verify(token)
        .getSubject();
  }
}