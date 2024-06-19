/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JSonSimplePedidos;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author solda
 */
public class Pedido {

    private long id;
    private Cliente cliente;
    private List<LineaPedido> lineasPedido;
    private long importe;
    private boolean entregaado;

    public Pedido() {
        lineasPedido = new ArrayList<>();
    }

    public Pedido(long id, Cliente cliente, List<LineaPedido> lineasPedido, long numero, boolean entregaado) {
        this.id = id;
        this.cliente = cliente;
        this.lineasPedido = lineasPedido;
        this.importe = numero;
        this.entregaado = entregaado;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<LineaPedido> getLineasPedido() {
        return lineasPedido;
    }

    public void setLineasPedido(List<LineaPedido> lineasPedido) {
        this.lineasPedido = lineasPedido;
    }

    public long getNumero() {
        return importe;
    }

    public void setNumero(long numero) {
        this.importe = numero;
    }

    public boolean isEntregaado() {
        return entregaado;
    }

    public void setEntregaado(boolean entregaado) {
        this.entregaado = entregaado;
    }

    @Override
    public String toString() {
        return "Pedido{" + "id=" + id + ", cliente=" + cliente + ", lineasPedido=" + lineasPedido + ", numero=" + importe + ", entregaado=" + entregaado + '}';
    }

}
