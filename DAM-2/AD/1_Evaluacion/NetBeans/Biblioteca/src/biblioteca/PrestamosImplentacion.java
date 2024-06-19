package biblioteca;

import java.util.ArrayList;

public class PrestamosImplentacion implements Prestamos {

    public ArrayList<Ejemplar> ejemplares = new ArrayList();
    
    @Override
    public void prestar(int codigo) {
       this.buscarEjemplar(codigo);
    }

    @Override
    public void devolver(int codigo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void usar(int codigo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void consultar(int codigo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void addEjemplar(Ejemplar ejemplar) {
        ejemplares.add(ejemplar);
    }

    public Ejemplar buscarEjemplar(int codigo) {
        for(Ejemplar eje : ejemplares){
           if(eje.getCodigo() == codigo)
               return eje;
        }
        return null;
    }

    @Override
    public void borrarEjemplar() {

    }

    @Override
    public void mostrarLista() {
        for(Ejemplar ejemplar : ejemplares ){
            System.out.println(ejemplar.toString());
        }
    }  
}
