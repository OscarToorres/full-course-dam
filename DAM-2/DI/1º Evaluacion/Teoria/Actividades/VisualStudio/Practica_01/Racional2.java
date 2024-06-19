public class Racional2 {

    private int numerador;
    private int denominador;

    public Racional2(int numerador, int denominador) {
        this.numerador = numerador;
        this.denominador = denominador;
    }

    public Racional2() {
        this.numerador = 1;
        this.denominador = 1;
    }
    
    public int getNumerador() {
        return numerador;
    }

    public void setNumerador(int numerador) {
        this.numerador = numerador;
    }

    public int getDenominador() {
        return denominador;
    }

    public void setDenominador(int denominador) {
        this.denominador = denominador;
    }

    public void asignarDatos(int numerador, int denominador) {  
        this.numerador = numerador;
        this.denominador = denominador;
    }

    public String visualizarRacinal() {
        return this.numerador + "/" + this.denominador;
    }

    public String sumarRacional(Racional2 r1, Racional2 r2) {
        return (r1.getNumerador() * r2.getDenominador() + r1.getDenominador() * r2.getNumerador()) + "/" + (r1.getDenominador() * r2.getDenominador());
    }

    public String restarRacional(Racional2 r1, Racional2 r2) {
        return (r1.getNumerador() * r2.getDenominador() - r1.getDenominador() * r2.getNumerador()) + "/" + (r1.getDenominador() * r2.getDenominador());
    }

    public String multiplicarRacional(Racional2 r1, Racional2 r2) {
        return (r1.getNumerador() * r2.getNumerador()) + "/" + (r1.getDenominador() * r2.getDenominador());
    }

    public String dividirRacional(Racional2 r1, Racional2 r2) {
        return (r1.getNumerador() * r2.getDenominador()) + "/" + (r1.getDenominador() * r2.getNumerador());
    }
}