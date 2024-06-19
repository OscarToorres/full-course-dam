package misClases.teoria;

public class CCuentaCorriente extends CCuenta
{
    private int transacciones;
    private double importePorTrans;
    private int transExentas;
    
    public CCuentaCorriente() {
        System.out.println("--->Constructor CCuentaCorriente SIN parametros de " + this.obtenerNombre());
    }
    
    public CCuentaCorriente(final String nom, final String cue, final double sal, final double tipo, final double imptrans, final int transex) {
        super(nom, cue, sal, tipo);
        this.transacciones = 0;
        this.asignarImportePorTrans(imptrans);
        this.asignarTransExentas(transex);
        System.out.println("--->Constructor CCuentaCorriente CON parametros de " + this.obtenerNombre());
    }
    
    @Override
    public void mostrar() {
        super.mostrar();
        System.out.print("Importe por transacci\u00f3n: ");
        System.out.println(this.importePorTrans);
        System.out.print("Transacciones exentas..: ");
        System.out.println(this.transExentas);
    }
    
    public void decrementarTransacciones() {
        --this.transacciones;
    }
    
    public void asignarImportePorTrans(final double imptrans) {
        if (imptrans < 0.0) {
            System.out.println("Error: cantidad negativa");
            return;
        }
        this.importePorTrans = imptrans;
    }
    
    public double obtenerImportePorTrans() {
        return this.importePorTrans;
    }
    
    public void asignarTransExentas(final int transex) {
        if (transex < 0) {
            System.out.println("Error: cantidad negativa");
            return;
        }
        this.transExentas = transex;
    }
    
    public int obtenerTransExentas() {
        return this.transExentas;
    }
    
    @Override
    public void ingreso(final double cantidad) {
        super.ingreso(cantidad);
        ++this.transacciones;
    }
    
    @Override
    public void reintegro(final double cantidad) throws ESaldoInsuficiente {
        super.reintegro(cantidad);
        ++this.transacciones;
    }
    
    @Override
    public void comisiones() throws ESaldoInsuficiente {
        if (this.dia() == 1) {
            final int n = this.transacciones - this.transExentas;
            if (n > 0) {
                this.reintegro(n * this.importePorTrans);
            }
            this.transacciones = 0;
        }
    }
    
    @Override
    public double intereses() {
        if (this.dia() != 1) {
            return 0.0;
        }
        double interesesProducidos = 0.0;
        if (this.estado() <= 3000.0) {
            interesesProducidos = this.estado() * 0.5 / 1200.0;
        }
        else {
            interesesProducidos = 1.25 + (this.estado() - 3000.0) * this.obtenerTipoDeInteres() / 1200.0;
        }
        this.ingreso(interesesProducidos);
        this.decrementarTransacciones();
        return interesesProducidos;
    }
}