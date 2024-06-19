package practicas.ejem02;

import java.util.Scanner;

public class ejemplo2 {

    public static void main(String[] args) {
    	Scanner scanner = new java.util.Scanner(System.in);
        COposicion oposicion;
        oposicion = new COposicion();
        int opcion;
        int clave;

        do {
            opcion = oposicion.dameOpcion();
            switch (opcion) {
            case 1:
                oposicion.llenar();
                System.out.println("Oposición LLENA");
                break;
            case 2:
                oposicion.vaciar();
                System.out.println("Oposición VACIA");
                break;
            case 3:
                oposicion.mostrar();
                break;
            case 4:
            	System.out.print("Inserte clave: ");
            	clave = scanner.nextInt();
            	oposicion.eliminarAspirante(clave);
            	break;
            case 5:
                System.out.println("FINAL");
                break;
            default:
                System.out.println("OPCION Erronea");
                break;
            }
        } while (opcion != 5);
        scanner.close();
    }
}
