package misClases.avaliacion3;

import practicas.practi02.Leer;

public class CTiendaFruta {

	private CFruta[] fruta;
	private int total;

	public CTiendaFruta() {
		this.fruta = new CFruta[5];
        this.total = 0;
	}

	public void llenar() {
		this.fruta[0] = new CFruta("F01", "Aguacates", 52, 3.25f);
		this.fruta[1] = new CFruta("F02", "Zanahorias", 34, 5.45f);
		this.fruta[2] = new CFruta("F03", "Platanos", 57, 4.75f);
		this.fruta[3] = new CFruta("F04", "Manzanas", 47, 2.85f);
		this.fruta[4] = new CFruta("F05", "Mandarinas", 61, 3.55f);
        this.total = 5;

	}
	
    public void mostrar() {
        if (this.total == 0) {
            System.out.println("Juzgado VACIO");
        }
        else {
            this.mostrarCabecera();
            for (int i = 0; i < this.total; ++i) {
                this.fruta[i].mostrar();
            }
        }
    }
    
    private void mostrarCabecera() {
        System.out.println("IDENTIFICADOR\tTITULO  \tARANCEL");
        System.out.println("=============\t======  \t=======");
    }
	
    public void vaciar() {
        this.total = 0;
    }
    
    private void menu() {
        System.out.println("\n  M E N U");
        System.out.println("  ===================");
        System.out.println("1.- LLENAR tienda");
        System.out.println("2.- VACIAR tienda");
        System.out.println("3.- MOSTRAR tienda");
        System.out.println("4.- MOSTRAR fruta");
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