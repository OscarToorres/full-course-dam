// 
// Decompiled by Procyon v0.5.36
// 

package misClases.teoria;

public class CMiClase
{
    public void muestra(final int a) throws EValorNoValido {
        if (a % 2 == 0) {
            throw new EValorNoValido("ERROR: valor (" + a + ")");
        }
        System.out.println(a);
    }
}
