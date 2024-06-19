// 
// Decompiled by Procyon v0.5.36
// 

package misClases.teoria;

import java.io.IOException;
import java.io.File;
import java.io.RandomAccessFile;

public class CListaTfnos8
{
    private RandomAccessFile fes;
    private int nregs;
    private int tamanhoReg;
    
    public CListaTfnos8(final File fichero) throws IOException {
        this.tamanhoReg = 140;
        if (fichero.exists() && !fichero.isFile()) {
            throw new IOException(String.valueOf(fichero.getName()) + " no es un fichero");
        }
        this.fes = new RandomAccessFile(fichero, "rw");
        this.nregs = (int)Math.ceil(this.fes.length() / (double)this.tamanhoReg);
    }
    
    public void cerrar() throws IOException {
        this.fes.close();
    }
    
    public int longitud() {
        return this.nregs;
    }
    
    public boolean ponerValorEn(final int i, final CPersona objeto) throws IOException {
        if (i >= 0 && i <= this.nregs) {
            if (objeto.tamanho() + 4 <= this.tamanhoReg) {
                this.fes.seek(i * this.tamanhoReg);
                this.fes.writeUTF(objeto.obtenerNombre());
                this.fes.writeUTF(objeto.obtenerDireccion());
                this.fes.writeLong(objeto.obtenerTelefono());
                return true;
            }
            System.err.println("tama\ufffdo del registro excedido");
        }
        else {
            System.err.println("n\ufffdmero de registro fuera de l\ufffdmites");
        }
        return false;
    }
    
    public CPersona valorEn(final int i) throws IOException {
        if (i >= 0 && i < this.nregs) {
            this.fes.seek(i * this.tamanhoReg);
            final String nombre = this.fes.readUTF();
            final String direccion = this.fes.readUTF();
            final long telefono = this.fes.readLong();
            return new CPersona(nombre, direccion, telefono);
        }
        System.out.println("n\ufffdmero de registro fuera de l\ufffdmites");
        return null;
    }
    
    public void anhadir(final CPersona obj) throws IOException {
        if (this.ponerValorEn(this.nregs, obj)) {
            ++this.nregs;
        }
    }
    
    public boolean eliminar(final long tel) throws IOException {
        for (int reg_i = 0; reg_i < this.nregs; ++reg_i) {
            final CPersona obj = this.valorEn(reg_i);
            if (obj.obtenerTelefono() == tel) {
                obj.asignarTelefono(0L);
                this.ponerValorEn(reg_i, obj);
                return true;
            }
        }
        return false;
    }
    
    public int buscar(final String str, int pos) throws IOException {
        if (str == null) {
            return -1;
        }
        if (pos < 0) {
            pos = 0;
        }
        for (int reg_i = pos; reg_i < this.nregs; ++reg_i) {
            final CPersona obj = this.valorEn(reg_i);
            final String nom = obj.obtenerNombre();
            if (nom.indexOf(str) > -1) {
                return reg_i;
            }
        }
        return -1;
    }
    
    public void mostrarListaTfnos() throws IOException {
        if (this.nregs >= 0) {
            for (int i = 0; i < this.nregs; ++i) {
                final CPersona obj = this.valorEn(i);
                obj.mostrar();
            }
        }
        else {
            System.out.println("Indice fuera de limites");
        }
    }
}
