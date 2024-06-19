package Agenda;

import java.io.File;
import java.io.IOException;
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
import org.xml.sax.SAXException;

/**
 *
 * @author dam220
 */
public class UtilidadesXML {

    DocumentBuilderFactory dbf;
    DocumentBuilder db;

    //Este documento crea en memoria el documento DOM y se le pasa el nombre del
    //elemento raiz que vamos a tener
    public Document crearDOMBacio(String nombre) {

        Document doc = null;

        try {
            dbf = DocumentBuilderFactory.newInstance();
            db = dbf.newDocumentBuilder();
            DOMImplementation implementacion = db.getDOMImplementation();
            doc = implementacion.createDocument(null, nombre, null);
            doc.setXmlVersion("1.0");
        } catch (ParserConfigurationException ex) {
            System.out.println("no se pudo parsear el XML");
        }
        return doc;
    }
    //Crea un elemento que se añadira al documento XML que le pasemos. Se le pasa
    //El nombre del elemento que queramos, el texto que le vayamos a añadir
    //y el documento donde vamos a trabajar
    public Element crearElementoTexto(String etiqueta, String texto, Document doc) {

        //Creacion del elemento
        Element elemento = doc.createElement(etiqueta);
        Text elementoTexto = doc.createTextNode(texto);
        //Añadir el elemento creado
        doc.getDocumentElement().appendChild(elemento);
        elemento.appendChild(elementoTexto);
        

        return elemento;
    }
    //Pasamos el documento XML que tenemos a un documento DOM. Se le pasa el 
    //nombre del documento xml, con la extension
    public Document XMLaDOM(String nombre) {
        
        Document doc = null;

        try {
            
            dbf = DocumentBuilderFactory.newInstance();
            db = dbf.newDocumentBuilder();
            doc = db.parse(nombre);
            
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            System.out.println("Error, no se pudo cargar el documento XML");
        }
        
        return doc;
    }
    
    public void mostrarElementoRaiz(Document doc){
        
        Element raiz = doc.getDocumentElement();
        System.out.println(raiz.getNodeName());
    }
    //Este metodo saca los hijos del elemento que se le pasa como argumento
    public void mostrarContenidoElemento(Element e){
        NodeList nl = e.getChildNodes();
        for(int i = 0; i < nl.getLength(); i++){
            Node nodo = nl.item(i);
            switch (nodo.getNodeType()) {
                case Node.ELEMENT_NODE:
                    Element element = (Element) nodo;
                    System.out.println("Etiqueta: " + element.getTagName());
                    mostrarContenidoElemento(element);
                    break;
                case Node.TEXT_NODE:
                    if(nodo.getTextContent().isBlank() == false) {
                        Text texto = (Text) nodo;
                        System.out.println("Texto: " + texto.getWholeText());;
                    } 
                    break;
            }
        }       
    }
    //Se le pasa un nombre de un elemento y un documento del cual querramos borrar ese elemento
    public Document borrarElementosEtiqueta(String etiqueta, Document doc){
        //Creamos una lista con los hijos del elemento que pasamos por si hubiera
        //barios con el mismo nombre
        NodeList nl = doc.getElementsByTagName(etiqueta);
        //Como El NodeList es una lista dinamica, se borra siempre la posicion 0
        while(nl.getLength() > 0){
            Element elementoABorrar = (Element) nl.item(0);
            //Un elemento no se puede borrar a si mismo, por lo tanto primero se llama al elemento padre y 
            //despues borramos a los hijos
            elementoABorrar.getParentNode().removeChild(elementoABorrar);
        }
        return doc;
    }
    //Pasa el documento DOM a XML, se le pasa el documento creado en el otro metodo
    //y el nombre que se le quiere dar al documento. Aqui hay que añadir la extendsion
    //de lo que estamos creando
    public void DOMaXML(Document doc, String nombre){
        
        try {
            File f = new File(nombre);
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            StreamResult result = new StreamResult(f);
            DOMSource source = new DOMSource(doc);
            transformer.setOutputProperty(INDENT, "yes");
            transformer.transform(source, result);
            
        } catch (TransformerConfigurationException ex) {
            Logger.getLogger(UtilidadesXML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(UtilidadesXML.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
