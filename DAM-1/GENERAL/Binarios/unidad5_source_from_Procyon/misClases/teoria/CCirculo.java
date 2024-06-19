// 
// Decompiled by Procyon v0.5.36
// 

package misClases.teoria;

public class CCirculo
{
    private static double pi;
    public static int numCirculos;
    public static double[] seno;
    public static double[] coseno;
    private CPunto centro;
    private double radio;
    
    static {
        CCirculo.pi = 3.141592;
        CCirculo.seno = new double[360];
        CCirculo.coseno = new double[360];
        for (int i = 0; i < 360; ++i) {
            final double s = Math.sin(Math.toRadians(i));
            final double c = Math.cos(Math.toRadians(i));
            CCirculo.seno[i] = Math.rint(s * 1000000.0) / 1000000.0;
            CCirculo.coseno[i] = Math.rint(c * 1000000.0) / 1000000.0;
        }
    }
    
    protected void msgEsNegativo() {
        System.out.println("El radio es negativo. Se convierte a positivo");
    }
    
    public CCirculo() {
        this(100.0, 100.0, 100.0);
    }
    
    public CCirculo(final double cx, final double cy, double r) {
        this.centro = new CPunto(cx, cy);
        if (r < 0.0) {
            this.msgEsNegativo();
            r = -r;
        }
        this.radio = r;
        ++CCirculo.numCirculos;
    }
    
    public double longCircunferencia() {
        return 2.0 * CCirculo.pi * this.radio;
    }
    
    public double CreaCirculo() {
        return CCirculo.pi * this.radio * this.radio;
    }
    
    public static void cambiarPrecisionPiA(final double nuevoValor) {
        if (nuevoValor < 3.14 || nuevoValor > 3.1416) {
            return;
        }
        CCirculo.pi = nuevoValor;
    }
    
    public static double damePi() {
        return CCirculo.pi;
    }
}
