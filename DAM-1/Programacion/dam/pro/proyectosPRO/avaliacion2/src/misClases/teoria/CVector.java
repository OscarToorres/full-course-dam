package misClases.teoria;

import java.util.Arrays;

public class CVector
{
    private double[] vector;
    private int nElementos;
    
    public CVector() {
        this.nElementos = 10;
        this.vector = new double[this.nElementos];
    }
    
    public CVector(int ne) {
        if (ne < 1) {
            System.out.println("N\ufffd de elementos no v\ufffdlido: " + ne);
            System.out.println("Se asignan 10 elementos");
            ne = 10;
        }
        this.nElementos = ne;
        this.vector = new double[this.nElementos];
    }
    
    public CVector(final double[] m) {
        this.nElementos = m.length;
        this.vector = new double[this.nElementos];
        for (int i = 0; i < this.nElementos; ++i) {
            this.vector[i] = m[i];
        }
    }
    
    public CVector(final CVector v) {
        this.nElementos = v.nElementos;
        this.vector = new double[this.nElementos];
        for (int i = 0; i < this.nElementos; ++i) {
            this.vector[i] = v.vector[i];
        }
    }
    
    public CVector copiar(final CVector v) {
        this.nElementos = v.nElementos;
        this.vector = new double[this.nElementos];
        for (int i = 0; i < this.nElementos; ++i) {
            this.vector[i] = v.vector[i];
        }
        return this;
    }
    
    public void ponerValorEn(final int i, final double valor) {
        if (i >= 0 && i < this.nElementos) {
            this.vector[i] = valor;
        }
        else {
            System.out.println("\ufffdndice fuera de l\ufffdmites");
        }
    }
    
    public double valorEn(final int i) {
        if (i >= 0 && i < this.nElementos) {
            return this.vector[i];
        }
        System.out.println("\ufffdndice fuera de l\ufffdmites");
        return Double.NaN;
    }
    
    public int longitud() {
        return this.nElementos;
    }
    
    public boolean equals(final CVector v) {
        return Arrays.equals(this.vector, v.vector);
    }
}
