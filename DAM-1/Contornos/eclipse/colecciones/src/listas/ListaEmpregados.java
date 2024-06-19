package listas;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ListaEmpregados {

	public static void main(String[] args) {

		List<Empregado> empregados = new ArrayList<>();
		Empregado empregado1 = new Empregado("Anna", "12345678P", new Date());
		empregados.add(empregado1);
		Empregado empregado2 = new Empregado("Anton", "12345678D", new Date());
		empregados.add(empregado2);
		
		int i = 1;
		for (Empregado empregado : empregados) {
			System.out.println(i + " : " + empregado.toString());
			i++;
		}
		
		String dni="12345678P";
		System.out.println("Procurar o dni " + dni);
		
		for (Empregado empregado : empregados) {
			if(empregado.dni.equals(dni)) {
				System.out.println("Encontrado: " + empregado.toString());
				break;
			}
		}
		
	}

}
