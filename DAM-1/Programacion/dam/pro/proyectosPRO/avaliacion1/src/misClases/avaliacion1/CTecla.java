package misClases.avaliacion1;

import java.io.IOException;
import java.util.Scanner;

public class CTecla
{
    private char dixito;
    private char vocal;
    private char vocalm;
    private char consonante;
    private char consonantem;
    private Scanner teclado;
    
    public CTecla() {
        this.teclado = new Scanner(System.in);
    }
    
    public void recogeDixito() throws IOException {
        System.out.print("Introduzca un dixito: ");
        this.dixito = (char)System.in.read();
        this.teclado.nextLine();
        while (this.dixito > '9' || this.dixito < '0') {
            System.out.print("Introduzca un dixito: ");
            this.dixito = (char)System.in.read();
            this.teclado.nextLine();
        }
    }
    
    public void recogeVocalMinus() throws IOException {
        System.out.print("Introduzca unha vocal minuscula: ");
        this.vocal = (char)System.in.read();
        this.teclado.nextLine();
        while (this.vocal != 'a' && this.vocal != 'e' && this.vocal != 'i' && this.vocal != 'o' && this.vocal != 'u') {
            System.out.print("Introduzca unha vocal minuscula: ");
            this.vocal = (char)System.in.read();
            this.teclado.nextLine();
        }
    }
    
    public void recogeVocalMaius() throws IOException {
        System.out.print("Introduzca unha vocal maiuscula: ");
        this.vocalm = (char)System.in.read();
        this.teclado.nextLine();
        while (this.vocalm != 'A' && this.vocalm != 'E' && this.vocalm != 'I' && this.vocalm != 'O' && this.vocalm != 'U') {
            System.out.print("Introduzca unha vocal maiuscula: ");
            this.vocalm = (char)System.in.read();
            this.teclado.nextLine();
        }
    }
    
    public void recogeConsonanteMinus() throws IOException {
        System.out.print("Introduzca unha consonante minuscula: ");
        this.consonante = (char)System.in.read();
        this.teclado.nextLine();
        while (this.consonante < 'b' || this.consonante > 'z' || this.consonante == 'a' || this.consonante == 'e' || this.consonante == 'i' || this.consonante == 'o' || this.consonante == 'u') {
            System.out.print("Introduzca unha consonante minuscula: ");
            this.consonante = (char)System.in.read();
            this.teclado.nextLine();
        }
    }
    
    public void recogeConsonanteMaius() throws IOException {
        System.out.print("Introduzca unha consonante maiscula: ");
        this.consonantem = (char)System.in.read();
        this.teclado.nextLine();
        while (this.consonantem < 'B' || this.consonantem > 'Z' || this.consonantem == 'A' || this.consonante == 'E' || this.consonante == 'I' || this.consonante == 'O' || this.consonante == 'U') {
            System.out.print("Introduzca unha consonante maiscula: ");
            this.consonantem = (char)System.in.read();
            this.teclado.nextLine();
        }
    }
    
    public void amosaResultado() {
        System.out.print("Resultado: " + this.dixito + ", " + this.vocal + ", " + this.vocalm + ", " + this.consonante + ", " + this.consonantem);
    }
}