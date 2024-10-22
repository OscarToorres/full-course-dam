package exameTerceira;

import java.io.File;
import java.io.IOException;

import exameTerceira.datos.CDepartamento;
import exameTerceira.utilidades.Leer;

public class terceira {
	
    public static void main(final String[] args) {
        final File fichero = new File("prepara05.dat");
        try {
            final CDepartamento departamento = new CDepartamento(fichero);
            int numero;
            do {
                numero = departamento.dameOpcion();
                switch (numero) {
                    case 1: {
                    	departamento.llenar();
                        System.out.println("Departamento con profesores");
                        continue;
                    }
                    case 2: {
                    	departamento.vaciar();
                        System.out.println("Departamento sin profesores");
                        continue;
                    }
                    case 3: {
                    	departamento.mostrar();
                        continue;
                    }
                    case 4: {
                        System.out.print("Dame CODIGO de profesor: ");
                        final String codigo = Leer.datoString();
                        departamento.mostrarFruta(codigo);
                        continue;
                    }
                    case 5: {
                    	departamento.insertarProfesor();
                        continue;
                    }
                    case 6: {
                        System.out.print("Dame codigo de profesor: ");
                        final String codigo = Leer.datoString();
                        departamento.modificarProfesor(codigo);
                        continue;
                    }
                    case 7: {
                        System.out.print("Dame codigo de profesor: ");
                        final String codigo = Leer.datoString();
                        departamento.eliminarProfesor(codigo);
                        continue;
                    }
                    case 8: {
                    	departamento.actualizar();
                        System.out.println("Departamento ACTUALIZADO");
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
