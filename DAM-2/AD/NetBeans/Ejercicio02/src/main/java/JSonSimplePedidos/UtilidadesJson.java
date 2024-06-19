/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JSonSimplePedidos;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author solda
 */
public class UtilidadesJson {

    public List<Pedido> generaPedidos() {

        List<Pedido> pedido = new ArrayList<>();
        List<LineaPedido> lineaPedido1 = new ArrayList<>();
        List<LineaPedido> lineaPedido2 = new ArrayList<>();

        Cliente clt1 = new Cliente("11111111A", "Borja", "Silva Martinez");
        Cliente clt2 = new Cliente("22222222B", "Ivan", "Fernandez Triñans");

        Producto pro1 = new Producto(1, "Raton", "Alta respuesta", "foto1", 50);
        Producto pro2 = new Producto(2, "Teclado", "Razer 23GA", "foto2", 25);
        Producto pro3 = new Producto(3, "Monitor", "Alta respuesta y resolucion", "foto3", 350);
        Producto pro4 = new Producto(4, "Ordenador", "PC completo sin grafica", "foto4", 1050);
        Producto pro5 = new Producto(5, "Grafica", "NVidia RTX3090 TI 16GB", "foto5", 400);

        lineaPedido1.add(new LineaPedido(pro1, 1, 50));
        lineaPedido1.add(new LineaPedido(pro2, 1, 25));
        lineaPedido1.add(new LineaPedido(pro3, 2, 700));

        lineaPedido2.add(new LineaPedido(pro4, 1, 1050));
        lineaPedido2.add(new LineaPedido(pro5, 2, 400));

        pedido.add(new Pedido(1, clt1, lineaPedido1, 775, false));
        pedido.add(new Pedido(2, clt2, lineaPedido2, 1450, true));

        return pedido;
    }

    public JSONArray crearJsonObjects(List<Pedido> pedidos) {
        JSONArray jarrayPedidos = new JSONArray();
        for (Pedido ped : pedidos) {
            jarrayPedidos.add(this.crearObjectsPedidos(ped));
        }
        return jarrayPedidos;
    }

    private JSONObject crearObjectsPedidos(Pedido pedido) {
        JSONObject objetoPedido = new JSONObject();

        objetoPedido.put("id", pedido.getId());
        objetoPedido.put("cliente", this.crearObjectsCliente(pedido.getCliente()));

        JSONArray arrayLineaProductos = new JSONArray();
        for (LineaPedido lPed : pedido.getLineasPedido()) {
            arrayLineaProductos.add(this.crearObjectsLineaPedido(lPed));
        }
        objetoPedido.put("lineaPedido", arrayLineaProductos);
        objetoPedido.put("importe", pedido.getNumero());
        objetoPedido.put("entregado", pedido.isEntregaado());

        return objetoPedido;
    }

    private JSONObject crearObjectsCliente(Cliente cliente) {
        JSONObject objetoCliente = new JSONObject();

        objetoCliente.put("dni", cliente.getDni());
        objetoCliente.put("nombre", cliente.getNombre());
        objetoCliente.put("apellidos", cliente.getApellidos());

        return objetoCliente;
    }

    private JSONObject crearObjectsLineaPedido(LineaPedido lPedido) {
        JSONObject objectLineaPedido = new JSONObject();

        objectLineaPedido.put("producto", this.crearObjectsProducto(lPedido.getProducto()));
        objectLineaPedido.put("cantidad", lPedido.getCantidad());
        objectLineaPedido.put("precioTotal", lPedido.getPrezoTotal());

        return objectLineaPedido;
    }

    private JSONObject crearObjectsProducto(Producto producto) {
        JSONObject objectProducto = new JSONObject();

        objectProducto.put("id", producto.getId());
        objectProducto.put("nomeProducto", producto.getNomeProducto());
        objectProducto.put("descripcion", producto.getDescripcion());
        objectProducto.put("foto", producto.getFoto());
        objectProducto.put("precio", producto.getPrezo());

        return objectProducto;
    }

    public void crearDocumentoJson(JSONArray pedidos, String ruta) {

        try ( FileWriter fw = new FileWriter(ruta)) {
            fw.write(pedidos.toJSONString());
            fw.close();
        } catch (IOException ex) {
            Logger.getLogger(UtilidadesJson.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Pedido> leeJsonPedidos(String ruta) {
        JSONParser parser = new JSONParser();
        List<Pedido> pedidos = new ArrayList<>();

        try {
            FileReader fr = new FileReader(ruta);
            JSONArray arrayPedidos = (JSONArray) parser.parse(fr);

            for (int i = 0; i < arrayPedidos.size(); i++) {
                JSONObject objPedido = (JSONObject) arrayPedidos.get(i);

                pedidos.add(this.leeJSonPedidos(objPedido));
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(UtilidadesJson.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | ParseException ex) {
            Logger.getLogger(UtilidadesJson.class.getName()).log(Level.SEVERE, null, ex);
        }

        return pedidos;
    }

    private Cliente leJSonCLiente(JSONObject objCliente) {
        Cliente cliente = new Cliente();

        cliente.setApellidos((String) objCliente.get("apellidos"));
        cliente.setDni((String) objCliente.get("dni"));
        cliente.setNombre((String) objCliente.get("nombre"));

        return cliente;
    }

    private Producto leeJSonProducto(JSONObject objProducto) {
        Producto producto = new Producto();

        producto.setDescripcion((String) objProducto.get("descripcion"));
        producto.setFoto((String) objProducto.get("foto"));
        producto.setId((long) objProducto.get("id"));
        producto.setNomeProducto((String) objProducto.get("nomeProducto"));
        producto.setPrezo((long) objProducto.get("precio"));

        return producto;
    }

    private LineaPedido leeJSonLineaPedido(JSONObject objLineaProducto) {
        LineaPedido lPedido = new LineaPedido();

        JSONObject objProducto = (JSONObject) objLineaProducto.get("producto");

        lPedido.setProducto(this.leeJSonProducto(objProducto));
        lPedido.setCantidad((long) objLineaProducto.get("cantidad"));
        lPedido.setPrezoTotal((long) objLineaProducto.get("precioTotal"));

        return lPedido;
    }

    private Pedido leeJSonPedidos(JSONObject objPedido) {
        Pedido pedido = new Pedido();
        pedido.setId((long) objPedido.get("id"));
        pedido.setEntregaado((boolean) objPedido.get("entregado"));
        pedido.setNumero((long) objPedido.get("importe"));

        JSONObject objCliente = (JSONObject) objPedido.get("cliente");

        pedido.setCliente(this.leJSonCLiente(objCliente));

        JSONArray objLineaPedido = (JSONArray) objPedido.get("lineaPedido");
        List<LineaPedido> productos = new ArrayList<>();
        for (int j = 0; j < objLineaPedido.size(); j++) {
            JSONObject objLineaProducto = (JSONObject) objLineaPedido.get(j);
            JSONObject objProducto = (JSONObject) objLineaProducto.get("producto");

            productos.add(this.leeJSonLineaPedido(objLineaProducto));
        }
        pedido.setLineasPedido(productos);

        return pedido;
    }

    public void MostraJsonPedidos(String ruta) {
        List<Pedido> pedidos = new ArrayList<>();
        pedidos = this.leeJsonPedidos(ruta);
        for (int i = 0; i < pedidos.size(); i++) {
            Pedido pedido = new Pedido();
            pedido = pedidos.get(i);
        }

    }

}
