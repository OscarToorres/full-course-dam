/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package Main;

import GsonPedidos.GsonUtilidades;
import JSonSimpleClientes.Cliente;
import JSonSimpleClientes.UtilidadesJSonSimple;
import JSonSimpleClientes.UtilidadesXStream;
import JSonSimpleGestion.ClienteG;
import JSonSimpleGestion.Contacto;
import JSonSimpleGestion.GestionClientes;
import JSonSimplePedidos.Pedido;
import JSonSimplePedidos.UtilidadesJson;
import Repaso.Repaso;
import java.util.ArrayList;
import java.util.List;
import org.json.simple.JSONArray;

/**
 *
 * @author dam220
 */
public class Main {
    
    public static void main(String[] args) {
        UtilidadesJSonSimple json = new UtilidadesJSonSimple();
        UtilidadesXStream xs = new UtilidadesXStream();
        List<Cliente> clientes = new ArrayList<>();
        JSONArray jarray = new JSONArray();

//        clientes = json.generarClientes();
//        jarray = json.crearJSonObjetcs(clientes);
//        json.guardarJSon(jarray, "clientes.json");
//        xs.crearFicheroXStream("clientesXStream.xml", jarray);
//        json.leerJSon("clientes.json");

        //EJERCICIO 3 Y 4
        UtilidadesJson jsonpedidos = new UtilidadesJson();
        List<Pedido> pedidos = new ArrayList<>();
        
//        pedidos = jsonpedidos.generaPedidos();
//        jarray = jsonpedidos.crearJsonObjects(pedidos);
//        jsonpedidos.crearDocumentoJson(jarray, "pedidos.json");
//        pedidos = jsonpedidos.leeJsonPedidos("pedidos.json");
//        jsonpedidos.MostraJsonPedidos("pedidos.json");
        

        //EJERCICIO 5
        GestionClientes gestion = new GestionClientes();
        List<ClienteG> clientesG = new ArrayList<>();
        List<Contacto> contactos = new ArrayList<>();
        
        //Clientes
//        clientesG = gestion.generarListaClientes();
//        jarray = gestion.crearObjetosJsonCliente(clientesG);
//        gestion.guardaJSonClientes("clientesG.json",jarray);
//        gestion.leJSonClientes("clientesG.json");
//        gestion.mostrarJsonClientes("clientesG.json");


        //Contactos
//        gestion.generarLisstaContactos("clientesG.json");
//        contactos = gestion.generarLisstaContactos("clientesG.json");
//        jarray = gestion.crearObjectsContacto(contactos);
//        gestion.guardarJSonContactos(jarray, "contactos.json");
//        gestion.leeJSonContactos("contactos.json");
//        gestion.mostrarJSonContactos("contactos.json");
//        gestion.guardaXmlJSonContactos("clientesG.json", "contactos.xml");
//        gestion.leMostrarCmlContactos("contactos.xml");
//        gestion.guardarDatJsonContactos(contactos, "contactos.dat");
//        gestion.leMostrarDatContactos("contactos.dat");

        //EJERCICIO 6
        GsonUtilidades gson = new GsonUtilidades();
        
        pedidos = jsonpedidos.generaPedidos();
//        gson.crearGsonPedidos(pedidos, "pedidosGson.json");
//        pedidos = gson.leerGsonPedidos("pedidosGson.json");
//        gson.mostrarJsonPedidos(pedidos);

        //REPASO
        Repaso repaso = new Repaso();
        repaso.crearGsonPedidos(pedidos, "repaso.json");
        repaso.leerGsonPedidos("repaso.json");

    }
}
