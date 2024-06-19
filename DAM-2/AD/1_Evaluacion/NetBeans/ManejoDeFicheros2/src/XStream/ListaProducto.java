package XStream;

import java.util.ArrayList;
import java.util.List;

import SerializaProducto.Producto;

public class ListaProducto {

    private List<Producto> productos = new ArrayList<>();

    public ListaProducto() {
    }

    public List<Producto> getPedidos() {
        return productos;
    }

    public void setPedidos(List<Producto> productos) {
        this.productos = productos;
    }   
}
