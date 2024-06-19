/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SerializaProducto;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author solda
 */
public class UtilidadesProducto {
    
    public void crearFicheroProductos(ArrayList<Producto> productos, String ruta) {
        File file = new File(ruta);
        
        try {
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos); 
            
            for (Producto pro : productos){
                oos.writeObject(pro);
            }
            
            fos.close();
            oos.close();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(UtilidadesProducto.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(UtilidadesProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void leerFichero(String ruta){
        
        try {
            FileInputStream fis = new FileInputStream(ruta);
            ObjectInputStream ois = new ObjectInputStream(fis);
            
            Producto producto = null;
            while (fis.available() > 0){
                producto = (Producto) ois.readObject();
                System.out.println(producto);
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(UtilidadesProducto.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(UtilidadesProducto.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UtilidadesProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
