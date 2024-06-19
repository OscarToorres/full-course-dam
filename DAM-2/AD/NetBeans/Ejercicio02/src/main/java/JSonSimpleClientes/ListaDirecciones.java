/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JSonSimpleClientes;

import java.util.ArrayList;

/**
 *
 * @author solda
 */
public class ListaDirecciones {
    
    private ArrayList<Direccion> direcciones;

    public ListaDirecciones() {
        this.direcciones = new ArrayList<>();
    }

    public ArrayList<Direccion> getDirecciones() {
        return direcciones;
    }

    public void setDirecciones(ArrayList<Direccion> direcciones) {
        this.direcciones = direcciones;
    }

    @Override
    public String toString() {
        return "ListaDirecciones{" + "direcciones=" + direcciones + '}';
    }
}
