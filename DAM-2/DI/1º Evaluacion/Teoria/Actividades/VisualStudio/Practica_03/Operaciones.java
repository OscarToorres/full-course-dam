public class Operaciones extends NumeroEntero {

    //Contructores

    public Operaciones() {
    }

    public Operaciones(int valor) {
        super(valor);
    }

    //Metodos

    //Suma dos numeros enteros
    public int suma(NumeroEntero numero1, NumeroEntero numero2) {
        return numero1.getValor() + numero2.getValor();
    }

    //Resta dos numeros enteros
    public int resta(NumeroEntero numero1, NumeroEntero numero2) {
        return numero1.getValor() - numero2.getValor();
    }
    
    //Compara dos numeros enteros
    public int comparacion(NumeroEntero numero1, NumeroEntero numero2) {
        if (numero1.getValor() == numero2.getValor()){
            return 0;
        }else if (numero1.getValor() > numero2.getValor()){
            return 1;
        }else
            return -1;        
        
        }

}
