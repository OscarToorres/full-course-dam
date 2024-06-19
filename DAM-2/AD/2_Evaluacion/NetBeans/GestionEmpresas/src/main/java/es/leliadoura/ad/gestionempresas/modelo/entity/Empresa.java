/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.leliadoura.ad.gestionempresas.modelo.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author marco
 */
@Entity
@Table(name="empresa")
public class Empresa {

    @Id
    @Column(name="nif")
    private String nif;
    @Column(name="razonSocial")
    private String razonSocial;
    @Column(name="iban")
    private String iban;
    @OneToMany
    private List<Contacto> contactos;
  
    public Empresa() {
        this.contactos = new ArrayList<>();
    }

    public Empresa(String nif, String razonSocial, String iban, List<Contacto> contactos) {
        this.nif = nif;
        this.razonSocial = razonSocial;
        this.iban = iban;
        this.contactos = contactos;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public List<Contacto> getContactos() {
        return contactos;
    }

    public void setContactos(List<Contacto> contactos) {
        this.contactos = contactos;
    }

    @Override
    public String toString() {
        return "Empresa{" + "nif=" + nif + ", razonSocial=" + razonSocial + ", iban=" + iban + ", contactos=" + contactos + '}';
    }
}