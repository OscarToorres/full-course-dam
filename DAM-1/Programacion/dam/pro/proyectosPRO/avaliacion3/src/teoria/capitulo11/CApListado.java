package teoria.capitulo11;

import misClases.teoria.EValorNoValido;
import misClases.teoria.CMiClase;

public class CApListado
{
    public static void main(final String[] args) {
        int x = 10;
        final CMiClase obj = new CMiClase();
        while (x >= -10) {
            try {
                obj.muestra(x);
            }
            catch (EValorNoValido e) {
                System.out.println(e.getMessage());
                continue;
            }
            finally {
                --x;
            }
            --x;
        }
    }
}