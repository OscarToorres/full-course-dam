package misClases.teoria;

public class CCuentaAhorro extends CCuenta
{
    private double cuotaMantenimiento;
    
    public CCuentaAhorro() {
        System.out.println("--->Constructor CCuentaAhorro SIN parametros de " + this.obtenerNombre());
    }
    
    public CCuentaAhorro(final String nom, final String cue, final double sal, final double tipo, final double mant) {
        super(nom, cue, sal, tipo);
        this.asignarCuotaManten(mant);
        System.out.println("--->Constructor CCuentaAhorro CON parametros de " + this.obtenerNombre());
    }
    
    @Override
    public void mostrar() {
        super.mostrar();
        System.out.print("Mantenimiento..........: ");
        System.out.println(this.cuotaMantenimiento);
    }
    
    public void asignarCuotaManten(final double cantidad) {
        if (cantidad < 0.0) {
            System.out.println("Error: cantidad negativa");
            return;
        }
        this.cuotaMantenimiento = cantidad;
    }
    
    public double obtenerCuotaManten() {
        return this.cuotaMantenimiento;
    }
    
    @Override
    public void comisiones() throws ESaldoInsuficiente {
        if (this.dia() == 1) {
            this.reintegro(this.cuotaMantenimiento);
        }
    }
    
    @Override
    public double intereses() {
        if (this.dia() != 1) {
            return 0.0;
        }
        double interesesProducidos = 0.0;
        interesesProducidos = this.estado() * this.obtenerTipoDeInteres() / 1200.0;
        this.ingreso(interesesProducidos);
        return interesesProducidos;
    }
    
    @Override
    protected void finalize() throws Throwable {
        System.out.println("--->Destructor CCuentaAhorro de " + this.obtenerNombre());
        super.finalize();
    }
}