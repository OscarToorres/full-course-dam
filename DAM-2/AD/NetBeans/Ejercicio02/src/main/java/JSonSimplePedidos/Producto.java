/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JSonSimplePedidos;

/**
 *
 * @author solda
 */
public class Producto {

    private long id;
    private String nomeProducto;
    private String descripcion;
    private String foto;
    private long prezo;

    public Producto(long id, String nomeProducto, String descripcion, String foto, long prezo) {
        this.id = id;
        this.nomeProducto = nomeProducto;
        this.descripcion = descripcion;
        this.foto = foto;
        this.prezo = prezo;
    }

    public Producto() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNomeProducto() {
        return nomeProducto;
    }

    public void setNomeProducto(String nomeProducto) {
        this.nomeProducto = nomeProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public long getPrezo() {
        return prezo;
    }

    public void setPrezo(long prezo) {
        this.prezo = prezo;
    }

    @Override
    public String toString() {
        return "Producto{" + "id=" + id + ", nomeProducto=" + nomeProducto + ", descripcion=" + descripcion + ", foto=" + foto + ", prezo=" + prezo + '}';
    }
}