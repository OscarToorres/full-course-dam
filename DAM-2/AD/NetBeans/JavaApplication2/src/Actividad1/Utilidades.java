package Actividad1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Utilidades {
    
    private Integer idProducto[] = {1,2,3,4,5};
    private String descripcion[] = {"bueno","malo","barato","clasico","estropeado"};
    private double precio[] = {14,36,34,23,12};
    Producto producto = null;
    private List<Producto> productos = new ArrayList();

    private FileOutputStream fos;
    private ObjectOutputStream oos;
    private FileInputStream fis; 
    private ObjectInputStream ois;
        
    
    public Utilidades() throws IOException, FileNotFoundException {
        productos = new ArrayList();
        fos = new FileOutputStream("producto.dat");
        oos = new ObjectOutputStream(fos);
        fis = new FileInputStream("producto.dat");
        ois = new ObjectInputStream(fis);
    }
    
    public List<Producto> generarList() {
        for(int i = 0; i < idProducto.length; i++) {
            productos.add(new Producto(idProducto[i], descripcion[i], precio[i]));
        }
        return productos;
    }

    public void escribirLista() throws IOException {
        for(Producto producto : productos){
            oos.writeObject(producto);
        }
        oos.close();
        fos.close();   
    }
       
    public void LeerLista() throws IOException, ClassNotFoundException{
        while(fis.available() > 0){
            producto = (Producto) ois.readObject();
            System.out.println(producto);
        }
    }
}

