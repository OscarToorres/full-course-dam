// 
// Decompiled by Procyon v0.5.36
// 

package misClases.utilidades;

public class CDatos
{
    public static String obtenerNombre() {
        final String[] nombres = { "Pedro", "Paula", "Juan Carlos", "Rebeca", "Mercedes", "Teresa", "Carlos", "Jesus", "Marta", "Felipe", "Amada", "Monica", "Ines", "Belen", "Angel", "Benito", "Carmen", "Lourdes", "Ismael", "Manuel", "Roberto", "Susana", "Clara", "Laura" };
        final int indice = (int)(Math.random() * nombres.length);
        return nombres[indice];
    }
    
    public static String obtenerApellido() {
        final String[] nombres = { "Couceiro", "Fernandez", "Arias", "Mayor", "Perez", "Abad", "Conde", "Garcia", "Casal", "Suarez", "Arguelles", "Rodriguez", "Martinez", "Alvarez", "Bermejo", "Carrion", "Duque", "del Rio", "de la Loma", "de la Granja" };
        final int indice = (int)(Math.random() * nombres.length);
        return nombres[indice];
    }
    
    public static String obtenerNombreCompleto() {
        final String nombre = obtenerNombre();
        final String apellido1 = obtenerApellido();
        final String apellido2 = obtenerApellido();
        return String.valueOf(nombre) + " " + apellido1 + " " + apellido2;
    }
    
    private static String obtenerTipoDireccion() {
        final String[] nombres = { "Avda.", "C/", "Plaza", "Ronda", "Rua" };
        final int indice = (int)(Math.random() * nombres.length);
        return nombres[indice];
    }
    
    private static String obtenerNombreDireccion() {
        final String apellido1 = obtenerApellido();
        final String apellido2 = obtenerApellido();
        return String.valueOf(apellido1) + " " + apellido2;
    }
    
    private static int obtenerNumeroDireccion() {
        final int numero = (int)(Math.random() * 70.0) + 1;
        return numero;
    }
    
    public static String obtenerDireccion() {
        final String tipo = obtenerTipoDireccion();
        final String nombre = obtenerNombreDireccion();
        final int numero = obtenerNumeroDireccion();
        return String.valueOf(tipo) + " " + nombre + ", " + numero;
    }
    
    public static long obtenerTelefono() {
        final long numero = (long)(Math.random() * 4.0E7 + 6.6E8);
        return numero;
    }
}
