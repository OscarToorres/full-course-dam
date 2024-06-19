package Practica_05_B;

public class Operaciones {
    
    private float gradosC = 0;
    private float gradosF = 0;
    
    public Operaciones(float gradosC, float gradosF) {
        this.gradosC = gradosC;
        this.gradosF = gradosF;
    }

    public Operaciones() {
    }

    public float gradosToFarenheit() {
        return (this.gradosC * 9 / 5) + 32 ;
    }

    public float FarenheitToGrados() {
        return (this.gradosF - 32) * 5 / 9;
    }

    public float getGradosC() {
        return gradosC;
    }

    public void setGradosC(float gradosC) {
        this.gradosC = gradosC;
    }

    public float getGradosF() {
        return gradosF;
    }

    public void setGradosF(float gradosF) {
        this.gradosF = gradosF;
    }
    
    


}
