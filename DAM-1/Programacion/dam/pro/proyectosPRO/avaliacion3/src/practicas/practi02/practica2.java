package practicas.practi02;

public class practica2
{
    public static void main(final String[] args) {
        final CJuzgado juzgado = new CJuzgado();
        int opcion;
        do {
            opcion = juzgado.dameOpcion();
            switch (opcion) {
                case 1: {
                    juzgado.llenar();
                    System.out.println("Juzgado LLENO");
                    continue;
                }
                case 2: {
                    juzgado.vaciar();
                    System.out.println("Juzgado VACIO");
                    continue;
                }
                case 3: {
                    juzgado.mostrar();
                    continue;
                }
                case 4: {
                    juzgado.insertarProceso();
                    continue;
                }
                case 5: {
                    System.out.print("Dame identificador de proceso: ");
                    final String identificador = Leer.datoString();
                    juzgado.modificarProceso(identificador);
                    continue;
                }
                case 6: {
                    System.out.print("Dame identificador de proceso: ");
                    final String identificador = Leer.datoString();
                    juzgado.eliminarProceso(identificador);
                    continue;
                }
                case 7: {
                    System.out.println("FINAL");
                    continue;
                }
                default: {
                    System.out.println("OPCION Erronea");
                    continue;
                }
            }
        } while (opcion != 7);
    }
}