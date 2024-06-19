// 
// Decompiled by Procyon v0.5.36
// 

package misClases.teoria;

public class CIntereses
{
    private double capital;
    private double intereses;
    private float tipo;
    private int dias;
    
    public void recogeDatos() {
        System.out.print("Capital invertido: ");
        this.capital = Leer.datoDouble();
        System.out.print("A un tipo(%) anual del: ");
        this.tipo = Leer.datoFloat();
        System.out.print("Durante cuantos dias: ");
        this.dias = Leer.datoInt();
        this.realizaCalculos();
    }
    
    private void realizaCalculos() {
        this.intereses = this.capital * this.tipo * this.dias / 36000.0;
        this.capital += this.intereses;
    }
    
    public void muestraInformacion() {
        System.out.println("\nIntereses producidos... " + this.intereses);
        System.out.println("Capital acumulado...... " + this.capital);
    }
}
