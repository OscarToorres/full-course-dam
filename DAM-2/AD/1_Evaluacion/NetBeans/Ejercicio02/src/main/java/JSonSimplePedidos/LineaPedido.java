/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JSonSimplePedidos;

/**
 *
 * @author solda
 */
public class LineaPedido {
    
    private Producto producto;
    private long cantidad;
    private long prezoTotal;

    public LineaPedido(Producto producto, long cantidad, long prezoTotal) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.prezoTotal = prezoTotal;
    }

    public LineaPedido() {
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public long getCantidad() {
        return cantidad;
    }

    public void setCantidad(long cantidad) {
        this.cantidad = cantidad;
    }

    public long getPrezoTotal() {
        return prezoTotal;
    }

    public void setPrezoTotal(long prezoTotal) {
        this.prezoTotal = prezoTotal;
    }

    @Override
    public String toString() {
        return "LineaPedido{" + "producto=" + producto + ", cantidad=" + cantidad + ", prezoTotal=" + prezoTotal + '}';
    }
}