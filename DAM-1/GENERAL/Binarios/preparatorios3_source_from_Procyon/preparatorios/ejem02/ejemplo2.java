// 
// Decompiled by Procyon v0.5.36
// 

package preparatorios.ejem02;

public class ejemplo2
{
    public static void main(final String[] args) {
        final CLibreria libreria = new CLibreria();
        int numero;
        do {
            numero = libreria.dameOpcion();
            switch (numero) {
                case 1: {
                    libreria.llenar();
                    System.out.println("Libreria LLENA");
                    continue;
                }
                case 2: {
                    libreria.vaciar();
                    System.out.println("Libreria VACIA");
                    continue;
                }
                case 3: {
                    libreria.mostrar();
                    continue;
                }
                case 4: {
                    System.out.print("Dame c\u00f3digo de libro: ");
                    final int codigo = Leer.datoInt();
                    libreria.mostrarLibro(codigo);
                    continue;
                }
                case 5: {
                    System.out.print("Dame c\u00f3digo de libro: ");
                    final int codigo = Leer.datoInt();
                    libreria.eliminarLibro(codigo);
                    continue;
                }
                case 6: {
                    System.out.println("FINAL");
                    continue;
                }
                default: {
                    System.out.println("OPCION Erronea");
                    continue;
                }
            }
        } while (numero != 6);
    }
}
