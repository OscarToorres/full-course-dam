package misClases.avaliacion2;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CArrayCaracteres
{
    private char[] cadena;
    
    public CArrayCaracteres() {
        this.cadena = new char[50];
    }
    
    public void recolle() {
        final InputStreamReader isr = new InputStreamReader(System.in);
        final BufferedReader flujoE = new BufferedReader(isr);
        try {
            int total = flujoE.read(this.cadena, 0, this.cadena.length);
            total -= 2;
            this.cadena[total] = (this.cadena[total + 1] = '\0');
        }
        catch (IOException ex) {}
    }
    
    public void amosa() {
        System.out.println();
        for (int i = 0; this.cadena[i] != '\0'; ++i) {
            System.out.print(this.cadena[i]);
        }
    }
    
    public void maiusculas() {
        System.out.println();
        for (int i = 0; this.cadena[i] != '\0'; ++i) {
            if (this.cadena[i] >= 'a' && this.cadena[i] <= 'z') {
                System.out.print((char)(this.cadena[i] - ' '));
            }
            else if (this.cadena[i] == '\ufffd') {
                System.out.print('\ufffd');
            }
            else {
                System.out.print(this.cadena[i]);
            }
        }
    }
    
    public void minusculas() {
        System.out.println();
        for (int i = 0; this.cadena[i] != '\0'; ++i) {
            if (this.cadena[i] >= 'A' && this.cadena[i] <= 'Z') {
                System.out.print((char)(this.cadena[i] + ' '));
            }
            else if (this.cadena[i] == '\ufffd') {
                System.out.print('\ufffd');
            }
            else {
                System.out.print(this.cadena[i]);
            }
        }
    }
    
    public void arroba() {
        System.out.println();
        for (int i = 0; this.cadena[i] != '\0'; ++i) {
            if (this.cadena[i] == 'a' || this.cadena[i] == 'A') {
                System.out.print('@');
            }
            else {
                System.out.print(this.cadena[i]);
            }
        }
    }
    
    public void espacioBlanco() {
        System.out.println();
        boolean mostrar = false;
        for (int i = 0; this.cadena[i] != '\0'; ++i) {
            if (this.cadena[i] == ' ') {
                if (mostrar) {
                    System.out.print(this.cadena[i]);
                    mostrar = false;
                }
            }
            else {
                System.out.print(this.cadena[i]);
                mostrar = true;
            }
        }
    }
    
    public void sinNumeros() {
        System.out.println();
        for (int i = 0; this.cadena[i] != '\0'; ++i) {
            if (this.cadena[i] < '0' || this.cadena[i] > '9') {
                System.out.print(this.cadena[i]);
            }
        }
    }
}