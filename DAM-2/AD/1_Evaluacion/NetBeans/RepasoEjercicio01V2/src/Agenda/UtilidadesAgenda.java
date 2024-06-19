package Agenda;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
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
import org.xml.sax.SAXException;

/**
 *
 * @author solda
 */
public class UtilidadesAgenda {
    
    public Document creaDOMBaleiro(String raiz) {
        Document doc = null;
        
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            DOMImplementation implementacion = db.getDOMImplementation();
            doc = implementacion.createDocument(null, raiz, null);
            doc.setXmlVersion("1.0");
            
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(UtilidadesAgenda.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return doc;
    }
    
    public Element crearElementoTexto(String nombre, String texto, Document doc) {
        
        Element elemento = doc.createElement(nombre);
        elemento.setTextContent(texto);
        
        return elemento;
    }
    
    public Document XMLaDOM(String ruta) {
        Document doc = null;
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            doc = db.parse(ruta);
            
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(UtilidadesAgenda.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(UtilidadesAgenda.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(UtilidadesAgenda.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return doc;
    }
    
    public void mostraElementoRaiz(Document doc) {
        
        Element raiz = doc.getDocumentElement();
        System.out.println(raiz);
    }
    
    public void mostarContenidoElemento(Element e) {
        NodeList nl = e.getChildNodes();
        for (int i = 0; i < nl.getLength(); i++) {
            Node nodo = nl.item(0);
            switch (nodo.getNodeType()) {
                case Node.ELEMENT_NODE:
                    Element elemento = (Element) nodo;
                    System.out.println("Etiqueta: " + elemento.getNodeName());
                    break;
                case Node.TEXT_NODE:
                    Text texto = (Text) nodo;
                    System.out.println("Texto: " + texto.getWholeText());
                    break;
            }
        }
    }
    
    public void borarElementosEtiqueta(String nombre, Document doc) {
        NodeList nl = doc.getElementsByTagName(nombre);
        
        while (nl.getLength() > 0) {
            Element elementoABorrar = (Element) nl.item(0);
            elementoABorrar.getParentNode().removeChild(elementoABorrar);
        }
    }
    
    public void DOMaXML(Document doc, String ruta) {
        File file = new File(ruta);
        
        try {
            Transformer transformar = TransformerFactory.newInstance().newTransformer();
            StreamResult result = new StreamResult(file);
            DOMSource source = new DOMSource(doc);
            transformar.transform(source, result);
        } catch (TransformerException ex) {
            Logger.getLogger(UtilidadesAgenda.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
