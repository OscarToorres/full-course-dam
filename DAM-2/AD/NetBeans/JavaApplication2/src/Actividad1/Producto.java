package Actividad1;

import java.io.Serializable;

public class Producto implements Serializable{
    
    private Integer idProducto;
    private String descricion;
    private Double precio;

    public Producto() {
    }

    public Producto(Integer idProducto, String descricion, Double precio) {
        this.idProducto = idProducto;
        this.descricion = descricion;
        this.precio = precio;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getDescricion() {
        return descricion;
    }

    public void setDescricion(String descricion) {
        this.descricion = descricion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Producto{" + "idProducto=" + idProducto + ", descricion=" + descricion + ", precio=" + precio + '}';
    }
    
}
