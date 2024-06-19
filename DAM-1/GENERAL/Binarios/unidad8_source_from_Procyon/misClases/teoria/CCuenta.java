// 
// Decompiled by Procyon v0.5.36
// 

package misClases.teoria;

import java.util.GregorianCalendar;

public abstract class CCuenta implements IFecha
{
    private String nombre;
    private String cuenta;
    private double saldo;
    private double tipoDeInteres;
    
    public CCuenta() {
        System.out.println("--->Constructor CCuenta SIN parametros de " + this.nombre);
    }
    
    public CCuenta(final String nom, final String cue, final double sal, final double tipo) {
        this.asignarNombre(nom);
        this.asignarCuenta(cue);
        this.ingreso(sal);
        this.asignarTipoDeInteres(tipo);
        System.out.println("--->Constructor CCuenta CON parametros de " + this.nombre);
    }
    
    public void mostrar() {
        System.out.println();
        System.out.print("Nombre.................: ");
        System.out.println(this.nombre);
        System.out.print("Cuenta.................: ");
        System.out.println(this.cuenta);
        System.out.print("Saldo..................: ");
        System.out.println(this.saldo);
        System.out.print("Tipo de inter\u00e9s........: ");
        System.out.println(this.tipoDeInteres);
    }
    
    public void asignarNombre(final String nom) {
        if (nom.length() == 0) {
            System.out.println("Error: cadena vac\u00eda");
            return;
        }
        this.nombre = nom;
    }
    
    public String obtenerNombre() {
        return this.nombre;
    }
    
    public void asignarCuenta(final String cue) {
        if (cue.length() == 0) {
            System.out.println("Error: cuenta no v\u00e1lida");
            return;
        }
        this.cuenta = cue;
    }
    
    public String obtenerCuenta() {
        return this.cuenta;
    }
    
    public double estado() {
        return this.saldo;
    }
    
    public abstract void comisiones() throws ESaldoInsuficiente;
    
    public abstract double intereses();
    
    public void ingreso(final double cantidad) {
        if (cantidad < 0.0) {
            System.out.println("Error: cantidad negativa");
            return;
        }
        this.saldo += cantidad;
    }
    
    public void reintegro(final double cantidad) throws ESaldoInsuficiente {
        if (this.saldo - cantidad < 0.0) {
            throw new ESaldoInsuficiente(this, cantidad);
        }
        this.saldo -= cantidad;
    }
    
    public void asignarTipoDeInteres(final double tipo) {
        if (tipo < 0.0) {
            System.out.println("Error: tipo no v\ufffdlido");
            return;
        }
        this.tipoDeInteres = tipo;
    }
    
    public double obtenerTipoDeInteres() {
        return this.tipoDeInteres;
    }
    
    @Override
    protected void finalize() throws Throwable {
        System.out.println("--->Destructor CCuenta de " + this.nombre);
        super.finalize();
    }
    
    @Override
    public int dia() {
        final GregorianCalendar fechaActual = new GregorianCalendar();
        return fechaActual.get(5);
    }
    
    @Override
    public int mes() {
        return 0;
    }
    
    @Override
    public int anho() {
        return 0;
    }
}
