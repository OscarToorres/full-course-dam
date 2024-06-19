package practicas1_4;

import java.io.IOException;
import misClases.avaliacion1.CTecla;

class practica4
{
    public static void main(final String[] ar) throws IOException {
        final CTecla tecla = new CTecla();
        tecla.recogeDixito();
        tecla.recogeVocalMinus();
        tecla.recogeVocalMaius();
        tecla.recogeConsonanteMinus();
        tecla.recogeConsonanteMaius();
        tecla.amosaResultado();
    }
}