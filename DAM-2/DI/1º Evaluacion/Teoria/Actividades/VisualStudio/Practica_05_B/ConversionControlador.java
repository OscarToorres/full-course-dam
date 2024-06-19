package Practica_05_B;

import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConversionControlador implements ActionListener{

    ConversionLayout conversion;
    Operaciones operaciones = new Operaciones();
    
    public ConversionControlador(){
        conversion = new ConversionLayout();
    }
    
    public ConversionControlador(ConversionLayout conversion){
        this.conversion = conversion;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //Analizamos el estado del primer cuadro de texto
        if (conversion.getTexto1().getText().compareTo(conversion.getTxt1Ant()) != 0) {
            //Pasamos el valor del texto a float, realizamos la operacion y lo devolvemos al texto en String
            float respuestaFloat1 = Float.parseFloat(conversion.getTexto1().getText());
            System.out.println(respuestaFloat1);
            operaciones.setGradosC(respuestaFloat1);
            conversion.getTexto2().setText(String.valueOf(operaciones.gradosToFarenheit()));

        //Analizamos el estado del segundo cuadro de texto
        } else if (conversion.getTexto2().getText().compareTo(conversion.getTxt2Ant()) != 0) {
            //Pasamos el valor del texto a float, realizamos la operacion y lo devolvemos al texto en String
            float respuestaFloat2 = Float.parseFloat(conversion.getTexto2().getText());
            operaciones.setGradosF(respuestaFloat2);
            conversion.getTexto1().setText(String.valueOf(operaciones.FarenheitToGrados()));
        } else {
            JOptionPane.showMessageDialog(null,"Que haces mongolín, pon bien los datos");
        }
        conversion.setTxt1Ant(conversion.getTexto1().getText());
        conversion.setTxt2Ant(conversion.getTexto2().getText());    
    }
}