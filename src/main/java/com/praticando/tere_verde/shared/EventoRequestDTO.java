package com.praticando.tere_verde.shared;



public class EventoRequestDTO {

    private String nome;
    private String dataInicio;
    private String dataFim;
    private String montanhaNome;

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
    public String getMontanhaNome() {
        return montanhaNome;
    }
    public void setMontanhaNome(String montanhaNome) {
        this.montanhaNome = montanhaNome;
    }
    
}