package misClases.teoria;

import misClases.utilidades.DatosPersonales;

public class CMatrizString
{
    private String[] matriz;
    
    public void crea() {
        System.out.print("Numero de personas: ");
        final int n = Leer.datoInt();
        this.matriz = new String[n];
    }
    
    public void llena() {
        for (int i = 0; i < this.matriz.length; ++i) {
            this.matriz[i] = this.dameDato();
        }
    }
    
    public void amosa() {
        System.out.println("\nMatriz de Personas");
        for (int i = 0; i < this.matriz.length; ++i) {
            final int longitud = this.matriz[i].length();
            System.out.println(String.valueOf(i) + "->  " + this.matriz[i] + " (" + longitud + ")");
        }
    }
    
    private String dameDato() {
        String dato = DatosPersonales.dameNombre();
        dato = String.valueOf(dato) + " " + DatosPersonales.dameApellido();
        dato = String.valueOf(dato) + " " + DatosPersonales.dameApellido();
        return dato;
    }
}
