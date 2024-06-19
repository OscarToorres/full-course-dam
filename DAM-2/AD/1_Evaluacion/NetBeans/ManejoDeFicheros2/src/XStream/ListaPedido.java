package XStream;

import java.util.ArrayList;
import java.util.List;

import SerializaProducto.Pedido;

public class ListaPedido {

    private List<Pedido> pedidos = new ArrayList<>();

    public ListaPedido() {
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }   

    @Override
    public String toString() {
        return "ListaPedido{" + "pedidos=" + pedidos + '}';
    }
    
    
}
