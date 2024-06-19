/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JSonSimpleGestion;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author solda
 */
public class ListaContacto {
    
    List<Contacto> contactos;

    public ListaContacto() {
        contactos = new ArrayList<>();
    }

    public List<Contacto> getContactos() {
        return contactos;
    }

    public void setContactos(List<Contacto> contactos) {
        this.contactos = contactos;
    }

    @Override
    public String toString() {
        return "ListaContacto{" + "contactos=" + contactos + '}';
    }
}