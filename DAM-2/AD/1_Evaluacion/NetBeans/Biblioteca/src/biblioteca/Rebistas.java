package biblioteca;

import java.util.Date;

public class Rebistas extends Ejemplar{
  
    private String editorial;
    private Date fechaPublicacion;

 
    public Rebistas(String editorial, Date fechaPublicacion, String titulo, int codigo, Estado estado) {
        super(titulo, codigo, estado);
        this.editorial = editorial;
        this.fechaPublicacion = fechaPublicacion;
    }

    public Rebistas(String editorial, Date fechaPublicacion, String titulo, int codigo, Estado estado, Usuario usuario, Date fecPrestamo, Date fecDevolucion) {
        super(titulo, codigo, estado, usuario, fecPrestamo, fecDevolucion);
        this.editorial = editorial;
        this.fechaPublicacion = fechaPublicacion;
    }
    
    

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    @Override
    public String toString() {
        return "Rebistas{" + super.toString() + " editorial=" + editorial + ", fechaPublicacion=" + fechaPublicacion + '}';
    }




    
    
}
