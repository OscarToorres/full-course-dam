package com.example.practica05;

public class Cita {

    private String id;
    private String fehca;
    private String hora;
    private String asunto;

    public Cita(String id, String fehca, String hora, String asunto) {
        this.id = id;
        this.fehca = fehca;
        this.hora = hora;
        this.asunto = asunto;
    }
    public Cita() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFehca() {
        return fehca;
    }

    public void setFehca(String fehca) {
        this.fehca = fehca;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    @Override
    public String toString() {
        return "Cita{" +
                "id='" + id + '\'' +
                ", fehca='" + fehca + '\'' +
                ", hora='" + hora + '\'' +
                ", asunto='" + asunto + '\'' +
                '}';
    }
}
