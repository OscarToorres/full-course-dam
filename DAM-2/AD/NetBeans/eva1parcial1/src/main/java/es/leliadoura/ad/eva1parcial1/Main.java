/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package es.leliadoura.ad.eva1parcial1;

import es.leliadoura.ad.eva1parcial1.data.Alumno;
import es.leliadoura.ad.eva1parcial1.data.GeneradorDatos;
import es.leliadoura.ad.eva1parcial1.data.Modulo;
import es.leliadoura.ad.eva1parcial1.ejercicio3.ListaModulos;
import es.leliadoura.ad.eva1parcial1.ejercicio3.UtilXstream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author marco
 */
public class Main {

    public static void main(String[] args) {
        //EJERCICIO 03
        ListaModulos listaLeida = new ListaModulos();
        UtilXstream xstream = new UtilXstream();
        GeneradorDatos datos = new GeneradorDatos();
        ListaModulos modulos = new ListaModulos();
                
        modulos.setModulos(datos.creaModulos());
        
        xstream.creaXmlConXStream("modulosXStream.xml", modulos);
        listaLeida = xstream.leerXML("modulosXStream.xml");
        

        for (int i = 0; i < listaLeida.getModulos().size(); i++) {
            List<Modulo> listaModulos = listaLeida.getModulos();
            Modulo modulo = listaModulos.get(i);
            modulo.getAlumnos().removeAll(modulo.getAlumnos());
        }
        
        xstream.creaXmlConXStream("modulosXSin.xml", listaLeida);
      

    }
}
