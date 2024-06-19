// 
// Decompiled by Procyon v0.5.36
// 

package misClases.teoria;

import java.io.Serializable;

public class CListaTfnos7 implements Serializable
{
    private static final long serialVersionUID = 1L;
    private CPersona[] listaTelefonos;
    private int nElementos;
    
    public CListaTfnos7() {
        this.nElementos = 0;
        this.listaTelefonos = new CPersona[this.nElementos];
    }
    
    private void unElementoMas(final CPersona[] listaActual) {
        this.nElementos = listaActual.length;
        this.listaTelefonos = new CPersona[this.nElementos + 1];
        for (int i = 0; i < this.nElementos; ++i) {
            this.listaTelefonos[i] = listaActual[i];
        }
        ++this.nElementos;
    }
    
    private void unElementoMenos(final CPersona[] listaActual) {
        if (listaActual.length == 0) {
            return;
        }
        int k = 0;
        this.nElementos = listaActual.length;
        this.listaTelefonos = new CPersona[this.nElementos - 1];
        for (int i = 0; i < this.nElementos; ++i) {
            if (listaActual[i] != null) {
                this.listaTelefonos[k++] = listaActual[i];
            }
        }
        --this.nElementos;
    }
    
    public void ponerValorEn(final int i, final CPersona objeto) {
        if (i >= 0 && i < this.nElementos) {
            this.listaTelefonos[i] = objeto;
        }
        else {
            System.out.println("\ufffdndice fuera de l\ufffdmites");
        }
    }
    
    public CPersona valorEn(final int i) {
        if (i >= 0 && i < this.nElementos) {
            return this.listaTelefonos[i];
        }
        System.out.println("\ufffdndice fuera de l\ufffdmites");
        return null;
    }
    
    public int longitud() {
        return this.nElementos;
    }
    
    public void anhadir(final CPersona obj) {
        this.unElementoMas(this.listaTelefonos);
        this.ponerValorEn(this.nElementos - 1, obj);
    }
    
    public boolean eliminar(final long tel) {
        for (int i = 0; i < this.nElementos; ++i) {
            if (this.listaTelefonos[i].obtenerTelefono() == tel) {
                this.listaTelefonos[i] = null;
                this.unElementoMenos(this.listaTelefonos);
                return true;
            }
        }
        return false;
    }
    
    public int buscar(final String str, int pos) {
        if (str == null) {
            return -1;
        }
        if (pos < 0) {
            pos = 0;
        }
        for (int i = pos; i < this.nElementos; ++i) {
            final String nom = this.listaTelefonos[i].obtenerNombre();
            if (nom != null) {
                if (nom.indexOf(str) > -1) {
                    return i;
                }
            }
        }
        return -1;
    }
    
    public void mostrarListaTfnos() {
        if (this.nElementos > 0) {
            for (int i = 0; i < this.nElementos; ++i) {
                this.listaTelefonos[i].mostrar();
            }
        }
        else {
            System.out.println("\ufffdndice fuera de l\ufffdmites");
        }
    }
}
