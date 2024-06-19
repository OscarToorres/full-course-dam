package biblioteca;

import java.util.Date;

public class Ejemplar {

    private String titulo;
    private int codigo;
    private Estado estado;
    private Usuario usuario;
    private Date fecPrestamo;
    private Date fecDevolucion;
    
    public Ejemplar(String titulo, int codigo, Estado estado) {
        this.titulo = titulo;
        this.codigo = codigo;
        this.estado = Estado.DISPONIBLE;
    }

    public Ejemplar(String titulo, int codigo, Estado estado, Usuario usuario, Date fecPrestamo, Date fecDevolucion) {
        this.titulo = titulo;
        this.codigo = codigo;
        this.estado = estado;
        this.usuario = usuario;
        this.fecPrestamo = fecPrestamo;
        this.fecDevolucion = fecDevolucion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Date getFecPrestamo() {
        return fecPrestamo;
    }

    public void setFecPrestamo(Date fecPrestamo) {
        this.fecPrestamo = fecPrestamo;
    }

    public Date getFecDevolucion() {
        return fecDevolucion;
    }

    public void setFecDevolucion(Date fecDevolucion) {
        this.fecDevolucion = fecDevolucion;
    }

    @Override
    public String toString() {
        return "Ejemplar{" + "titulo=" + titulo + ", codigo=" + codigo + ", estado=" + estado + ", usuario=" + usuario + ", fecPrestamo=" + fecPrestamo + ", fecDevolucion=" + fecDevolucion + '}';
    }



    
    
    
    
    
        

 
}
