/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package MainRepasoejercicio01v2;

import Agenda.CrearAgenda;
import Agenda.UtilidadesAgenda;
import SerializaProducto.DatosProducto;
import SerializaProducto.Pedido;
import SerializaProducto.Producto;
import SerializaProducto.UtilidadesProducto;
import XMLProducto.CrearXmlPedidos;
import java.util.ArrayList;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

/**
 *
 * @author dam220
 */
public class RepasoEjercicio01V2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        UtilidadesProducto utilidades = new UtilidadesProducto();
        DatosProducto datos = new DatosProducto();
        CrearXmlPedidos crearXml = new CrearXmlPedidos();
        UtilidadesAgenda agenda = new UtilidadesAgenda();
        CrearAgenda crearAgenda = new CrearAgenda();
        ArrayList<Producto> productos = new ArrayList<>();
        ArrayList<Pedido> pedidos = new ArrayList<>();
        Document doc = null;
        String rutaPro = "productos.dat";
        String rutaPed = "pedidos.dat";
        String rutaXml = "pedidosXML.xml";

//        productos = datos.generarLista();
//        utilidades.crearFicheroProductos(productos, rutaPro);
//        utilidades.leerFichero(rutaPro);
        pedidos = crearXml.generarListaPedidos();
//        crearXml.guardaListaPedidos(pedidos, rutaPed);
//        pedidos = crearXml.lePedidos(rutaPed);

//        System.out.println(pedidos);
        doc = crearXml.generarXmlPedidos(pedidos, rutaXml);
        crearXml.leerXML(doc.getDocumentElement());
        
        crearAgenda.generarAgenda();

    }

}
