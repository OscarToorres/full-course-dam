package Main;

import Agenda.CrearAgenda;
import Agenda.ProcesaAgenda;
import Agenda.UtilidadesXML;
import Libros.Libro;
import Libros.UtilidadesLibro;
import SerializaProducto.DatosProducto;
import SerializaProducto.Pedido;
import SerializaProducto.Producto;
import XStream.DocumentoConXStream;
import XmlProducto.CrearXmlPedidos;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.transform.TransformerConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author dam220
 */
public class Main {

    public static void main(String[] args) throws IOException, FileNotFoundException, TransformerConfigurationException {
        
//        ArrayList<Pedido> listaPedidos = new ArrayList<>();     
//        ArrayList<Producto> listaProductos = new ArrayList<>();
//        CrearXmlPedidos crearXmlPedidos = new CrearXmlPedidos();
//        DatosProducto dProducto = new DatosProducto();
//        UtilidadesXML utilidades = new UtilidadesXML();
//        CrearAgenda agenda = new CrearAgenda();
//        ProcesaAgenda procesar = new ProcesaAgenda();
        DocumentoConXStream xstream = new DocumentoConXStream();
//        String archivo1 = "pedidos.dat";
//        String archivo2 = "productos.dat";

//        Document doc;
//        Element e;
       
//        listaPedidos = crearXmlPedidos.generarListaPedidos();
//        crearXmlPedidos.guardarListaPedidos(listaPedidos,archivo1);
//        listaProductos = dProducto.generarLista();
//        crearXmlPedidos.guardarListaProductos(listaProductos, archivo2);
//        crearXmlPedidos.lePedidos(archivo);
//        
//        doc = crearXmlPedidos.generaXmlPedidos(listaPedidos,archivo);
//        crearXmlPedidos.mostrarXml(doc.getDocumentElement());

        /*
        Para trabajar con un documento tiene que estar en DOM y a partir 
        de ahi podemos trabajar en el, como crear nuevos elementos y añadirlos
        o borrarlos. Una vez hayamos acabado de trabajar con el lo tendremos que
        a pasar a XML para guardarlo.
        */
//        doc = utilidades.crearDOMBacio("pruebas");
//        e = utilidades.crearElementoTexto("prueba", "Esto es una prueba", doc);
//        utilidades.DOMaXML(doc, "prueba.xml");
//        utilidades.mostrarContenidoElemento(e);
//        doc = utilidades.borrarElementosEtiqueta("prueba", doc);
//        utilidades.DOMaXML(doc, "prueba2.xml");

        //agenda.generarAgenda();
        //procesar.procesarAgenda();
        xstream.generarXML();

            

    }  
}
