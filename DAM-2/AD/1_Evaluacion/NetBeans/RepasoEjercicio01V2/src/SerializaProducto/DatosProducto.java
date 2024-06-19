package SerializaProducto;

import java.util.ArrayList;

/**
 *
 * @author dam220
 */
public class DatosProducto {
    
    private final Integer[] idProducto = {1,2,3,4,5};
    private final String[] productos = {"manzana", "Caracoles", "Jamon", "Pistachos", "Lentejas"};
    private final double[] precios = {12,23,54,2,23};
    ArrayList<Producto> productoLista = new ArrayList<>();

    public DatosProducto() {
    }
    
    public ArrayList<Producto> generarLista(){
        for (int i = 0; i < idProducto.length; i++){
            productoLista.add(new Producto(idProducto[i], productos[i], precios[i]));
        }
            return productoLista;
    }
    
    
    
}
