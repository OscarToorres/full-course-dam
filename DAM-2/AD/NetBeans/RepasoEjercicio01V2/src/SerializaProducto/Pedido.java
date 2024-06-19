package SerializaProducto;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author dam220
 */
public class Pedido implements Serializable {
    
    private Integer idPedido;
    private String nomeCliente;
    private ArrayList<Producto> productos;

    public Pedido(Integer idPedido, String nomeCliente, ArrayList<Producto> productos) {
        this.idPedido = idPedido;
        this.nomeCliente = nomeCliente;
        this.productos = productos;
    }

    public Integer getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Integer idPedido) {
        this.idPedido = idPedido;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }

    @Override
    public String toString() {
        return "Pedido{" + "idPedido=" + idPedido + ", nomeCliente=" + nomeCliente + ", productos=" + productos + '}';
    }
      
    
}
