package XStream;

import SerializaProducto.DatosProducto;
import SerializaProducto.Pedido;
import SerializaProducto.Producto;
import XmlProducto.CrearXmlPedidos;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dam220
 */
public class DocumentoConXStream {

    public void generarXML() {
        File file1 = new File("pedidosXStream.xml");
        File file2 = new File("productosXStream.xml");

        try {
            CrearXmlPedidos crearPedidos = new CrearXmlPedidos();
            ListaPedido listaPedido = new ListaPedido();
            listaPedido.setPedidos(crearPedidos.lePedidos("pedidos.dat"));

            DatosProducto dProductos = new DatosProducto();
            ListaProducto listaProducto = new ListaProducto();
            listaProducto.setPedidos(crearPedidos.leProductos("productos.dat"));

            //Se le dan nombres a las clases que hace referencia para cunado se genere
            //El xml salga el nombre que le pones y no el nombre de la clase.
            //Se le dan nombres a todas las clases que hace referencia el ArrayList
            //que estemos usando. IMPORTANTE: No poner de alias el mismo nombre que 
            //la Lista que usamos. No se pueden tener etiquetas sin texto iguales
            //Archivo xml de pedidos
            XStream xstream = new XStream();
            xstream.setMode(XStream.NO_REFERENCES);
            xstream.alias("pedido", Pedido.class);
            xstream.alias("lista", ListaPedido.class);
            xstream.alias("producto", Producto.class);
            //Instanciar objeto DcumentoConXStream
            xstream.toXML(listaPedido, new FileOutputStream(file1));

            xstream.alias("producto", Producto.class);
            xstream.alias("lista", ListaProducto.class);
            xstream.toXML(listaProducto, new FileOutputStream(file2));

        } catch (FileNotFoundException ex) {
            Logger.getLogger(DocumentoConXStream.class.getName()).log(Level.SEVERE, null, ex);
        }
//        //Sirve para mostrarlo por pantalla, le el xml generado y lo imprime por pantalla
        XStream xs = new XStream(new DomDriver());
        xs.setMode(XStream.NO_REFERENCES);
        xs.alias("pedido", Pedido.class);
        xs.alias("lista", ListaPedido.class);
        xs.alias("producto", Producto.class);
        xs.addPermission(AnyTypePermission.ANY);
        ListaPedido listaLeida = new ListaPedido();
        
        try{
            xs.fromXML(new FileInputStream(file1), listaLeida);
            System.out.println("\nLista de pedidos: \n" + listaLeida);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DocumentoConXStream.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
