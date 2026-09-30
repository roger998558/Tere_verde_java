package com.praticando.tere_verde.repositorio;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.praticando.tere_verde.model.Usuario;

public interface UsuarioRepositorio extends JpaRepository<Usuario , String> {

    public Optional<Usuario> findByEmail (String email);

    

}
