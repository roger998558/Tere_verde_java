package com.praticando.tere_verde.controller;

import java.util.List;
import org.hibernate.annotations.Audited;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.praticando.tere_verde.model.Montanha;
import com.praticando.tere_verde.repositorio.MontanhaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController 
@RequestMapping("/Montanha")
public class MontanhaController {
    @Autowired 
    private  MontanhaRepository repositorio;

    @GetMapping
    public List<Montanha> listartodos() {
        return repositorio.findAll() ;
    }
    
    @GetMapping("/{id}")
    public Montanha listarPorId(@PathVariable String  id) {
        return repositorio.findById(id).orElse(null);
    }

    @PostMapping
    public Montanha criarMontanha(@RequestBody Montanha entity) {
         return  repositorio.save(entity);
    }

    @PutMapping("/{id}")
    public Montanha putMethodName(@PathVariable String id, @RequestBody Montanha entity) {
        entity.setId(id);
        return repositorio.save(entity);
    }
    @DeleteMapping("/{id}")
    public void deletarPorId (@PathVariable String id){
        repositorio.deleteById(id);
    }
    
    
}
