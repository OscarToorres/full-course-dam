package teoria.capitulo10;

import misClases.teoria.ESaldoInsuficiente;
import java.io.PrintStream;
import misClases.teoria.CBanco;
import misClases.teoria.CCuentaCorrienteConIn;
import misClases.teoria.CCuentaCorriente;
import misClases.teoria.CCuentaAhorro;
import misClases.utilidades.Leer;
import misClases.teoria.CCuenta;

class CApFecha2
{
    public static CCuenta leerDatos(final int op) {
        CCuenta obj = null;
        System.out.print("Nombre.................: ");
        final String nombre = Leer.dato();
        System.out.print("Cuenta.................: ");
        final String cuenta = Leer.dato();
        System.out.print("Saldo..................: ");
        final double saldo = Leer.datoDouble();
        System.out.print("Tipo de inter\u00e9s........: ");
        final double tipoi = Leer.datoDouble();
        if (op == 1) {
            System.out.print("Mantenimiento..........: ");
            final double mant = Leer.datoDouble();
            obj = new CCuentaAhorro(nombre, cuenta, saldo, tipoi, mant);
        }
        else {
            System.out.print("Importe por transacci\u00f3n: ");
            final double imptrans = Leer.datoDouble();
            System.out.print("Transacciones exentas..: ");
            final int transex = Leer.datoInt();
            if (op == 2) {
                obj = new CCuentaCorriente(nombre, cuenta, saldo, tipoi, imptrans, transex);
            }
            else {
                obj = new CCuentaCorrienteConIn(nombre, cuenta, saldo, tipoi, imptrans, transex);
            }
        }
        return obj;
    }
    
    public static int menu() {
        System.out.print("\n\n");
        System.out.println("1. Saldo");
        System.out.println("2. Buscar siguiente");
        System.out.println("3. Ingreso");
        System.out.println("4. Reintegro");
        System.out.println("5. Anhadir");
        System.out.println("6. Eliminar");
        System.out.println("7. Mantenimiento");
        System.out.println("8. Mostrar");
        System.out.println("9. Salir");
        System.out.println();
        System.out.print("   Opcion: ");
        int op;
        do {
            op = Leer.datoInt();
        } while (op < 1 || op > 9);
        return op;
    }
    
    public static void main(final String[] args) throws ESaldoInsuficiente {
        final PrintStream flujoS = System.out;
        CBanco banco = new CBanco();
        int opcion = 0;
        int pos = -1;
        String cadenabuscar = null;
        boolean eliminado = false;
        do {
            opcion = menu();
            switch (opcion) {
                case 1: {
                    flujoS.print("Nombre o cuenta, total o parcial ");
                    cadenabuscar = Leer.dato();
                    pos = banco.buscar(cadenabuscar, 0);
                    if (pos != -1) {
                        flujoS.println(banco.clienteEn(pos).obtenerNombre());
                        flujoS.println(banco.clienteEn(pos).obtenerCuenta());
                        flujoS.println(banco.clienteEn(pos).estado());
                        continue;
                    }
                    if (banco.longitud() != 0) {
                        flujoS.println("b\u00fasqueda fallida");
                        continue;
                    }
                    flujoS.println("no hay clientes");
                    continue;
                }
                case 2: {
                    pos = banco.buscar(cadenabuscar, pos + 1);
                    if (pos != -1) {
                        flujoS.println(banco.clienteEn(pos).obtenerNombre());
                        flujoS.println(banco.clienteEn(pos).obtenerCuenta());
                        flujoS.println(banco.clienteEn(pos).estado());
                        continue;
                    }
                    if (banco.longitud() != 0) {
                        flujoS.println("b\u00fasqueda fallida");
                        continue;
                    }
                    flujoS.println("no hay clientes");
                    continue;
                }
                case 3:
                case 4: {
                    flujoS.print("Cuenta: ");
                    final String cuenta = Leer.dato();
                    pos = banco.buscar(cuenta, 0);
                    if (pos == -1) {
                        if (banco.longitud() != 0) {
                            flujoS.println("b\u00fasqueda fallida");
                            continue;
                        }
                        flujoS.println("no hay clientes");
                        continue;
                    }
                    else {
                        flujoS.print("Cantidad: ");
                        final double cantidad = Leer.datoDouble();
                        if (opcion == 3) {
                            banco.clienteEn(pos).ingreso(cantidad);
                            continue;
                        }
                        banco.clienteEn(pos).reintegro(cantidad);
                        continue;
                    }
                }
                case 6: {
                    flujoS.print("Cuenta: ");
                    final String cuenta = Leer.dato();
                    eliminado = banco.eliminar(cuenta);
                    if (eliminado) {
                        flujoS.println("registro eliminado");
                        continue;
                    }
                    if (banco.longitud() != 0) {
                        flujoS.println("cuenta no encontrada");
                        continue;
                    }
                    flujoS.println("no hay clientes");
                    continue;
                }
                default: {
                    continue;
                }
                case 5: {
                    flujoS.print("Tipo de cuenta: 1-(CA), 2-(CC), 3-CCI  ");
                    do {
                        opcion = Leer.datoInt();
                    } while (opcion < 1 || opcion > 3);
                    banco.anhadir(leerDatos(opcion));
                    continue;
                }
                case 7: {
                    for (pos = 0; pos < banco.longitud(); ++pos) {
                        banco.clienteEn(pos).comisiones();
                        banco.clienteEn(pos).intereses();
                    }
                    continue;
                }
                case 8: {
                    banco.mostrar();
                    continue;
                }
                case 9: {
                    banco = null;
                    continue;
                }
            }
        } while (opcion != 9);
    }
}