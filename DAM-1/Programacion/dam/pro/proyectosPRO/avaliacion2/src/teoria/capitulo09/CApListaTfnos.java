package teoria.capitulo09;

import java.io.PrintStream;
import java.io.IOException;
import misClases.teoria.CPersona;
import misClases.teoria.CListaTfnos;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import misClases.teoria.Leer;

public class CApListaTfnos
{
    public static int menu() {
        System.out.print("\n\n");
        System.out.println("1. Buscar");
        System.out.println("2. Buscar siguiente");
        System.out.println("3. Anhadir");
        System.out.println("4. Eliminar");
        System.out.println("5. Mostrar");
        System.out.println("6. Salir");
        System.out.println();
        System.out.print("   Opcion: ");
        int op;
        do {
            op = Leer.datoInt();
        } while (op < 1 || op > 6);
        return op;
    }
    
    public static void main(final String[] args) {
        final InputStreamReader isr = new InputStreamReader(System.in);
        final BufferedReader flujoE = new BufferedReader(isr);
        final PrintStream flujoS = System.out;
        CListaTfnos listatfnos = new CListaTfnos();
        int opcion = 0;
        int pos = -1;
        String cadenabuscar = null;
        boolean eliminado = false;
        do {
            try {
                opcion = menu();
                switch (opcion) {
                    case 1: {
                        flujoS.print("conjunto de caracteres a buscar ");
                        cadenabuscar = flujoE.readLine();
                        pos = listatfnos.buscar(cadenabuscar, 0);
                        if (pos != -1) {
                            flujoS.println(listatfnos.valorEn(pos).obtenerNombre());
                            flujoS.println(listatfnos.valorEn(pos).obtenerDireccion());
                            flujoS.println(listatfnos.valorEn(pos).obtenerTelefono());
                            break;
                        }
                        if (listatfnos.longitud() != 0) {
                            flujoS.println("b\ufffdsqueda fallida");
                            break;
                        }
                        flujoS.println("lista vac\ufffda");
                        break;
                    }
                    case 2: {
                        pos = listatfnos.buscar(cadenabuscar, pos + 1);
                        if (pos != -1) {
                            flujoS.println(listatfnos.valorEn(pos).obtenerNombre());
                            flujoS.println(listatfnos.valorEn(pos).obtenerDireccion());
                            flujoS.println(listatfnos.valorEn(pos).obtenerTelefono());
                            break;
                        }
                        if (listatfnos.longitud() != 0) {
                            flujoS.println("b\ufffdsqueda fallida");
                            break;
                        }
                        flujoS.println("lista vac\ufffda");
                        break;
                    }
                    case 3: {
                        flujoS.print("nombre:    ");
                        final String nombre = flujoE.readLine();
                        flujoS.print("direccion: ");
                        final String direccion = flujoE.readLine();
                        flujoS.print("telefono:  ");
                        final long telefono = Leer.datoLong();
                        listatfnos.anhadir(new CPersona(nombre, direccion, telefono));
                        break;
                    }
                    case 4: {
                        flujoS.print("telefono: ");
                        final long telefono = Leer.datoLong();
                        eliminado = listatfnos.eliminar(telefono);
                        if (eliminado) {
                            flujoS.println("registro eliminado");
                            break;
                        }
                        if (listatfnos.longitud() != 0) {
                            flujoS.println("telefono no encontrado");
                            break;
                        }
                        flujoS.println("lista vac\ufffda");
                        break;
                    }
                    case 5: {
                        listatfnos.mostrarListaTfnos();
                        break;
                    }
                    case 6: {
                        listatfnos = null;
                        break;
                    }
                }
            }
            catch (IOException ex) {}
        } while (opcion != 6);
    }
}
