package com.praticando.tere_verde.repositorio;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.praticando.tere_verde.model.Montanha;

public interface MontanhaRepository extends JpaRepository <Montanha , String > {

    Optional<Montanha> findByNome ( String nome );
    
}
