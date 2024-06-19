package Libros;

import SerializaProducto.Producto;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.CustomObjectInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

/**
 *
 * @author dam220
 */
public class UtilidadesLibro {
    
    public ArrayList<Libro> generarObjetosLibro(){

        Persona lector1 = new Persona("Manolo", "78548552Z");
        Persona lector2 = new Persona("Luis", "89543215F");
        Persona lector3 = new Persona("Adrian", "56141315F");
        Persona lector4 = new Persona("Hugo", "78545342Z");
        Persona lector5 = new Persona("Alberto", "99998552Z");
        Persona lector6 = new Persona("Oscar", "78214452Z");
                
        ArrayList<String> autores1 = new ArrayList<>();
        autores1.add("Federico Garcia Lorca");
        autores1.add("Rosalia de Castro");
        ArrayList<String> autores2 = new ArrayList<>();
        autores2.add("Don Luis Fernandez");
        autores2.add("Jose Carlos el Artista");
        ArrayList<String> autores3 = new ArrayList<>();
        autores3.add("Marco Antonio");
                      
        Libro libro1 = new Libro("142-123-16", "La Mona Albaro", autores1 ,2021, true, lector1);
        Libro libro2 = new Libro("133-666-33", "Fitipaldi", autores2 ,1999, true, lector2);
        Libro libro3 = new Libro("142-233-44", "Filipinas", autores1 ,2009, false, lector3);
        Libro libro4 = new Libro("346-123-24", "El Cantar de MiaPirola", autores2 ,2022, true, lector4);
        Libro libro5 = new Libro("666-555-76", "Una vieja sobre el mar", autores3 ,2014, false, lector5);
        Libro libro6 = new Libro("377-543-12", "Al tres metros del infierno", autores1 ,2000, false, lector6);

        ArrayList<Libro> libros = new ArrayList<>();
        libros.add(libro1);
        libros.add(libro2);
        libros.add(libro3);
        libros.add(libro4);
        libros.add(libro5);
        libros.add(libro6);
        
        System.out.println(libros);
        return libros;
    }
    
    public void generarDatLibro(ArrayList<Libro> libros, String archivo){
        
        try{
            FileOutputStream fos = new FileOutputStream(archivo);
            ObjectOutputStream ois = new ObjectOutputStream(fos);
            
            for (Libro lib : libros){
                ois.writeObject(lib);
            }
            ois.close();
            fos.close();

        } catch (IOException ex) {
            Logger.getLogger(UtilidadesLibro.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void mostrarLibros(String archivo){
        File file = new File(archivo);
        
        try {
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            
            Libro libro = null;
            while (fis.available() > 0){
                libro = (Libro) ois.readObject();
                System.out.println(libro);
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(UtilidadesLibro.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(UtilidadesLibro.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UtilidadesLibro.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public ArrayList<Libro> datToArrayList(String archivo){
        
        File file = new File(archivo);
        ArrayList<Libro> libros = new ArrayList<>();
        
        //Pasar el archivo .dat a un ArrayList
        try {
           FileInputStream fis = new FileInputStream(file);
           ObjectInputStream ois = new ObjectInputStream(fis);
           
           while (fis.available() > 0){
               libros.add((Libro) ois.readObject());
        }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(UtilidadesLibro.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(UtilidadesLibro.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UtilidadesLibro.class.getName()).log(Level.SEVERE, null, ex);
        }
        return libros;
    }
    
    public void XmlLibroDom (String archivo, String archivoXml){
        Document doc = null;
        
        //Pasar el archivo .dat a un ArrayList
        ArrayList<Libro> libros = this.datToArrayList(archivo);

        //Crear el DOM
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            DOMImplementation implementacion = db.getDOMImplementation();
            doc = implementacion.createDocument(null, "libros", null);
            doc.setXmlVersion("1.0");
            
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(UtilidadesLibro.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //Añadir los elementos al DOM
        Element raiz = doc.getDocumentElement();
        Persona persona = null;
        
        for(Libro lbr : libros) {
            System.out.println("Entra en el for");
            Element libro = doc.createElement("libro");
            raiz.appendChild(libro);
            
            Element isbn = doc.createElement("isbn");
            isbn.setTextContent(lbr.getIsbn());
            libro.appendChild(isbn);
            
            Element titulo = doc.createElement("titulo");
            titulo.setTextContent(lbr.getTitulo());
            libro.appendChild(titulo);
            
            Element autores = doc.createElement("autores");
            libro.appendChild(autores);
            
            for (int i = 0; i < lbr.getAutores().size(); i++){
                
                Element nombreAutor = doc.createElement("nombre");
                nombreAutor.setTextContent(lbr.getAutores().get(i));
                autores.appendChild(nombreAutor);
            }
            
            Element ano = doc.createElement("año");
            ano.setTextContent(lbr.getAno().toString());
            libro.appendChild(ano);
            
            Element prestado = doc.createElement("prestado");
            prestado.setTextContent(String.valueOf(lbr.isPrestado()));
            libro.appendChild(prestado);
            
            Element lectores = doc.createElement("lectores");
            libro.appendChild(lectores);
            
            Element nombreLector = doc.createElement("nombre");
            nombreLector.setTextContent(lbr.getLector().getNombre());
            lectores.appendChild(nombreLector);           
            
            Element dniLector = doc.createElement("dni");
            dniLector.setTextContent(lbr.getLector().getDni());
            lectores.appendChild(dniLector);
        }
        
        //Pasar de DOM a XML
        File file1 = new File(archivoXml);
        
        try {
            Transformer transformar = TransformerFactory.newInstance().newTransformer();
            transformar.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            StreamResult result = new StreamResult(file1);
            DOMSource source = new DOMSource(doc);
            transformar.transform(source, result);
            
        } catch (TransformerConfigurationException ex) {
            Logger.getLogger(UtilidadesLibro.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(UtilidadesLibro.class.getName()).log(Level.SEVERE, null, ex);
        }       
    }
    
    public void generaXmlLibroXStream(String archivoDat, String archivoXml){
        File file = new File(archivoXml);
        
        ListaLibros listaLibros = new ListaLibros();
        listaLibros.setLibros(this.datToArrayList(archivoDat));
       
        try {
            XStream xstream = new XStream();
            xstream.setMode(XStream.NO_REFERENCES);
            xstream.alias("libro", Libro.class);
            xstream.alias("listaLibro", ListaLibros.class);
            xstream.alias("producto", Producto.class);
            xstream.toXML(listaLibros, new FileOutputStream(file));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(UtilidadesLibro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
