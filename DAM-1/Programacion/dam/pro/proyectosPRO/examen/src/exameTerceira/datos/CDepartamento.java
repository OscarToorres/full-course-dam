package exameTerceira.datos;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

import exameTerceira.utilidades.Leer;

public class CDepartamento {
	
    private RandomAccessFile fes;
    private int nregs;
    private int tamanhoReg;
    private File fichero;
    
    public CDepartamento(final File fich) throws IOException {
        this.fichero = fich;
        if (this.fichero.exists() && !this.fichero.isFile()) {
            throw new IOException(String.valueOf(this.fichero.getName()) + " es un DIRECTORIO");
        }
        this.fes = new RandomAccessFile(this.fichero, "rw");
        this.tamanhoReg = 100;
        this.nregs = (int)Math.ceil(this.fes.length() / (double)this.tamanhoReg);
    }
    
    public void cerrar() throws IOException {
        this.fes.close();
    }
    
    public void insertar(final int i, final CProfesor profesor) throws IOException {
        this.fes.seek(i * this.tamanhoReg);
        this.fes.writeUTF(profesor.getCodigo());
        this.fes.writeUTF(profesor.getNombre());
        this.fes.writeUTF(profesor.getAula());
        this.fes.writeFloat(profesor.getBaremo());
    }
    
    public void llenar() throws IOException {
        this.vaciar();
        this.insertar(0, new CProfesor("P01", "Marta Argueto", "RUA", 8.7f));
        this.insertar(1, new CProfesor("P02", "Lucas Garcia", "SAGRES", 6.2f));
        this.insertar(2, new CProfesor("P03", "Ignacio Arias", "VIONTA", 5.7f));
        this.insertar(3, new CProfesor("P04", "Ana Menendez", "TIXOSA", 7.4f));
        this.insertar(4, new CProfesor("P05", "Mercedes Novoa", "IROITE", 8.9f));
        this.nregs = 5;
    }
    
    public void vaciar() throws IOException {
        this.fes.close();
        if (!this.fichero.delete()) {
            throw new IOException("No se borr\u00f3 el fichero: " + this.fichero.getName());
        }
        this.fes = new RandomAccessFile(this.fichero, "rw");
        this.nregs = 0;
    }
    
    private CProfesor dameDatosProfesor() {
        System.out.print("Dame codigo: ");
        final String codigo = Leer.datoString();
        System.out.print("Dame nombre: ");
        final String nombre = Leer.datoString();
        System.out.print("Dame aula: ");
        final String aula = Leer.datoString();
        System.out.print("Dame baremo: ");
        final float baremo = Leer.datoFloat();
        return new CProfesor(codigo, nombre, aula, baremo);
    }
    
    private CProfesor dameProfesor(final int pos) throws IOException {
        if (pos >= 0 && pos < this.nregs) {
            this.fes.seek(pos * this.tamanhoReg);
            final String codigo = this.fes.readUTF();
            final String nombre = this.fes.readUTF();
            final String aula = this.fes.readUTF();
            final float baremo = this.fes.readFloat();
            return new CProfesor(codigo, nombre, aula, baremo);
        }
        return null;
    }
    
    private int damePosicion(final String cod) throws IOException {
        for (int i = 0; i < this.nregs; ++i) {
            this.fes.seek(i * this.tamanhoReg);
            final String codigo = this.fes.readUTF();
            if (codigo.equals(cod)) {
                return i;
            }
        }
        return -1;
    }
    
    public void eliminarProfesor(final String cod) throws IOException {
        final int posicion = this.damePosicion(cod);
        final CProfesor profesor = this.dameProfesor(posicion);
        if (profesor == null) {
            System.out.println("Profesor no ENCONTRADO");
        }
        else {
            profesor.setBaremo(0.0f);
            this.insertar(posicion, profesor);
            System.out.println("libro ELIMINADO");
        }
    }
    
    public void insertarProfesor() throws IOException {
        final CProfesor profesor = this.dameDatosProfesor();
        this.insertar(this.nregs, profesor);
        ++this.nregs;
    }
    
    public void modificarProfesor(final String cod) throws IOException {
        final int posicion = this.damePosicion(cod);
        CProfesor profesor = this.dameProfesor(posicion);
        if (profesor == null) {
            System.out.println("profesor no ENCONTRADO");
        }
        else {
            this.mostrarCabecera();
            profesor.mostrar();
            profesor = this.dameDatosProfesor();
            this.insertar(posicion, profesor);
            System.out.println("profesor MODIFICADO");
        }
    }
    
    public void actualizar() throws IOException {
        if (this.nregs == 0) {
            System.out.println("Departamento sin profesores");
            return;
        }
        final File ficheroTemp = new File("departamento.tmp");
        final CDepartamento departamentoTemporal = new CDepartamento(ficheroTemp);
        int pos = 0;
        int i = 0;
        while (pos < this.nregs) {
            final CProfesor profesor = this.dameProfesor(pos);
            if (profesor.getBaremo() != 0.0f) {
            	departamentoTemporal.insertar(i, profesor);
                ++i;
            }
            ++pos;
        }
        departamentoTemporal.cerrar();
        this.cerrar();
        this.fichero.delete();
        if (!ficheroTemp.renameTo(this.fichero)) {
            throw new IOException("NO se renombro el fichero: " + ficheroTemp.getName());
        }
        this.fes = new RandomAccessFile(this.fichero, "rw");
        this.nregs = i;
    }
    
    public void mostrarFruta(final String cod) throws IOException {
        final int pos = this.damePosicion(cod);
        final CProfesor fruta = this.dameProfesor(pos);
        if (fruta == null) {
            System.out.println("Profesor no ENCONTRADO");
        }
        else {
            this.mostrarCabecera();
            fruta.mostrar();
        }
    }
    
    public void mostrar() throws IOException {
        if (this.nregs == 0) {
            System.out.println("Departamento sin profesores");
            return;
        }
        this.mostrarCabecera();
        for (int pos = 0; pos < this.nregs; ++pos) {
            final CProfesor fruta = this.dameProfesor(pos);
            fruta.mostrar();
        }
    }
    
    private void mostrarCabecera() {
        System.out.println("CODIGO\t\tNOMBRE  \tAULA\t\tBAREMO");
        System.out.println("======\t\t======  \t====\t\t=====");
    }
    
    private void menu() {
        System.out.println("\n  M E N U - Exame Terceira");
        System.out.println("  ==========================");
        System.out.println("1.- LLENAR Departamento");
        System.out.println("2.- VACIAR Departamento");
        System.out.println("3.- MOSTRAR Departamento");
        System.out.println("4.- MOSTRAR Profesor");
        System.out.println("5.- INSERTAR Profesor");
        System.out.println("6.- MODIFICAR Profesor");
        System.out.println("7.- ELIMINAR Profesor");
        System.out.println("8.- ACTUALIZAR Departamento");
        System.out.println("9.- FINAL");
        System.out.print("Pulsa opcion: ");
    }
    
    public int dameOpcion() {
        this.menu();
        final int opcion = Leer.datoInt();
        System.out.println();
        return opcion;
    }
}