// 
// Decompiled by Procyon v0.5.36
// 

package misClases.teoria;

public class CCuentaCorrienteConIn extends CCuentaCorriente
{
    public CCuentaCorrienteConIn() {
        System.out.println("--->Constructor CCuentaCorrienteConIntereses SIN parametros de " + this.obtenerNombre());
    }
    
    public CCuentaCorrienteConIn(final String nom, final String cue, final double sal, final double tipo, final double imptrans, final int transex) {
        super(nom, cue, sal, tipo, imptrans, transex);
        System.out.println("--->Constructor CCuentaCorrienteConIntereses CON parametros de " + this.obtenerNombre());
    }
    
    @Override
    public double intereses() {
        if (this.dia() != 1 || this.estado() < 3000.0) {
            return 0.0;
        }
        double interesesProducidos = 0.0;
        interesesProducidos = this.estado() * this.obtenerTipoDeInteres() / 1200.0;
        this.ingreso(interesesProducidos);
        this.decrementarTransacciones();
        return interesesProducidos;
    }
}
