package compilador308_309;

import misClases.avaliacion3.Fichero;

class compi309
{
    public static void main(final String[] args) {
        final Fichero ficheroOrigen = new Fichero();
        final Fichero ficheroDestino = new Fichero();
        String mensaje = "Nombre del fichero origen: ";
        ficheroOrigen.asignaFicheroLectura(mensaje);
        mensaje = "Nombre del fichero destino: ";
        ficheroDestino.asignaFicheroEscritura(mensaje);
        ficheroOrigen.copia(ficheroDestino);
        System.out.print("Copiado el fichero: " + ficheroOrigen.dameNombre() + " en el fichero: " + ficheroDestino.dameNombre());
        System.out.println("\nAmosamos el fichero origen: " + ficheroOrigen.dameNombre());
        ficheroOrigen.amosa();
        System.out.println("\nAmosamos el fichero destino: " + ficheroDestino.dameNombre());
        ficheroDestino.amosa();
    }
}