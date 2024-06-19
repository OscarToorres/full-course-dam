package XmlProducto;

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
import javax.xml.transform.Transformer;
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
    
    
    //Creacion de objetos para la escritura y lectura
    FileInputStream fis;
    ObjectInputStream ois;
    
       
    public ArrayList<Pedido> generarListaPedidos(){
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
    
    public void guardarListaPedidos(ArrayList<Pedido> pedidos, String archivo) {

        try {
            FileOutputStream fos = new FileOutputStream(archivo);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            
            for (Pedido ped: pedidos){
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
    
        public void guardarListaProductos(ArrayList<Producto> productos, String archivo) {

        try {
            FileOutputStream fos = new FileOutputStream(archivo);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            
            for (Producto prod: productos){
                oos.writeObject(prod);
            }
            
            oos.close();
            fos.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(CrearXmlPedidos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CrearXmlPedidos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //Para mostrarlos usaremos el mismo metodo que lePedidos, ya que 
    //comparten el mismo codigo
    public void mostrarPedidos (String archivo){   
        ArrayList<Pedido> pedidos = new ArrayList<>();
        pedidos = lePedidos(archivo);
        System.out.println(pedidos);
    }

    public ArrayList<Pedido> lePedidos(String archivo){
               
        ArrayList<Pedido> listaPedidos = new ArrayList<>();

        try{   
        FileInputStream fis = new FileInputStream(archivo);
        ObjectInputStream ois = new ObjectInputStream(fis);
        
            Pedido pedido = null;
            
            while(fis.available() > 0){
                pedido = (Pedido) ois.readObject();
                listaPedidos.add(pedido);
                
                System.out.println(pedido);
            }
            
            ois.close();
            fis.close();
            
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        
        return listaPedidos;  
    }
    
    public ArrayList<Producto> leProductos(String archivo){
               
        ArrayList<Producto> listaProductos = new ArrayList<>();

        try{   
        FileInputStream fis = new FileInputStream(archivo);
        ObjectInputStream ois = new ObjectInputStream(fis);
        
            Producto producto = null;
            
            while(fis.available() > 0){
                producto = (Producto) ois.readObject();
                listaProductos.add(producto);
                
                System.out.println(producto);
            }
            
            ois.close();
            fis.close();
            
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        
        return listaProductos;  
    }
    
    public Document generaXmlPedidos(ArrayList<Pedido> pedidos, String archivo){
        
        String rutaArchivoXml = "D:\\Prueba\\ArchivoXml.xml";
        //Importar la de w3c para trabajar con el xml
        Document doc = null;
        
        try {
            //Creacion del documento DOM
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            DOMImplementation implementacion = db.getDOMImplementation();
            doc = implementacion.createDocument(null, "pedidos", null);
            doc.setXmlVersion("1.0");
            
            //Obtencion del elemtno raiz del documetno
            Element raiz = doc.getDocumentElement();
            
            //Creacion de los nodos y el documento DOM
            for(Pedido ped : pedidos){
                Element pedido = doc.createElement("pedido");
                doc.getDocumentElement().appendChild(pedido);//Se le indica de quien es hijo el elemento

                Element idPedido = doc.createElement("idPedido"); //Creacion del nuevo elemento
                Text textoIdPedido = doc.createTextNode(ped.getIdPedido().toString()); // texto del nuevo elemento
                idPedido.appendChild(textoIdPedido); //Se le añade el texto al elemento            

                Element nomeCliente = doc.createElement("nomeCliente");
                Text textoNomeCliente = doc.createTextNode(ped.getNomeCliente());
                nomeCliente.appendChild(textoNomeCliente);
                
                Element productos = doc.createElement("productos");
  
                for(Producto prod : ped.getProductos()) {

                    Element producto = doc.createElement("producto");

                    Element idProducto = doc.createElement("idProducto");
                    Text textoIdProducto = doc.createTextNode(prod.getIdProducto().toString());
                    idProducto.appendChild(textoIdProducto);

                    Element descripcion = doc.createElement("descripcion");
                    Text textoDescripcion = doc.createTextNode(prod.getDescricion());
                    descripcion.appendChild(textoDescripcion);

                    Element precio = doc.createElement("precio");
                    Text textoPrecio = doc.createTextNode(prod.getPrecio().toString());
                    precio.appendChild(textoPrecio);
                    
                    productos.appendChild(producto); 
                    producto.appendChild(idProducto);
                    producto.appendChild(descripcion);
                    producto.appendChild(precio);
                   
                }

                //Añadir los elementos al documento
                raiz.appendChild(pedido);//Se le indica que hijos tiene ese elemento
                pedido.appendChild(idPedido);
                pedido.appendChild(nomeCliente);
                pedido.appendChild(productos); 

                
                 
            }
            //Sirve para idenrtar el documento xml
            //transformer.setOutputProperty(INDENT,"yes"); 
            
        } catch (ParserConfigurationException ex) {
            ex.printStackTrace();
        }
        
        try {
            File f = new File(rutaArchivoXml);
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            StreamResult result = new StreamResult(f);
            DOMSource source = new DOMSource(doc);
            transformer.transform(source, result);
            
        } catch (TransformerException ex) {
            ex.printStackTrace();
        } 
        
        return doc;
    }
    
    //Para crear este metodo hace falta trabajar con recursividad
    //El problema actual es que saca los hijos del elemento raiz
    //Pero no sigue analizando dentro y sacando los demas elementos con sus
    //hijos. El segundo problema es sacar el contenido de los elementos que
    //lo tengan.  

    public void mostrarXml(Node nodo) { 
        switch (nodo.getNodeType()) {
            case Node.ELEMENT_NODE:
                Element elemento = (Element) nodo;
                    System.out.println("Etiqueta " + elemento.getTagName());
                    NodeList nl = nodo.getChildNodes();
                        for(int i = 0; i < nl.getLength(); i++){
                            mostrarXml(nl.item(i));
                        }
                    break;
            case Node.TEXT_NODE:
                Text texto = (Text) nodo;
                System.out.println("Texto: " + texto.getWholeText());
                break;
        }
    }
}