package practicas;

import misClases.avaliacion2.CString;
import misClases.avaliacion2.CArrayCaracteres;
import misClases.avaliacion2.CMatrices;
import misClases.teoria.Leer;

class practica5
{
    private static void menu() {
        System.out.println();
        System.out.println(" 1.- Matrices");
        System.out.println(" 2.- Array de caracteres");
        System.out.println(" 3.- String");
        System.out.println(" 4.- Sair");
        System.out.println();
        System.out.print(" Introduce opcion: ");
    }
    
    private static int dameOpcion() {
        menu();
        final int numero = Leer.datoInt();
        System.out.println();
        return numero;
    }
    
    public static void main(final String[] ar) {
        final CMatrices matrices = new CMatrices();
        final CArrayCaracteres cadena = new CArrayCaracteres();
        final CString string = new CString();
        int opcion;
        do {
            opcion = dameOpcion();
            switch (opcion) {
                case 1: {
                    matrices.recolle();
                    matrices.amosa('A', 'B');
                    matrices.trasposta('A', 'C');
                    matrices.trasposta('B', 'D');
                    matrices.amosa('C', 'D');
                    matrices.suma('A', 'B', 'C');
                    matrices.resta('A', 'B', 'D');
                    matrices.amosa('C', 'D');
                    matrices.resta('B', 'A', 'C');
                    matrices.multiplica('A', 'B', 'D');
                    matrices.amosa('C', 'D');
                    continue;
                }
                case 2: {
                    System.out.print(" Cadena:");
                    cadena.recolle();
                    cadena.amosa();
                    cadena.maiusculas();
                    cadena.minusculas();
                    cadena.arroba();
                    cadena.espacioBlanco();
                    cadena.sinNumeros();
                    cadena.amosa();
                    continue;
                }
                case 3: {
                    System.out.print(" String:");
                    string.recolle();
                    string.amosa();
                    string.maiusculas();
                    string.minusculas();
                    string.arroba();
                    string.espacioBlanco();
                    string.sinNumeros();
                    string.amosa();
                    continue;
                }
                case 4: {
                    System.out.println("FINAL");
                    continue;
                }
                default: {
                    System.out.println("OPCION Erronea");
                    continue;
                }
            }
        } while (opcion != 4);
    }
}