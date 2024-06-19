package es.leliadoura.ad.eva1parcial1.data;

/**
 *
 * @author marco
 */
public class Direccion {
    private String calle;
    private String localidad;
    private long numero;
    private long codigoPostal;

    public Direccion() {
    }

    public Direccion(String calle, String localidad, long numero, long codigoPostal) {
        this.calle = calle;
        this.localidad = localidad;
        this.numero = numero;
        this.codigoPostal = codigoPostal;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public long getNumero() {
        return numero;
    }

    public void setNumero(long numero) {
        this.numero = numero;
    }

    public long getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(long codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    @Override
    public String toString() {
        return "Direccion{" + "calle=" + calle + ", localidad=" + localidad + ", numero=" + numero + ", codigoPostal=" + codigoPostal + '}';
    }
    
}
