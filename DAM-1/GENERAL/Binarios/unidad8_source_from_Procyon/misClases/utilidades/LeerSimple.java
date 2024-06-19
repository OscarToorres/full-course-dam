// 
// Decompiled by Procyon v0.5.36
// 

package misClases.utilidades;

import java.io.IOException;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class LeerSimple
{
    public static String dato() {
        String sdato = "";
        try {
            final InputStreamReader isr = new InputStreamReader(System.in);
            final BufferedReader flujoE = new BufferedReader(isr);
            sdato = flujoE.readLine();
        }
        catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
        return sdato;
    }
    
    public static short datoShort() {
        return Short.parseShort(dato());
    }
    
    public static int datoInt() {
        return Integer.parseInt(dato());
    }
    
    public static long datoLong() {
        return Long.parseLong(dato());
    }
    
    public static float datoFloat() {
        return Float.parseFloat(dato());
    }
    
    public static double datoDouble() {
        return Double.parseDouble(dato());
    }
}
