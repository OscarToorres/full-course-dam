package misClases.teoria;

import java.util.GregorianCalendar;

public class CFecha
{
    private int dia;
    private int mes;
    private int anio;
    
    public CFecha() {
        this.asignarFecha();
    }
    
    public CFecha(final int dd) {
        this();
        this.dia = dd;
        if (!this.fechaCorrecta()) {
            System.out.println("Fecha incorrecta. Se asigna la actual.");
            this.asignarFecha();
        }
    }
    
    public CFecha(final int dd, final int mm) {
        this.asignarFecha();
        this.dia = dd;
        this.mes = mm;
        if (!this.fechaCorrecta()) {
            System.out.println("Fecha incorrecta. Se asigna la actual.");
            this.asignarFecha();
        }
    }
    
    public CFecha(final int dd, final int mm, final int aaaa) {
        this.dia = dd;
        this.mes = mm;
        this.anio = aaaa;
        if (!this.fechaCorrecta()) {
            System.out.println("Fecha incorrecta. Se asigna la actual.");
            this.asignarFecha();
        }
    }
    
    public CFecha(final CFecha obj) {
        this.dia = obj.dia;
        this.mes = obj.mes;
        this.anio = obj.anio;
    }
    
    @Override
    protected void finalize() throws Throwable {
        System.out.println("Objeto destruido");
    }
    
    protected boolean bisiesto() {
        return (this.anio % 4 == 0 && this.anio % 100 != 0) || this.anio % 400 == 0;
    }
    
    public void asignarFecha() {
        final GregorianCalendar fechaActual = new GregorianCalendar();
        this.dia = fechaActual.get(5);
        this.mes = fechaActual.get(2) + 1;
        this.anio = fechaActual.get(1);
    }
    
    public void asignarFecha(final int dd) {
        this.asignarFecha();
        this.dia = dd;
    }
    
    public void asignarFecha(final int dd, final int mm) {
        this.asignarFecha();
        this.dia = dd;
        this.mes = mm;
    }
    
    public void asignarFecha(final int d, final int mm, final int aaaa) {
        this.dia = d;
        this.mes = mm;
        this.anio = aaaa;
    }
    
    public void obtenerFecha(final int[] fecha) {
        fecha[0] = this.dia;
        fecha[1] = this.mes;
        fecha[2] = this.anio;
    }
    
    public boolean fechaCorrecta() {
        final boolean anioCorrecto = this.anio >= 1582;
        final boolean mesCorrecto = this.mes >= 1 && this.mes <= 12;
        boolean diaCorrecto = false;
        switch (this.mes) {
            case 2: {
                if (this.bisiesto()) {
                    diaCorrecto = (this.dia >= 1 && this.dia <= 29);
                    break;
                }
                diaCorrecto = (this.dia >= 1 && this.dia <= 28);
                break;
            }
            case 4:
            case 6:
            case 9:
            case 11: {
                diaCorrecto = (this.dia >= 1 && this.dia <= 30);
                break;
            }
            default: {
                diaCorrecto = (this.dia >= 1 && this.dia <= 31);
                break;
            }
        }
        return diaCorrecto && mesCorrecto && anioCorrecto;
    }
    
    public CFecha copiar(final CFecha obj) {
        this.dia = obj.dia;
        this.mes = obj.mes;
        this.anio = obj.anio;
        return this;
    }
}
