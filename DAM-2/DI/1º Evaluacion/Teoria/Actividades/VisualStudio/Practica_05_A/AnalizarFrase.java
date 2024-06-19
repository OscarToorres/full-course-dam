public class AnalizarFrase {
    
    private String cadena; 

    //Constructor de la cadena
    public AnalizarFrase(String cadena) {
        this.cadena = cadena;
    }

    //Constructor vacio
    public AnalizarFrase() {
    }

    public String getFrase() {
        return cadena;
    }

    public void setFrase(String frase) {
        this.cadena = frase;
    }

    //Eliminar los espacios en blanco
    public String cadenaSinEspacios() {
        return cadena.trim();
    }

    //Se sustituye los espacios en blanco para despues con el lenght contar las letras totales de la cadena
    public int contarLetras(String cadena) {
        String cadena2 = cadena.replace(" ", "");
        int i = cadena2.length();
        return i;
    }

    //Pasamos la cadena de String a stringBuffer para poder trabajar con los metodos de esta.
    //De esta forma llamamos al metodo invertir de la clase StringBuffer y asi obtenemos la cadena invertida
    public StringBuffer invertirFrase() {
        StringBuffer invertida = new StringBuffer(this.cadena);
        return invertida.reverse();
    }

    //Creamos un array de Strings e indicamos con el split que es lo que nos indica la separacion de cada conjunto
    //de caracteres para indicar que es una palabra. Despues se devuelve la longitud del String creado
    public int contarPalabras(String cadena) {
        String[] words = cadena.split("\\s+");
        return words.length;
    }

    //Creamos un array de Strings e indicamos con el split que es lo que nos indica la separacion de cada conjunto
    //de caracteres. Despues creamos un bucle para recorrerlo e ir pintandolo por pantalla para ver las palabras separadas
    public void separarPalabras() {
        String[] words = cadena.split("\\s+");
        for(int i = 0; i < words.length; i++) 
            System.out.println(words[i]);  
    }

    //Creamos un charArray del String de caracteres pasandolo a minusculas para no tener que comprobar tambien 
    //con las mayusculas. Hacemos un bucle recoriendo el array y buscando la primera vocal, en cuanto la encuentre
    //sale del bucle y devuelve el numero que encontro
    public int primeraVolcal() {
        char[] frase = cadena.toLowerCase().toCharArray();
        int j = 0;
        for(j = 0; j < frase.length; j++){
            if(frase[j] == 'a' || frase[j] == 'e' || frase[j] == 'i' || frase[j] == 'o' || frase[j] == 'u')
                break;
        }
        return j + 1;
    }

    //Creamos un charArray del String de caracteres pasandolo a minusculas para no tener que comprobar tambien 
    //con las mayusculas. Hacemos un bucle recoriendo el array y buscando la ultima vocal, en cuanto la encuentre
    //sale del bucle y devuelve el numero que encontro
    public int ultimaVocal() {
        char[] frase = cadena.toLowerCase().toCharArray();
        int j = 0;
        for(j = frase.length - 1; j > 0 ; j--){
            if(frase[j] == 'a' || frase[j] == 'e' || frase[j] == 'i' || frase[j] == 'o' || frase[j] == 'u')
                break;
        }
        return j + 1;
    }

    //Comprobamos si la primera letra del array es mayuscula
    public boolean comprobarMayuscula() {
        char [] frase = cadena.toCharArray();
        if(Character.isUpperCase(frase[0]))
            return true;        
        return false;
    }

    //Comprobamos si la primera letra del array es minuscula
    public String convertirMinuscula() {
        return cadena.toLowerCase();
    }

    //Pasamos un String de caracteres a un array y despues lo pintamos por panralla con un bucle
    public void vectorizar() {
        char [] frase = cadena.toCharArray();
        for (int i = 0; i < frase.length; i++)
            System.out.print(frase[i] + " ");
    }
}