package misClases.avaliacion2;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CString
{
    private String string;
    
    public void recolle() {
        final InputStreamReader isr = new InputStreamReader(System.in);
        final BufferedReader flujoE = new BufferedReader(isr);
        try {
            this.string = flujoE.readLine();
        }
        catch (IOException ex) {}
    }
    
    public void amosa() {
        System.out.println(this.string);
    }
    
    public void maiusculas() {
        System.out.println(this.string.toUpperCase());
    }
    
    public void minusculas() {
        System.out.println(this.string.toLowerCase());
    }
    
    public void arroba() {
        final StringBuffer stringB = new StringBuffer(this.string);
        for (int i = 0; i < stringB.length(); ++i) {
            if (stringB.charAt(i) == 'a' || stringB.charAt(i) == 'A') {
                stringB.setCharAt(i, '@');
            }
        }
        System.out.println(stringB.toString());
    }
    
    public void espacioBlanco() {
        final StringBuffer stringB = new StringBuffer(this.string);
        boolean borrar = true;
        int i = 0;
        while (i < stringB.length()) {
            if (stringB.charAt(i) == ' ') {
                if (borrar) {
                    stringB.deleteCharAt(i);
                }
                else {
                    borrar = true;
                    ++i;
                }
            }
            else {
                borrar = false;
                ++i;
            }
        }
        System.out.println(stringB.toString());
    }
    
    public void sinNumeros() {
        final StringBuffer stringB = new StringBuffer(this.string);
        int i = 0;
        while (i < stringB.length()) {
            if (stringB.charAt(i) >= '0' && stringB.charAt(i) <= '9') {
                stringB.deleteCharAt(i);
            }
            else {
                ++i;
            }
        }
        System.out.println(stringB.toString());
    }
}