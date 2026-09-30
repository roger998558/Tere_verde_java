package com.praticando.tere_verde.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity 
public class Montanha {
    @Id 
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String nome;
    private String descricao;
    private String dificuldade ;



    public  Montanha (){

    }

    public Montanha (String nome,String descriçao,String dificuldade){
        this.nome = nome;
        this.descricao = descriçao;
        this.dificuldade = dificuldade;

    }



    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescriçao(String descriçao) {
        this.descricao = descriçao;
    }
    public String getDificuldade() {
        return dificuldade;
    }
    public void setDificuldade(String dificuldade) {
        this.dificuldade = dificuldade;
    }

    
}
