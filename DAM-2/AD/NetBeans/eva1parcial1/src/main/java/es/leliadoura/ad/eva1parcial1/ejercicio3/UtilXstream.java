package es.leliadoura.ad.eva1parcial1.ejercicio3;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.security.AnyTypePermission;
import es.leliadoura.ad.eva1parcial1.data.Alumno;
import es.leliadoura.ad.eva1parcial1.data.GeneradorDatos;
import es.leliadoura.ad.eva1parcial1.data.Modulo;
import es.leliadoura.ad.eva1parcial1.data.Unidad;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author marco
 */
public class UtilXstream {

    public void creaXmlConXStream(String ruta, ListaModulos modulos) {
        File file = new File(ruta);

//        GeneradorDatos datos = new GeneradorDatos();
//        ListaModulos modulos = new ListaModulos();
//        modulos.setModulos(datos.creaModulos());

        try {
            XStream xs = new XStream();
            xs.setMode(XStream.NO_REFERENCES);
            xs.alias("modulo", Modulo.class);
            xs.alias("lista", ListaModulos.class);
            xs.alias("alumno", Alumno.class);
            xs.alias("unidad", Unidad.class);
            xs.toXML(modulos, new FileOutputStream(file));

        } catch (FileNotFoundException ex) {
            Logger.getLogger(UtilXstream.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ListaModulos leerXML(String ruta) {
        ListaModulos modulos = new ListaModulos();
        
        XStream xs = new XStream();
        xs.setMode(XStream.NO_REFERENCES);
        xs.alias("modulo", Modulo.class);
        xs.alias("lista", ListaModulos.class);
        xs.alias("alumno", Alumno.class);
        xs.alias("unidad", Unidad.class);
        xs.addPermission(AnyTypePermission.ANY);
        ListaModulos listaLeida = new ListaModulos();

        try {
            xs.fromXML(new FileInputStream(ruta), modulos);
            System.out.println("\n Lista Modulos: " + modulos);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(UtilXstream.class.getName()).log(Level.SEVERE, null, ex);
        }
        return modulos;
    }

}
