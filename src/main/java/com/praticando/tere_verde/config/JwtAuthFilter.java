package com.praticando.tere_verde.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.praticando.tere_verde.model.Usuario;
import com.praticando.tere_verde.repositorio.UsuarioRepositorio;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component 
public class JwtAuthFilter extends OncePerRequestFilter {

    @Autowired 
    private JwtServise jwtServise;
    @Autowired 
    private UsuarioRepositorio usuarioRepositorio ;


    protected void doFilterInternal ( HttpServletRequest request , HttpServletResponse response,
        FilterChain filterChain) throws ServletException , IOException {

            String authHeader = request.getHeader("Authorization");

            if (authHeader == null || !authHeader.startsWith("Bearer")) {
                
                filterChain.doFilter(request, response);
                return;


            }

            String token = authHeader.substring(7);
            String email = jwtServise.extrairEmail(token);

            Usuario usuario = usuarioRepositorio.findByEmail(email).orElse(null);

            if (usuario != null) {
                UsernamePasswordAuthenticationToken  authToken = 
                new UsernamePasswordAuthenticationToken (usuario , null , usuario.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
            filterChain.doFilter(request, response);


        }
    
}
