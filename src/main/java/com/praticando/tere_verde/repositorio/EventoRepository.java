package com.praticando.tere_verde.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.praticando.tere_verde.model.Evento;

public interface EventoRepository extends JpaRepository <Evento , String > {
    
}
