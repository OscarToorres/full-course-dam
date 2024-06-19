package practicas.ejem01;

public class ejemplo1 {

    public static void main(String[] args) {
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
                System.out.print("Dame clave de aspirante: ");
                clave = Leer.datoInt();
                oposicion.mostrarAspirante(clave);
                break;
            case 5:
                System.out.print("Dame clave de aspirante: ");
                clave = Leer.datoInt();
                oposicion.eliminarAspirante(clave);
                break;
            case 6:
                System.out.println("FINAL");
                break;
            default:
                System.out.println("OPCION Erronea");
                break;
            }
        } while (opcion != 6);
    }
}
