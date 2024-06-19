package practicas.ejem01;

public class CAspirante {
    private int clave;
    private String nombre;
    private float tasas;

    public CAspirante(int cla, String nom, float tas) {
        clave = cla;
        nombre = nom;
        tasas = tas;
    }

    public int getClave() {
        return clave;
    }

    public void setClave(int cla) {
        clave = cla;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nom) {
        nombre = nom;
    }

    public float getTasas() {
        return tasas;
    }

    public void setTasas(float tas) {
        tasas = tas;
    }

    public void mostrar() {
        System.out.println(clave + "\t" + nombre + "\t" + tasas);
    }

}
