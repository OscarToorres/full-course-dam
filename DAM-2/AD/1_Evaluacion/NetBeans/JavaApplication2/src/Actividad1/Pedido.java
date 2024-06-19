package Actividad1;

import java.util.ArrayList;

/**
 *
 * @author dam220
 */
public class Pedido {
   
    private int idPedido;
    private String nomeCliente;
    private ArrayList<Producto> productos;

    public Pedido(int idPedido, String nomeCliente) {
        this.idPedido = idPedido;
        this.nomeCliente = nomeCliente;
    }

    public Pedido(int idPedido, String nomeCliente, ArrayList<Producto> productos) {
        this.idPedido = idPedido;
        this.nomeCliente = nomeCliente;
        this.productos = productos;
    }
    
    public Pedido() {
    }
    
    public ArrayList<Pedido> generarPedidos(){
        ArrayList<Pedido> lista = new ArrayList<>();
        Utilidades datos = new Utilidades();
        ArrayList<Producto> listaProductos1 = new ArrayList<>();
        ArrayList<Producto> listaProductos2 = new ArrayList<>();
        ArrayList<Producto> listaProductos3 = new ArrayList<>();
        
        //Generamos los datos de la lista de productos, a diferentes listas 
        listaProductos1 = datos.generarList()
        
        //Se añaden a la lista de productos
                 .
                
    
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
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
    
     
    
    
}
