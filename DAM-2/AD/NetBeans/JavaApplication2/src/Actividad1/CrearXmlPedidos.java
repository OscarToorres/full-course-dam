package Actividad1;

import java.io.IOException;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import Actividad1.Producto;

public class CrearXmlPedidos {
    
    ArrayList<Pedido> listaPedidos;
    String rutaArchivoXML="I:\\DAM 2\\AD\\NetBeans\\JavaApplication2";
    Document doc = null;
    Pedido pedido;
    

    
    public ArrayList generarListaDePedidos(){
        ArrayList<Producto> listaProductos = new ArrayList();
        listaProductos.set(0, new Producto(1, "Tarta", 15));
        Pedido pedido = new Pedido(1, "Manuel", listaProductos );

       return null;

    }
    
    
    public void leerPedidosXml(){
    try{
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        doc = db.parse(rutaArchivoXML);
    }catch (IOException | ParserConfigurationException | SAXException ex){
        System.out.println("Error, no se pudo cargar el documento");
    }
}
    public void crearDocumentoDOM(){
        Document documento = null;

        try{
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            DOMImplementation implementation = db.getDOMImplementation();
            documento.setXmlVersion("1.0");
        }catch(ParserConfigurationException ex){
            System.out.println("Error, No se pudo parsear el XML");
        }
    }

        
}

    
    