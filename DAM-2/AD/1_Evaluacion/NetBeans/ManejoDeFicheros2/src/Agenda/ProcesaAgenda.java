package Agenda;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ProcesaAgenda {

    UtilidadesXML utilidades = new UtilidadesXML();
    Document doc = null;
    String nombreDoc="agenda.xml";
    String nombreDocProcesado1 = "agenda1.xml";
    String nombreDocProcesado2 = "agenda2.xml";
    String nombreDocProcesado3 = "agenda3.xml";




    public void procesarAgenda() {
        //Cargar en memoria el documento
        doc = utilidades.XMLaDOM(nombreDoc);

        //Se muestra el elemento raiz
        utilidades.mostrarElementoRaiz(doc);

        //Mostrar el contenido del documento
        Element raiz = doc.getDocumentElement();
        utilidades.mostrarContenidoElemento(raiz);

        //Borrar elementos nombre y telefono y generar otro doc con el contenido borrado
        doc = utilidades.borrarElementosEtiqueta("nombre", doc);
        doc = utilidades.borrarElementosEtiqueta("telefono", doc);
        utilidades.DOMaXML(doc, nombreDocProcesado1);

        //Borrar el elemento enderezo y generar otro doc con el contenido borrado
        doc = utilidades.borrarElementosEtiqueta("enderezo", doc);
        utilidades.DOMaXML(doc, nombreDocProcesado2);

        //Añadir elementos de tipo correo

        NodeList nl =  doc.getElementsByTagName("contacto");
        for(int i = 0; i < nl.getLength(); i++){
            Element correo = utilidades.crearElementoTexto("correo", "prueba@gmail.com", doc);
            nl.item(i).appendChild(correo);
        }
        utilidades.DOMaXML(doc, nombreDocProcesado3);
        
        

    }
    
}
