/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.leliadoura.ad.gestionempresas.modelo.entity;

import jakarta.persistence.*;
import java.util.Date;

/**
 *
 * @author marco
 */
@Entity
@Table(name = "contrato")
public class Contrato {

    @Id
    @GeneratedValue
    private Integer id;
    @Temporal(TemporalType.DATE)
    @Column(name = "fechaInicio")
    private Date fechaInicio;
    @Temporal(TemporalType.DATE)
    @Column(name = "fechaFin")
    private Date fechaFin;
    @Column(name = "salario")
    private Integer salario;
    @Column(name = "jornada")
    private Integer jornada;
    @ManyToOne
    private Trabajador trabajador;
    @ManyToOne
    private Empresa empresa;

    public Contrato() {
    }

    public Contrato(Date fechaInicio, Date fechaFin, Integer salario, Integer jornada, Trabajador trabajador, Empresa empresa) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.salario = salario;
        this.jornada = jornada;
        this.trabajador = trabajador;
        this.empresa = empresa;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Integer getSalario() {
        return salario;
    }

    public void setSalario(Integer salario) {
        this.salario = salario;
    }

    public Integer getJornada() {
        return jornada;
    }

    public void setJornada(Integer jornada) {
        this.jornada = jornada;
    }

    public Trabajador getTrabajador() {
        return trabajador;
    }

    public void setTrabajador(Trabajador trabajador) {
        this.trabajador = trabajador;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    @Override
    public String toString() {
        return "Contrato{" + "id=" + id + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + ", salario=" + salario + ", jornada=" + jornada + ", trabajador=" + trabajador+ ", empresa=" + empresa + '}';
    }

}
