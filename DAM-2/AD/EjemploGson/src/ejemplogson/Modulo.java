package ejemplogson;

/**
 *
 * @author fprimag
 */
public class Modulo {
    private String nombre;
    private String codigo;

    public Modulo(String nombre, String codigo) {
        this.nombre = nombre;
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return "Modulo{" + "nombre=" + nombre + ", codigo=" + codigo + '}';
    }

}
