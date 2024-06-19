/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GsonPedidos;

import JSonSimplePedidos.Pedido;
import com.google.gson.Gson;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author solda
 */
public class GsonUtilidades {

    public void crearGsonPedidos(List<Pedido> pedidos, String ruta) {
        Gson gson = new Gson();

        String jsonPedido = gson.toJson(pedidos);

        try ( FileWriter fw = new FileWriter(ruta)) {
            fw.write(jsonPedido);
            fw.close();
        } catch (IOException ex) {
            Logger.getLogger(GsonUtilidades.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Pedido> leerGsonPedidos(String ruta) {
        Gson gson = new Gson();
        List<Pedido> listaPedidos = new ArrayList<>();
        try (FileReader fr = new FileReader(ruta)){
//            while(fr.ready()){
//                Pedido pedido = gson.fromJson(fr, Pedido.class);
//                listaPedidos.add(pedido);
//            }
            listaPedidos = gson.fromJson(fr, List.class);
            fr.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GsonUtilidades.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GsonUtilidades.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaPedidos;
    }

    public void mostrarJsonPedidos(List<Pedido> pedidos) {
        for (int i = 0; i < pedidos.size(); i++) {
            System.out.println(pedidos.get(i));
        }
    }
}