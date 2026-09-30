
package com.praticando.tere_verde.config;
import java.util.Date;

import javax.crypto.SecretKey;
import org.springframework.stereotype.Service;

import com.praticando.tere_verde.model.Usuario;

import io.jsonwebtoken.Jwts;


@Service 
public class JwtServise {

    private SecretKey chaveSecreta = Jwts.SIG.HS256.key().build();

    public  String gerarToken (Usuario usuario){
        return  Jwts.builder()
        .subject(usuario.getEmail())
        .issuedAt(new Date())
        .expiration(new Date(System.currentTimeMillis() + 3600000 ))
        .signWith(chaveSecreta).compact();


    }

    public String extrairEmail (String token){
        return  Jwts.parser()
        .verifyWith(chaveSecreta)
        .build()
        .parseSignedClaims(token)
        .getPayload()
        .getSubject();
    }
    
}