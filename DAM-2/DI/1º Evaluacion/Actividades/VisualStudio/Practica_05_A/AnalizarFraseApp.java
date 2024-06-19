import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class AnalizarFraseApp implements ActionListener{

    AnalizarFraseLayout fraseLayout;
    AnalizarFrase analizar = new AnalizarFrase();

    //Constructores
    
    public AnalizarFraseApp(){
        fraseLayout = new AnalizarFraseLayout();
    }
    
    public AnalizarFraseApp(AnalizarFraseLayout fraseLayout){
        this.fraseLayout = fraseLayout;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == fraseLayout.boton) {
            //Contar letras
            int numLetras = analizar.contarLetras(fraseLayout.texto1.getText());
            fraseLayout.texto2.setText(String.valueOf(numLetras));
            //Contar palabras
            int numPalabras = analizar.contarPalabras(fraseLayout.texto1.getText());
            fraseLayout.texto3.setText(String.valueOf(numPalabras));
        }
    }

    public static void main (String [] args) {
        AnalizarFraseLayout fraseLayout = new AnalizarFraseLayout();
        fraseLayout.setVisible(true); 
    }
    
}