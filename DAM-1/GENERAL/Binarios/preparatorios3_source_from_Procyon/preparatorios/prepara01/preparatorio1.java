// 
// Decompiled by Procyon v0.5.36
// 

package preparatorios.prepara01;

public class preparatorio1
{
    public static void main(final String[] args) {
        final CFruteria fruteria = new CFruteria();
        int numero;
        do {
            numero = fruteria.dameOpcion();
            switch (numero) {
                case 1: {
                    fruteria.llenar();
                    System.out.println("Fruteria LLENA");
                    continue;
                }
                case 2: {
                    fruteria.vaciar();
                    System.out.println("Fruteria VACIA");
                    continue;
                }
                case 3: {
                    fruteria.mostrar();
                    continue;
                }
                case 4: {
                    System.out.print("Dame c\u00f3digo de fruta: ");
                    final String codigo = Leer.datoString();
                    fruteria.mostrarFruta(codigo);
                    continue;
                }
                case 5: {
                    System.out.print("Dame c\u00f3digo de fruta: ");
                    final String codigo = Leer.datoString();
                    fruteria.eliminarFruta(codigo);
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
