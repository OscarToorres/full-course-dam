package misClases.avaliacion1;

import java.util.Scanner;

public class CHora
{
    private int hora;
    private int minuto;
    private int segundo;
    private Scanner teclado;
    
    public CHora() {
        this.teclado = new Scanner(System.in);
    }
    
    public void recogeSegundos() {
        System.out.print("Introduzca os segundos: ");
        this.segundo = this.teclado.nextInt();
        while (this.segundo > 60 || this.segundo < 0) {
            System.out.print("Introduzca os segundos: ");
            this.segundo = this.teclado.nextInt();
        }
    }
    
    public void recogeMinutos() {
        System.out.print("Introduzca os minutos: ");
        this.minuto = this.teclado.nextInt();
        while (this.minuto > 60 || this.minuto < 0) {
            System.out.print("Introduzca os minutos: ");
            this.minuto = this.teclado.nextInt();
        }
    }
    
    public void recogeHora() {
        System.out.print("Introduzca a hora: ");
        this.hora = this.teclado.nextInt();
        while (this.hora > 23 || this.hora < 0) {
            System.out.print("Introduzca a hora: ");
            this.hora = this.teclado.nextInt();
        }
    }
    
    private String Hora() {
        String dato;
        if (this.hora < 10) {
            dato = "0";
        }
        else {
            dato = "";
        }
        return String.valueOf(dato) + this.hora + ":";
    }
    
    private String Minuto() {
        String dato;
        if (this.minuto < 10) {
            dato = "0";
        }
        else {
            dato = "";
        }
        return String.valueOf(dato) + this.minuto + ":";
    }
    
    private String Segundo() {
        String dato;
        if (this.segundo < 10) {
            dato = "0";
        }
        else {
            dato = "";
        }
        return String.valueOf(dato) + this.segundo;
    }
    
    public void amosaResultado() {
        System.out.print("Resultado: " + this.Hora() + this.Minuto() + this.Segundo());
    }
}