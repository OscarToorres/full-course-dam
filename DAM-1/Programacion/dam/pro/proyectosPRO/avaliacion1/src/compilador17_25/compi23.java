package compilador17_25;

import java.util.Scanner;

public class compi23 {

	public static void main(String[] args) {
		Scanner teclado = new java.util.Scanner(System.in);
		
		float salario;
		int i = 1; 
		int numEmp;
		int j = 0;
		int k = 0;
		float gastoTotal = 0;
		
		System.out.print("Cuantos empleados hay: ");
		numEmp = teclado.nextInt();

		while (i <= numEmp) {
			System.out.print("Dame suelo " + i + ": ");
			salario = teclado.nextFloat();
				if (salario >= 100 && salario <= 300) {
					j++;
				}else if (salario > 300) {
					k++;
				}
			gastoTotal= gastoTotal + salario;
			i++;
		}
		teclado.close();
		
		System.out.println("Empleados con sueldos entre 100 y 300: " + j);
		System.out.println("Empleados con sueldos supeririores a 300: " + k);
		System.out.println("Gasto total de la empresa en sueldos: " + gastoTotal);	
		
	}
}	
		
		/*
		Scanner teclado = new java.util.Scanner(System.in);
		int numEmp;

		float[] salario = new float[6];
		float gastoMedio = 0;

		int i = 0;
		int j = 0;
		int k = 0;

		System.out.println("\nCuantos empleados hay: ");
		numEmp = teclado.nextInt();

		while (i < numEmp) {
			System.out.println("Dame suelo " + (i + 1));
			salario[i] = teclado.nextFloat();
			i++;
		}

		teclado.close();
		i = 0;
		while (i < numEmp) {
			if (salario[i] >= 100) {
				if (salario[i] <= 300) {
					j++;
				} else {
					k++;
				}
			}
			i++;
		}

		i = 0;
		while (i < numEmp) {
			gastoMedio = salario[i] + gastoMedio;
			i++;
		}
		System.out.println("Empleados con sueldos entre 100 y 300: " + j);
		System.out.println("Empleados con sueldos supeririores a 300: " + k);
		System.out.println("Gasto total de la empresa en sueldos: " + gastoMedio);
		*/

