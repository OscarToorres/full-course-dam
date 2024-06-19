package tarea3_11;

public class Calculo {

    private static final int MAX_NUM = 4;
    private double suma = 0.0;
    private double media = 0.0;
    private double[] numeros = new double[MAX_NUM];

    
    public double[] inserirValores(double[] valor) {
    	for(int i = 0; i < this.numeros.length; i++)
    	if (valor.length <= this.numeros.length)
    		this.numeros[i] = valor[i];
    	else
    		i = MAX_NUM;
    	return numeros;
    }
    
    public double sumar() {
        double suma = 0.0;
        for (int k = 0; k < numeros.length; k++)
            suma += numeros[k];
        return suma;
    }

    public double media() {
    	media = this.sumar() / this.numeros.length;
        return media;
    }

    public double getSuma() {
        return suma;
    }

    public double getMedia() {
        return media;
    }
}