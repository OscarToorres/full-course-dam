/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JSonSimpleGestion;

import java.io.Serializable;

/**
 *
 * @author solda
 */
public class Enderezo implements Serializable{
    
    private String localidad;
    private String calle;
    private long numero;

    public Enderezo(String localidad, String calle, long numero) {
        this.localidad = localidad;
        this.calle = calle;
        this.numero = numero;
    }

    public Enderezo() {
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public long getNumero() {
        return numero;
    }

    public void setNumero(long numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "Enderezo{" + "localidad=" + localidad + ", calle=" + calle + ", numero=" + numero + '}';
    }
}