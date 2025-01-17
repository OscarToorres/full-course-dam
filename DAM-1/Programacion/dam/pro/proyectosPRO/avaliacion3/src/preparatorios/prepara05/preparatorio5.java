package preparatorios.prepara05;

import java.io.IOException;
import java.io.File;

public class preparatorio5
{
    public static void main(final String[] args) {
        final File fichero = new File("prepara05.dat");
        try {
            final CFruteria fruteria = new CFruteria(fichero);
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
                        fruteria.insertarFruta();
                        continue;
                    }
                    case 6: {
                        System.out.print("Dame c\u00f3digo de fruta: ");
                        final String codigo = Leer.datoString();
                        fruteria.modificarFruta(codigo);
                        continue;
                    }
                    case 7: {
                        System.out.print("Dame c\u00f3digo de fruta: ");
                        final String codigo = Leer.datoString();
                        fruteria.eliminarFruta(codigo);
                        continue;
                    }
                    case 8: {
                        fruteria.actualizar();
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
