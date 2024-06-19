/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package JSonSimple;

import java.util.ArrayList;
import org.json.simple.JSONArray;

/**
 *
 * @author dam220
 */
public class Main {

    public static void main(String[] args) {
        UtilidadesJSonSimple json = new UtilidadesJSonSimple();
        UtilidadesXStream xs = new UtilidadesXStream();
        ArrayList<Cliente> clientes = new ArrayList<>();
        JSONArray jsonarrayclientes = new JSONArray();
        
        clientes = json.generarClientes();
//        jsonarrayclientes = json.crearJSonObjetcs(clientes);
//        json.guardarJSon(jsonarrayclientes, "clientes.json");
        xs.crearFicheroXStream("clientesXStream.xml", clientes);
        
        
    }
}
