package practicas.practi01;

public class practica01 {

	public static void main(String[] args) {
		
        CJuzgado proceso;
        proceso = new CJuzgado();
        int opcion;
        String identificador;

        do {
            opcion = proceso.dameOpcion();
            switch (opcion) {
            case 1:
            	proceso.llenar();
                System.out.println("Oposici�n LLENA");
                break;
            case 2:
            	proceso.vaciar();
                System.out.println("Oposici�n VACIA");
                break;
            case 3:
            	proceso.mostrar();
                break;
            case 4:
            	System.out.println("A�ade nuevo Proceso: ");
            	proceso.insertarProceso();
            	break;
            case 5:
                System.out.print("Dame identificador del proceso: ");
                identificador = Leer.datoString();
                proceso.modificarProceso(identificador);
                break;
            case 6:
                System.out.print("Dame identificador del proceso: ");
                identificador = Leer.datoString();
                proceso.eliminarProceso(identificador);
                break;
            case 7:
                System.out.println("FINAL");
                break;
            default:
                System.out.println("OPCION Erronea");
                break;
            }
        } while (opcion != 7);
    }
}