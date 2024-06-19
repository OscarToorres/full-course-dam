/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package XMLProducto;

import MainRepasoejercicio01v2.RepasoEjercicio01V2;
import SerializaProducto.DatosProducto;
import SerializaProducto.Pedido;
import SerializaProducto.Producto;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import static javax.xml.transform.OutputKeys.INDENT;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

/**
 *
 * @author dam220
 */
public class CrearXmlPedidos {

    public ArrayList<Pedido> generarListaPedidos() {
        //Creacion de objetos para la lista
        ArrayList<Pedido> pedidos = new ArrayList<>();
        DatosProducto datosP = new DatosProducto();
        ArrayList<Producto> datosProdutos = new ArrayList<>();

        ArrayList<Producto> listaProductos1 = new ArrayList<>();
        ArrayList<Producto> listaProductos2 = new ArrayList<>();

        datosProdutos = datosP.generarLista();

        listaProductos1.add(datosProdutos.get(0));
        listaProductos1.add(datosProdutos.get(1));

        listaProductos2.add(datosProdutos.get(2));
        listaProductos2.add(datosProdutos.get(3));
        listaProductos2.add(datosProdutos.get(4));

        pedidos.add(new Pedido(1, "Luis", listaProductos1));
        pedidos.add(new Pedido(2, "Oscar", listaProductos2));

        return pedidos;
    }

    public void guardaListaPedidos(ArrayList<Pedido> pedidos, String ruta) {
        File file = new File(ruta);

        try {
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            for (Pedido ped : pedidos) {
                oos.writeObject(ped);
            }

            oos.close();
            fos.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(CrearXmlPedidos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CrearXmlPedidos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public ArrayList<Pedido> lePedidos(String ruta) {
        ArrayList<Pedido> pedidos = new ArrayList<>();

        try {
            FileInputStream fis = new FileInputStream(ruta);
            ObjectInputStream ois = new ObjectInputStream(fis);

            Pedido pedido = null;
            while (fis.available() > 0) {
                pedido = (Pedido) ois.readObject();
                pedidos.add(pedido);
            }

            ois.close();
            fis.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(CrearXmlPedidos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CrearXmlPedidos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CrearXmlPedidos.class.getName()).log(Level.SEVERE, null, ex);
        }

        return pedidos;

    }

    public Document generarXmlPedidos(ArrayList<Pedido> pedidos, String ruta) {

        //Crear documento DOM
        Document doc = null;
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            DOMImplementation implementacion = db.getDOMImplementation();
            doc = implementacion.createDocument(null, "pedidos", null);
            doc.setXmlVersion("1.0");

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(RepasoEjercicio01V2.class.getName()).log(Level.SEVERE, null, ex);
        }

        //Pasar a XML
        Element raiz = doc.getDocumentElement();

        for (Pedido ped : pedidos) {
            Element pedido = doc.createElement("pedido");
            raiz.appendChild(pedido);

            Element idPedido = doc.createElement("idPedido");
            idPedido.setTextContent(ped.getIdPedido().toString());
            pedido.appendChild(idPedido);

            Element nomeCliente = doc.createElement("nomeCliente");
            nomeCliente.setTextContent(ped.getNomeCliente());
            pedido.appendChild(nomeCliente);

            Element productos = doc.createElement("productos");
            pedido.appendChild(productos);

            for (Producto pro : ped.getProductos()) {
                Element producto = doc.createElement("producto");
                productos.appendChild(producto);

                Element idProducto = doc.createElement("idProducto");
                idProducto.setTextContent(pro.getIdProducto().toString());
                producto.appendChild(idProducto);

                Element descricion = doc.createElement("descricion");
                descricion.setTextContent(pro.getDescricion());
                producto.appendChild(descricion);

                Element precio = doc.createElement("precio");
                precio.setTextContent(pro.getPrecio().toString());
                producto.appendChild(precio);

            }
        }

        //Pasar de DOM a XML
        File file = new File(ruta);

        try {
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            StreamResult result = new StreamResult(file);
            DOMSource source = new DOMSource(doc);
            transformer.setOutputProperty(INDENT, "yes");
            transformer.transform(source, result);

        } catch (TransformerConfigurationException ex) {
            Logger.getLogger(RepasoEjercicio01V2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(RepasoEjercicio01V2.class.getName()).log(Level.SEVERE, null, ex);
        }

        return doc;
    }

    public void leerXML(Node nodo) {

        switch (nodo.getNodeType()) {
            case Node.ELEMENT_NODE:
                Element elemento = (Element) nodo;
                System.out.println("Etiqueta: " + elemento.getNodeName());
                NodeList nl = nodo.getChildNodes();
                for (int i = 0; i < nl.getLength(); i++) {
                    this.leerXML(nl.item(i));
                }
                break;
            case Node.TEXT_NODE:
                Text texto = (Text) nodo;
                System.out.println("Texto: " + texto.getWholeText());
                break;

        }
    }  
}
