package com.praticando.tere_verde.shared;

import com.praticando.tere_verde.model.Evento;

public class EventoResponseDTO {


    private String nome;
    private String dataInicio;
    private String dataFim;
    private MontanhaResumoDTO montanha;

    public EventoResponseDTO (Evento evento){
        this.nome = evento.getNome();
        this.dataInicio = evento.getDataInicio();
        this.dataFim = evento.getDataFim();
        this.montanha = new MontanhaResumoDTO(evento.getMontanha());
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
    public MontanhaResumoDTO getMontanha() {
        return montanha;
    }
    public void setMontanha(MontanhaResumoDTO montanha) {
        this.montanha = montanha;
    }

}
