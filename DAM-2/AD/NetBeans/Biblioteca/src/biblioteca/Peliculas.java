package biblioteca;

import java.util.Date;

public class Peliculas  extends Ejemplar {
    
    private String director;
    private String reparto;
    private String sinopsis;



    public Peliculas(String director, String reparto, String sinopsis, String titulo, int codigo, Estado estado) {
        super(titulo, codigo, estado);
        this.director = director;
        this.reparto = reparto;
        this.sinopsis = sinopsis;
    }

    public Peliculas(String director, String reparto, String sinopsis, String titulo, int codigo, Estado estado, Usuario usuario, Date fecPrestamo, Date fecDevolucion) {
        super(titulo, codigo, estado, usuario, fecPrestamo, fecDevolucion);
        this.director = director;
        this.reparto = reparto;
        this.sinopsis = sinopsis;
    }
      
    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getReparto() {
        return reparto;
    }

    public void setReparto(String reparto) {
        this.reparto = reparto;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    @Override
    public String toString() {
        return "Peliculas{" + super.toString() + " director=" + director + ", reparto=" + reparto + ", sinopsis=" + sinopsis + '}';
    }
    
    
    
    
    
}
