package SerializaProducto;

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

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getDescricion() {
        return descricion;
    }

    public void setDescricion(String descricion) {
        this.descricion = descricion;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Producto{" + "idProducto=" + idProducto + ", descricion=" + descricion + ", precio=" + precio + '}';
    }


    
}