package Practica_05_B;

import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConversionApp implements ActionListener{

    ConversionLayout conversion;
    Operaciones operaciones = new Operaciones();
    
    public ConversionApp(){
        conversion = new ConversionLayout();
    }
    
    public ConversionApp(ConversionLayout conversion){
        this.conversion = conversion;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //Analizamos el estado del primer cuadro de texto
        if (conversion.texto1.getText().compareTo(conversion.txt1Ant) != 0) {
            //Pasamos el valor del texto a float, realizamos la operacion y lo devolvemos al texto en String
            float respuestaFloat1 = Float.parseFloat(conversion.texto1.getText());
            System.out.println(respuestaFloat1);
            operaciones.setGradosC(respuestaFloat1);
            conversion.texto2.setText(String.valueOf(operaciones.gradosToFarenheit()));

        //Analizamos el estado del segundo cuadro de texto
        } else if (conversion.texto2.getText().compareTo(conversion.txt2Ant) != 0) {
            //Pasamos el valor del texto a float, realizamos la operacion y lo devolvemos al texto en String
            float respuestaFloat2 = Float.parseFloat(conversion.texto2.getText());
            operaciones.setGradosF(respuestaFloat2);
            conversion.texto1.setText(String.valueOf(operaciones.FarenheitToGrados()));
        } else {
            JOptionPane.showMessageDialog(null,"Que haces mongolín, pon bien los datos");
        }
        conversion.txt1Ant = conversion.texto1.getText();
        conversion.txt2Ant = conversion.texto2.getText();    
    }

    public static void main (String [] args) {
        
        ConversionLayout conversion = new ConversionLayout();
        conversion.setVisible(true);

    }




}
