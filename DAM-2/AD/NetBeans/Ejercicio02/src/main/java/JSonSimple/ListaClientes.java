/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JSonSimple;

import java.util.ArrayList;

/**
 *
 * @author solda
 */
public class ListaClientes {
    
    private ArrayList<Cliente> clientes;

    public ListaClientes() {
        this.clientes = new ArrayList<>();
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

    @Override
    public String toString() {
        return "ListaClientes{" + "clientes=" + clientes + '}';
    }
    
    
    
    
    
}
