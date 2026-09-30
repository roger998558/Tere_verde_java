package com.praticando.tere_verde.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.praticando.tere_verde.model.Evento;
import com.praticando.tere_verde.model.Montanha;
import com.praticando.tere_verde.repositorio.EventoRepository;
import com.praticando.tere_verde.repositorio.MontanhaRepository;
import com.praticando.tere_verde.shared.EventoRequestDTO;
import com.praticando.tere_verde.shared.EventoResponseDTO;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController 
@RequestMapping("/Evento")
public class EventoController {

    @Autowired 
    private EventoRepository repositorio;
    @Autowired 
    private MontanhaRepository repositorioMontanha;


    @GetMapping
    public List<EventoResponseDTO> listarTodos() {
        List<Evento> eventoRes = repositorio.findAll();
        List<EventoResponseDTO> eventosDto = new ArrayList<>();
        for (Evento evento : eventoRes) {
            eventosDto.add(new EventoResponseDTO(evento));
        }
        return  eventosDto;
    }
    @GetMapping("/{id}")
    public Evento listarPorId(@PathVariable String id) {
        return repositorio.findById(id).orElse(null);
    }

    @PostMapping
    public EventoResponseDTO criarEvento(@RequestBody EventoRequestDTO dto) {
        Montanha montanha = repositorioMontanha.findByNome
        (dto.getMontanhaNome()).orElse(null);
        Evento evento = new Evento(dto , montanha);
        Evento salvo = repositorio.save(evento);

        return new EventoResponseDTO(salvo);
        
    }
    

    @DeleteMapping("/{id}")
    public void excluirPorId (@PathVariable String id){
        repositorio.deleteById(id);
    }
    
    
    
    
    
}
