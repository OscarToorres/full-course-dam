package biblioteca;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class BibliotecaApp {
        
    public static void main(String[] args) {
    
        Prestamos prestamo = new PrestamosImplentacion();
        
        Libros libro = new Libros("Albaro","Libro de comedia", "123abc","Un pijama y medio",1,Estado.DISPONIBLE); 
        Rebistas rebista = new Rebistas("Colgando", new GregorianCalendar(2018,Calendar.JULY,20).getTime(),"Julieto y Julieta",2,Estado.EN_USO);
        Peliculas pelicula = new Peliculas("Oscar Torres","Lo que sea el reparto","Es una buena pelicula","Había una vez",3,Estado.PRESTADO);
        
        prestamo.addEjemplar(libro);
        prestamo.addEjemplar(rebista);
        prestamo.addEjemplar(pelicula);

        prestamo.mostrarLista();
        
        System.out.println("Busqueda");
        System.out.println(prestamo.buscarEjemplar(1));
        
        
    }
}
