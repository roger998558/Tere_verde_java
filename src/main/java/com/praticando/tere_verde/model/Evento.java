package com.praticando.tere_verde.model;

import com.praticando.tere_verde.shared.EventoRequestDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity 
public class Evento {


    @Id 
    @GeneratedValue (strategy = GenerationType.UUID)
    private String id;
    private String nome;
    private String dataInicio;
    private String dataFim;
    @ManyToOne 
    private Montanha montanha;

    public  Evento (){

    }

    public  Evento (String nome,String dataInicio,String dataFim,Montanha montanha){
        this.nome = nome;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.montanha = montanha;
    }


     public  Evento (EventoRequestDTO dto , Montanha montanha){
        this.nome = dto.getNome();
        this.dataInicio = dto.getDataInicio();
        this.dataFim = dto.getDataFim();
        this.montanha = montanha;
     }




    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getDataInicio() {
        return dataInicio;
    }
    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }
    public String getDataFim() {
        return dataFim;
    }
    public void setDataFim(String dataFim) {
        this.dataFim = dataFim;
    }
    public Montanha getMontanha() {
        return montanha;
    }
    public void setMontanha(Montanha montanha) {
        this.montanha = montanha;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
}
