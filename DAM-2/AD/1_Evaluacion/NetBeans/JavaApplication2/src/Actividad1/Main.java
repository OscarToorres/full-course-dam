package Actividad1;

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
import org.xml.sax.SAXException;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        
        Document doc = null;
        String rutaArchivoXML="I:\\DAM 2\\AD\\NetBeans\\JavaApplication2";

        Utilidades utilidad = new Utilidades();
        
        utilidad.generarList();
        utilidad.escribirLista();
        utilidad.LeerLista();
               
//        try{
//            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
//            DocumentBuilder db = dbf.newDocumentBuilder();
//            
//            DOMImplementation implementacion = db.getDOMImplementation();
//            doc = implementacion.createDocument(null, "instituto", null);
////            doc.setXmlVersion("1.0");
//            TransformerFactory transformerFactory = TransformerFactory.newInstance();
//            Transformer transformer = transformerFactory.newTransformer();
//            DOMSource source = new DOMSource(doc);
//            StreamResult result = new StreamResult(new File("prueba.xml"));
//            
//            transformer.transform(source, result);
//        }catch (ParserConfigurationException ex){
//          ex.printStackTrace();  
//        } catch (TransformerConfigurationException ex) {
//          ex.printStackTrace();  
//        } catch (TransformerException ex) {
//          ex.printStackTrace();  
//        }
//
//        try{
//            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
//            DocumentBuilder db = dbf.newDocumentBuilder();
//            DOMImplementation implementation = db.getDOMImplementation();
//        }catch(ParserConfigurationException ex){
//            System.out.println("Error, No se pudo parsear el XML");
//        }

    }
    
}
