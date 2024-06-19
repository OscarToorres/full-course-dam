import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaBorderTest implements ActionListener {

    VentanaBorder miVentana;

    public VentanaBorderTest(){
        miVentana = new VentanaBorder();
    }

    public VentanaBorderTest(VentanaBorder miVentana){
        this.miVentana = miVentana;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Compara los cuadros de texto y si existen iguales se cambia el mesaje de la etiqueta
        if(e.getSource() == miVentana.boton1) {
            if (miVentana.texto1.getText().equals(miVentana.texto2.getText()) || miVentana.texto2.getText().equals(miVentana.texto3.getText())
            || miVentana.texto3.getText().equals(miVentana.texto4.getText())) {
                miVentana.etiqueta1.setText("Son iguales");
            } else{
                miVentana.etiqueta1.setText("Son distintos");
            }    
        //Cerrar la ventana     
        } else  {
            miVentana.setVisible(false);
        }
    }

    public static void main (String[] args) {
        VentanaBorder miVentana = new VentanaBorder();
        miVentana.setVisible(true);
    }

}
