package listas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmpregadoApp {

	public static void main(String[] args) {

		List<Integer> numeros = new ArrayList<Integer>();
		numeros.add(100);
		numeros.add(200);
		numeros.add(-700);
		
		//Interaxion antiga
		for (int k = 0; k < numeros.size(); k++) {
			System.out.println(numeros.get(k));
		}
		
		//Interacion moderna
		for (Integer numero : numeros) {
			System.out.println(numeros);
		}
		
		Collections.sort(numeros);
		
		System.out.println(numeros);
	}

}
