package exame;

import java.io.File;

public class proba {
	public static void main(String[] args) {
		CHospital hospital;
		File fichero;
		int numero;
		String codigo;
		fichero = new File("exame.dat");
		hospital = new CHospital(fichero);
		do {
			numero = hospital.dameOpcion();
			switch (numero) {
			case 1:
				hospital.llenar();
				System.out.println("Hospital LLENO");
				break;
			case 2:
				hospital.vaciar();
				System.out.println("Hospital VACIO");
				break;
			case 3:
				hospital.mostrar();
				break;
			case 4:
				System.out.print("Dame código de paciente: ");
				codigo = Leer.datoString();
				hospital.mostrarPaciente(codigo);
				break;
			case 5:
				hospital.insertarPaciente();
				break;
			case 6:
				System.out.print("Dame código de paciente: ");
				codigo = Leer.datoString();
				hospital.modificarPaciente(codigo);
				break;
			case 7:
				System.out.print("Dame código de paciente: ");
				codigo = Leer.datoString();
				hospital.eliminarPaciente(codigo);
				break;
			case 8:
				hospital.salvar();
				System.out.println("Hospital SALVADO en fichero");
				break;
			case 9:
				hospital.restaurar();
				System.out.println("Hospital RESTAURADO desde fichero");
				break;
			case 10:
				System.out.println("FINAL");
				break;
			default:
				System.out.println("OPCION Erronea");
				break;
			}
		} while (numero != 10);
	}
}