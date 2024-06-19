package misClases.teoria;

public class ESaldoInsuficiente extends Exception
{
    private static final long serialVersionUID = 1L;
    private CCuenta cuenta;
    private double cantidad;
    
    public ESaldoInsuficiente(final CCuenta cuen, final double can) {
        this.cuenta = cuen;
        this.cantidad = can;
    }
    
    public String mensaje() {
        String mensaje = " ERROR: La cuenta " + this.cuenta.obtenerNombre() + " solicito " + this.cantidad;
        mensaje = String.valueOf(mensaje) + " y el saldo disponible es " + this.cuenta.estado() + "\n";
        return mensaje;
    }
}