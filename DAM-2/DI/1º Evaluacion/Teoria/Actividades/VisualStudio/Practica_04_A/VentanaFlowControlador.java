import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaFlowControlador implements ActionListener {

    VentanaFlowLayout miVentana;

    public VentanaFlowControlador(){
        miVentana = new VentanaFlowLayout();
    }

    public VentanaFlowControlador(VentanaFlowLayout miVentana){
        this.miVentana = miVentana;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Compara los cuadros de texto y si existen iguales se cambia el mesaje de la etiqueta
        if(e.getSource() == miVentana.getBoton1()) {
            if (miVentana.getTexto1().getText().equals(miVentana.getTexto2().getText()) || miVentana.getTexto2().getText().equals(miVentana.getTexto3().getText())
            || miVentana.getTexto3().getText().equals(miVentana.getTexto4().getText())) {
                miVentana.getEtiqueta1().setText("Son iguales");
            } else{
                miVentana.getEtiqueta1().setText("Son distintos");
            }    
        //Cerrar la ventana     
        } else  {
            miVentana.setVisible(false);
        }
    }
}