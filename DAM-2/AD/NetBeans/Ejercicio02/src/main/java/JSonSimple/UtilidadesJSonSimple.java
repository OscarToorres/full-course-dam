/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JSonSimple;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author dam220
 */
public class UtilidadesJSonSimple {

    public ArrayList<Cliente> generarClientes() {

        ArrayList<Direccion> direccion1 = new ArrayList<>();
        direccion1.add(new Direccion("calle1", "n1", "12345"));
        ArrayList<Direccion> direccion2 = new ArrayList<>();
        direccion2.add(new Direccion("calle2", "n2", "12378"));
        ArrayList<Direccion> direccion3 = new ArrayList<>();
        direccion3.add(new Direccion("calle3", "n3", "19874"));

        Cliente cliente1 = new Cliente("11111111A", "Manolo", "Oudterial Rodruiguez", direccion1);
        Cliente cliente2 = new Cliente("22222222A", "Luis", "Lustres Manuek", direccion2);
        Cliente cliente3 = new Cliente("33333333A", "Albaro", "Carbajal Rodruiguez", direccion3);

        ArrayList<Cliente> clientes = new ArrayList<>();
        clientes.add(cliente1);
        clientes.add(cliente2);
        clientes.add(cliente3);

        System.out.println(clientes);

        return clientes;
    }
    
    public JSONObject crearJSonObjectsCliente (Cliente cliente){
        
        JSONObject jsonObject = new JSONObject();

            jsonObject.put("dni", cliente.getDni());
            jsonObject.put("nombre", cliente.getNombre());
            jsonObject.put("apellidos", cliente.getApellidos());

            JSONArray jsonArrayDirecciones = new JSONArray();

            for (Direccion dr : cliente.getDireccion()) {
                JSONObject jdonDire = this.crearJSonObjectsDireccion(dr);
                jsonArrayDirecciones.add(jdonDire);
            }

            jsonObject.put("direccion", jsonArrayDirecciones);
            return jsonObject;
    }

    public JSONObject crearJSonObjectsDireccion (Direccion direccion){
         JSONObject jsonObject2 = new JSONObject();

                jsonObject2.put("calle", direccion.getCalle());
                jsonObject2.put("numero", direccion.getNumero());
                jsonObject2.put("codigoPostal", direccion.getCodigoPostal());
                
                return jsonObject2;
    }
    
    
    public JSONArray crearJSonObjetcs(ArrayList<Cliente> clientes) {
        JSONArray jsonArrayClientes = new JSONArray();

        //Recorrer los clientes
        for (Cliente cle : clientes) {
            JSONObject obj = this.crearJSonObjectsCliente(cle);
            jsonArrayClientes.add(obj);
        }
        
        return jsonArrayClientes;
    }

    public void guardarJSon(JSONArray clientes, String ruta) {
        try {
            FileWriter fw = new FileWriter(ruta);
            fw.write(clientes.toJSONString());
            fw.close();
        } catch (IOException ex) {
            Logger.getLogger(UtilidadesJSonSimple.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
