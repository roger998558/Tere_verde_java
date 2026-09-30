package com.praticando.tere_verde.shared;

import com.praticando.tere_verde.model.Montanha;

public class MontanhaResumoDTO {

    private  String nome;
    private String descricao; 
    private String dificuldade;


public MontanhaResumoDTO (Montanha montanha ){
 this.nome = montanha.getNome();
 this.descricao = montanha.getDescricao();
 this.dificuldade = montanha.getDificuldade(); 

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
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public String getDificuldade() {
        return dificuldade;
    }
    public void setDificuldade(String dificuldade) {
        this.dificuldade = dificuldade;
    }
    
}
