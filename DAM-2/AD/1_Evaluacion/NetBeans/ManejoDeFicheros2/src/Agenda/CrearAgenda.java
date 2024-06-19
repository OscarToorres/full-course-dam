package Agenda;

import java.io.Serializable;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author dam220
 */
public class CrearAgenda implements Serializable {

    //Obejtos de la clase con valores 
    private String[] Acalle = {"calle1", "calle2", "calle3", "calle4", "calle5", "calle6",};
    private Integer[] Anumero = {12, 56, 342, 2, 234, 65};
    private String[] Anombre = {"Alverto", "Alvaro", "Hugo", "Luis", "Juanma", "Adrian"};
    private String[] Atelefono = {"654123888", "654714253", "654321865", "674124851", "655522487", "666555888"};

    //Objetos para los documentos
    Document doc = null;
    private String nombreRaiz = "agenda";

    UtilidadesXML utilidades = new UtilidadesXML();

    public void generarAgenda() {
        doc = utilidades.crearDOMBacio(nombreRaiz);
        Element raiz = doc.getDocumentElement();

        //Utilizando los metodos de la clase UtilidadesXML creamos el XML
        for (Integer i = 0; i < Anombre.length; i++) {
            Element contacto = utilidades.crearElementoTexto("contacto", "", doc);
            raiz.appendChild(contacto);
            contacto.setAttribute("id",Integer.toString(i + 1));
            
            Element nombre = utilidades.crearElementoTexto("nombre", Anombre[i], doc);
            contacto.appendChild(nombre);
            Element telefono = utilidades.crearElementoTexto("telefono", Atelefono[i], doc);
            contacto.appendChild(telefono);
            Element enderezo = utilidades.crearElementoTexto("enderezo", "", doc);
            contacto.appendChild(enderezo);
            Element calle = utilidades.crearElementoTexto("calle", Acalle[i], doc);
            enderezo.appendChild(calle);
            Element numero = utilidades.crearElementoTexto("numero", Anumero[i].toString(), doc);
            enderezo.appendChild(numero);

            utilidades.DOMaXML(doc, "agenda.xml");
                    
        }
            
            
            
//    try {
//            //Crear el documento DOM
//        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
//        DocumentBuilder db = dbf.newDocumentBuilder();
//        DOMImplementation implementacion = db.getDOMImplementation();
//        doc = implementacion.createDocument(null, "agenda", null);
//        doc.setXmlVersion("1.0");
//            //Añadir los elementos al documento
//        Element raiz = doc.getDocumentElement();

//        for (int i = 0; i < Anombre.length; i++){
//            Element contacto = doc.createElement("contacto");
//            doc.getDocumentElement().setAttribute("id", "1");
//            raiz.appendChild(contacto);
//            
//            Element nombre = doc.createElement("nombre");
//            Text nombreTexto = doc.createTextNode(Anombre[i]);
//            nombre.appendChild(nombreTexto);
//            contacto.appendChild(nombre);
//            
//            Element telefono = doc.createElement("telefono");
//            Text textoTelefono = doc.createTextNode(Atelefono[i]);
//            //telefono.setTextContent(Atelefono[i]);
//            telefono.appendChild(textoTelefono);
//            contacto.appendChild(telefono);
//            
//            Element enderezo = doc.createElement("enderezo");
//            contacto.appendChild(enderezo);
//            
//            Element calle = doc.createElement("calle");
//            Text calleTexto = doc.createTextNode(Acalle[i]);
//            calle.appendChild(calleTexto);
//            enderezo.appendChild(calle);
//            
//            Element numero = doc.createElement("numero");
//            Text numeroText = doc.createTextNode(Anumero[i].toString());
//            numero.appendChild(numeroText);
//            enderezo.appendChild(numero); 
        

//            //Guardar el documento a XML
//        File file = new File("agenda.xml");
//        Transformer transformer = TransformerFactory.newInstance().newTransformer();
//        transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
//        StreamResult result = new StreamResult(file);
//        DOMSource source = new DOMSource(doc);
//        transformer.setOutputProperty(INDENT, "yes");
//        transformer.transform(source, result);     
//        } catch (ParserConfigurationException ex) {
//            Logger.getLogger(CrearAgenda.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (TransformerConfigurationException ex) {
//            Logger.getLogger(CrearAgenda.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (TransformerException ex) {
//            Logger.getLogger(CrearAgenda.class.getName()).log(Level.SEVERE, null, ex);
//        }
//           
//   
    }
}



