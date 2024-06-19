public class FraseApp {

    public static void main (String [] args) {

        Frase frase = new Frase("Este es un ejemplo");

        // System.out.println("Cadena sin espacios: " + frase.cadenaSinEspacios());
        // System.out.println("Numero de letras: " + frase.contarLetras());
        // System.out.println("Cadena invertida: " + frase.invertirFrase());
        // System.out.println("Numero de palabras: " + frase.contarPalabras());
        // System.out.println("Palabras separadas: ");
        // frase.separarPalabras();
        // System.out.println("Primera voacal: " + frase.primeraVolcal());
        //System.out.println("Ultima vocal: " + frase.ultimaVocal());
        //System.out.println("Primera mayuscula: " + frase.comprobarMayuscula());
        //System.out.println("Cadena en minusculas: " + frase.convertirMinuscula());
        System.out.println("Cadena vectorizada: ");
        frase.vectorizar();
    }
    
}
