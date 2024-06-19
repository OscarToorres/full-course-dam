package practicas.practi02;

public class CJuzgado
{
    private CProceso[] juzgado;
    private int total;
    
    public CJuzgado() {
        this.juzgado = new CProceso[5];
        this.total = 0;
    }
    
    public void llenar() {
        this.juzgado[0] = new CProceso("P101", "Empresa ARA", 1230.5f);
        this.juzgado[1] = new CProceso("P102", "Punto limpio", 2245.75f);
        this.juzgado[2] = new CProceso("P103", "Divorcio Pedro", 538.25f);
        this.juzgado[3] = new CProceso("P104", "Concesionario", 3429.5f);
        this.juzgado[4] = new CProceso("P105", "Alquiler piso", 826.25f);
        this.total = 5;
    }
    
    public void vaciar() {
        this.total = 0;
    }
    
    private CProceso nuevoProceso() {
        System.out.print("Identificador: ");
        final String identificador = Leer.datoString();
        System.out.print("Titulo: ");
        final String titulo = Leer.datoString();
        System.out.print("Arancel: ");
        final float arancel = Leer.datoFloat();
        return new CProceso(identificador, titulo, arancel);
    }
    
    public void insertarProceso() {
        this.juzgado[this.total] = this.nuevoProceso();
        ++this.total;
        System.out.println("Proceso INSERTADO");
    }
    
    private int dameIndice(final String ide) {
        for (int i = 0; i < this.total; ++i) {
            if (ide.equals(this.juzgado[i].getIdentificador())) {
                return i;
            }
        }
        return -1;
    }
    
    private void modifica(final int i) {
        this.mostrarCabecera();
        this.juzgado[i].mostrar();
        System.out.print("NUEVO identificador: ");
        this.juzgado[i].setIdentificador(Leer.datoString());
        System.out.print("NUEVO titulo: ");
        this.juzgado[i].setTitulo(Leer.datoString());
        System.out.print("NUEVO arancel: ");
        this.juzgado[i].setArancel(Leer.datoFloat());
    }
    
    public void modificarProceso(final String ide) {
        final int indice = this.dameIndice(ide);
        if (indice == -1) {
            System.out.println("Proceso no ENCONTRADO");
        }
        else {
            this.modifica(indice);
            System.out.println("Proceso MODIFICADO");
        }
    }
    
    private void elimina(int i) {
        while (i < this.total - 1) {
            this.juzgado[i] = this.juzgado[i + 1];
            ++i;
        }
        --this.total;
    }
    
    public void eliminarProceso(final String ide) {
        final int indice = this.dameIndice(ide);
        if (indice == -1) {
            System.out.println("Proceso no ENCONTRADO");
        }
        else {
            this.elimina(indice);
            System.out.println("Proceso ELIMINADO");
        }
    }
    
    public void mostrar() {
        if (this.total == 0) {
            System.out.println("Juzgado VACIO");
        }
        else {
            this.mostrarCabecera();
            for (int i = 0; i < this.total; ++i) {
                this.juzgado[i].mostrar();
            }
        }
    }
    
    private void mostrarCabecera() {
        System.out.println("IDENTIFICADOR\tTITULO  \tARANCEL");
        System.out.println("=============\t======  \t=======");
    }
    
    private void menu() {
        System.out.println("\n  M E N U - Pr\u00e1tica 2");
        System.out.println("  ===================");
        System.out.println("1.- LLENAR Juzgado");
        System.out.println("2.- VACIAR Juzgado");
        System.out.println("3.- MOSTRAR Juzgado");
        System.out.println("4.- INSERTAR Proceso");
        System.out.println("5.- MODIFICAR Proceso");
        System.out.println("6.- ELIMINAR Proceso");
        System.out.println("7.- FINAL");
        System.out.print("Pulsa opci\u00f3n: ");
    }
    
    public int dameOpcion() {
        this.menu();
        final int opcion = Leer.datoInt();
        System.out.println();
        return opcion;
    }
}