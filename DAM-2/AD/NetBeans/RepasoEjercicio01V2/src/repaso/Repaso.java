/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repaso;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
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
public class Repaso {
    
    public Document crearDOM(String raiz){
        Document doc = null;
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            DOMImplementation implementacion = db.getDOMImplementation();
            doc = implementacion.createDocument(null, "raiz", null);
            doc.setXmlVersion("1.0");
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(Repaso.class.getName()).log(Level.SEVERE, null, ex);
        }
        return doc;
    }
    
    public Document XMLaDOM(String ruta){
        Document doc = null;
    
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            doc = db.parse(ruta);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(Repaso.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(Repaso.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Repaso.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return doc;
    }
    
    public void DOMaXML(String ruta, Document doc){
        File file = new File(ruta);
        
        try {
            Transformer tra = TransformerFactory.newInstance().newTransformer();
            StreamResult result = new StreamResult(file);
            DOMSource source = new DOMSource(doc);
            tra.transform(source, result);
            
        } catch (TransformerConfigurationException ex) {
            Logger.getLogger(Repaso.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(Repaso.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void leerXML(Node nodo){

        switch (nodo.getNodeType()) {
            case Node.ELEMENT_NODE:
                Element elemento = (Element) nodo;
                System.out.println("Elemento: " + elemento);
                NodeList nl = (NodeList) nodo;
                for (int i = 0; i < nl.getLength(); i++){
                    leerXML(nl.item(i));
                }
                break;
            case Node.TEXT_NODE:
                Text texto = (Text) nodo;
                System.out.println("Texto: " + texto);
                break;
        }
        
    }
    
    public void mostrarContenidoElemento(Element e){
        NodeList nl = e.getChildNodes();
        for (int i = 0; i < nl.getLength(); i++){
            Node nodo = nl.item(i);
            switch (nodo.getNodeType()) {
                case Node.ELEMENT_NODE:
                    Element elemento = (Element) nodo;
                    System.out.println("Elemento: " + elemento.getNodeName());
                    mostrarContenidoElemento(elemento);
                    break;
                case Node.TEXT_NODE:
                    if (nodo.getTextContent().isBlank() == false){
                        Text texto = (Text) nodo;
                        System.out.println("Texto: " + texto);
                    }
                    break;
            }
        }
    }
    
    public void borrarElemento(String nombre, Document doc){        
        NodeList nl = doc.getElementsByTagName(nombre);;
        
        while (nl.getLength() > 0){
            Element elementoBorrar = (Element) nl.item(0);
            elementoBorrar.getParentNode().removeChild(elementoBorrar);
        }
        
    }
}
