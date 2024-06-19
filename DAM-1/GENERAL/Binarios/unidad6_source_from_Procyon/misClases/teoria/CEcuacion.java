// 
// Decompiled by Procyon v0.5.36
// 

package misClases.teoria;

public class CEcuacion
{
    private double a;
    private double b;
    private double c;
    private double d;
    
    public void recogeDatos() {
        System.out.print("Coeficiente a: ");
        this.a = Leer.datoDouble();
        System.out.print("Coeficiente b: ");
        this.b = Leer.datoDouble();
        System.out.print("Coeficiente c: ");
        this.c = Leer.datoDouble();
    }
    
    public boolean raicesComplejas() {
        boolean complejas = false;
        this.d = this.b * this.b - 4.0 * this.a * this.c;
        if (this.d < 0.0) {
            complejas = true;
        }
        return complejas;
    }
    
    public void muestraResultado() {
        System.out.println("Las ra\ufffdces reales son:");
        this.d = Math.sqrt(this.d);
        final double x1 = (-this.b + this.d) / (2.0 * this.a);
        final double x2 = (-this.b - this.d) / (2.0 * this.a);
        System.out.println("x1 = " + x1 + ", x2 = " + x2);
    }
}
