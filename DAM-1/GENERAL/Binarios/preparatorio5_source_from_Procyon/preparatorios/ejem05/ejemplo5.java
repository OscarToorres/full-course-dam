// 
// Decompiled by Procyon v0.5.36
// 

package preparatorios.ejem05;

import java.io.IOException;
import java.io.File;

public class ejemplo5
{
    public static void main(final String[] args) {
        final File fichero = new File("ejem05.dat");
        try {
            final CLibreria libreria = new CLibreria(fichero);
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
                        libreria.insertarLibro();
                        continue;
                    }
                    case 6: {
                        System.out.print("Dame c\u00f3digo de libro: ");
                        final int codigo = Leer.datoInt();
                        libreria.modificarLibro(codigo);
                        continue;
                    }
                    case 7: {
                        System.out.print("Dame c\u00f3digo de libro: ");
                        final int codigo = Leer.datoInt();
                        libreria.eliminarLibro(codigo);
                        continue;
                    }
                    case 8: {
                        libreria.actualizar();
                        System.out.println("Libreria ACTUALIZADA");
                        continue;
                    }
                    case 9: {
                        System.out.println("FINAL");
                        continue;
                    }
                    default: {
                        System.out.println("OPCION Erronea");
                        continue;
                    }
                }
            } while (numero != 9);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
