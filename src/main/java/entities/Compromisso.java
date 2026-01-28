package entities;

import enums.Prioridade;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Compromisso {

    private UUID id;
    private String titulo;
    private LocalDate data;
    private LocalTime hora;
    private Prioridade prioridade;
    private List<Paticipante> paticipantes;


    public Compromisso() {
        this.paticipantes = new ArrayList<>();
    }

    public Compromisso(UUID id, String titulo, LocalDate data, LocalTime hora, Prioridade prioridade){
        this();
        this.id = id;
        this.titulo = titulo;
        this.data = data;
        this.hora = hora;
        this.prioridade = prioridade;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public Prioridade getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(Prioridade prioridade) {
        this.prioridade = prioridade;
    }

    public List<Paticipante> getPaticipantes() {
        return paticipantes;
    }

    public void adicionarPaticipante(Paticipante paticipante){
        this.paticipantes.add(paticipante);
    }
}
