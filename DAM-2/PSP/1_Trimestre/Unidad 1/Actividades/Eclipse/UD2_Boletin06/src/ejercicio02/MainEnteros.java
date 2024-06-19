package ejercicio02;

import javax.swing.JOptionPane;

public class MainEnteros {

	public static void main(String[] args) {
		
		int numero;
		numero = Integer.parseInt(JOptionPane.showInputDialog("¿Cuantos valores? "));
		
		Enteros thread1 = new Enteros(numero, "Caracola", 1000);
		Enteros thread2 = new Enteros(numero, "Cangrejo", 1000);
		
		thread1.setPriority(Thread.MAX_PRIORITY);
		thread2.setPriority(Thread.MIN_PRIORITY);
		
		thread2.start();
		
		try {
			thread2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		thread1.start();
		
		try {
			thread1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		thread2.start();
//		
//		try {
//			thread2.join();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		try {
			for (int i = 1; i <= 5; i++) {
				System.out.println("Valor i = " + i + " en Hilo principal en main()");
				Thread.sleep(3000);
			}
		} catch(InterruptedException e) {
			System.out.println("Interrupcion del hilo principal en main()");
		}
		System.out.println("Termina Hilo principal en main()"); 
	}
}
