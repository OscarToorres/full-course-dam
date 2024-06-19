package compilador313_315;

import misClases.avaliacion3.Fichero;

public class compi315
{
    public static void main(final String[] args) {
        final Fichero fichero = new Fichero();
        final Fichero ficheroOrigen = new Fichero();
        final Fichero ficheroDestino = new Fichero();
        int numero;
        do {
            numero = Fichero.dameOpcion();
            switch (numero) {
                case 1: {
                    fichero.asignaFichero();
                    fichero.amosa();
                    continue;
                }
                case 2: {
                    String mensaje = "Nombre del fichero origen: ";
                    ficheroOrigen.asignaFicheroLectura(mensaje);
                    mensaje = "Nombre del fichero destino: ";
                    ficheroDestino.asignaFicheroEscritura(mensaje);
                    ficheroOrigen.copia(ficheroDestino);
                    continue;
                }
                case 3: {
                    fichero.asignaFichero();
                    fichero.amosaFinal();
                    continue;
                }
                case 4: {
                    fichero.asignaFichero();
                    fichero.amosaInicio();
                    continue;
                }
                case 5: {
                    fichero.asignaFichero();
                    fichero.amosaLineaMaior();
                    continue;
                }
                case 6: {
                    fichero.asignaFichero();
                    fichero.amosaLineaMaiorMenor();
                    continue;
                }
                case 7: {
                    fichero.asignaFichero();
                    fichero.amosaPalabras();
                    continue;
                }
                case 8: {
                    System.out.println("FINAL");
                    continue;
                }
                default: {
                    System.out.println("OPCION Erronea");
                    continue;
                }
            }
        } while (numero != 8);
    }
}