/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.leliadoura.ad.eva1parcial1.ejercicio3;

import es.leliadoura.ad.eva1parcial1.data.Modulo;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dam2ad
 */
public class ListaModulos {
    
    private List<Modulo> modulos;

    public ListaModulos() {
        this.modulos = new ArrayList<>();
      
    }

    public List<Modulo> getModulos() {
        return modulos;
    }

    public void setModulos(List<Modulo> modulos) {
        this.modulos = modulos;
    }

    @Override
    public String toString() {
        return "ListaModulos{" + "modulos=" + modulos + '}';
    }
    
    
}
