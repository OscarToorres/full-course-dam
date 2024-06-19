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
public class Contacto extends ClienteG implements Serializable {

    private Enderezo enderezo;

    public Contacto(Enderezo enderezo, String dni, String nombre, String apellidos) {
        super(dni, nombre, apellidos);
        this.enderezo = enderezo;
    }

    public Contacto() {
    }

    public Enderezo getEnderezo() {
        return enderezo;
    }

    public void setEnderezo(Enderezo enderezo) {
        this.enderezo = enderezo;
    }

    @Override
    public String toString() {
        return "Contacto{" + "enderezo=" + enderezo + "cliente=" + super.toString() + '}';
    }   
}
