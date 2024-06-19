import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class AnalizarFraseControlador implements ActionListener{

    AnalizarFraseLayout fraseLayout;
    AnalizarFrase analizar = new AnalizarFrase();

    //Constructores
    
    public AnalizarFraseControlador(){
        fraseLayout = new AnalizarFraseLayout();
    }
    
    public AnalizarFraseControlador(AnalizarFraseLayout fraseLayout){
        this.fraseLayout = fraseLayout;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == fraseLayout.getBoton()) {
            //Contar letras
            int numLetras = analizar.contarLetras(fraseLayout.getTexto1().getText());
            fraseLayout.getTexto2().setText(String.valueOf(numLetras));
            //Contar palabras
            int numPalabras = analizar.contarPalabras(fraseLayout.getTexto1().getText());
            fraseLayout.getTexto3().setText(String.valueOf(numPalabras));
        }
    }
}