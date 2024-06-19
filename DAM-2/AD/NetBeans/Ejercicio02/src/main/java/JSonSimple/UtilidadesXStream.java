/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JSonSimple;

import com.thoughtworks.xstream.XStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author solda
 */
public class UtilidadesXStream {
    
    public void crearFicheroXStream(String ruta, ArrayList<Cliente> clientes){
        File file = new File(ruta);
        
        UtilidadesJSonSimple generarClientes = new UtilidadesJSonSimple();
        ListaClientes listaClientes = new ListaClientes();
        listaClientes.setClientes(generarClientes.generarClientes());
        
        try {
            XStream xstream = new XStream();
            xstream.setMode(XStream.NO_REFERENCES);
            
            xstream.alias("cliente", Cliente.class);
            xstream.alias("listaClientes", ListaClientes.class);
            xstream.alias("direccion", Direccion.class);
            xstream.alias("listaDirecciones", ListaDirecciones.class);

            xstream.toXML(listaClientes, new FileOutputStream(file));
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(UtilidadesXStream.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
        
}
