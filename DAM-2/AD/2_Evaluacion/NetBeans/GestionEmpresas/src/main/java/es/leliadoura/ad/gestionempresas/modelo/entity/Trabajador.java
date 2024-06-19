/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.leliadoura.ad.gestionempresas.modelo.entity;

import jakarta.persistence.*;

/**
 *
 * @author marco
 */
@Entity
@Table(name="trabajador")
public class Trabajador {

    @Id
    @Column(name="dni")
    private String dni;
    @Column(name="nombre ")
    private String nombre;
    @Column(name="apellidos")
    private String apellidos;
    @Column(name="iban")
    private String iban;
    @Column(name="segSocial")
    private String segSocial;
    @Column(name="correo", unique = true)
    private String correo;
    @Column(name="telefono", unique = true)
    private Integer telefono;

    public Trabajador() {
    }

    public Trabajador(String dni, String nombre, String apellidos, String iban, String segSocial, String correo, Integer telefono) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.iban = iban;
        this.segSocial = segSocial;
        this.correo = correo;
        this.telefono = telefono;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getSegSocial() {
        return segSocial;
    }

    public void setSegSocial(String segSocial) {
        this.segSocial = segSocial;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Trabajador{" + "dni=" + dni + ", nombre=" + nombre + ", apellidos=" + apellidos + ", iban=" + iban + ", segSocial=" + segSocial + ", correo=" + correo + ", telefono=" + telefono + '}';
    }
}
