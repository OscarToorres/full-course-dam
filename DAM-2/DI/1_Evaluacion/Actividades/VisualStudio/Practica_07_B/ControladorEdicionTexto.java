package Practica_07_B;

import java.awt.*;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class ControladorEdicionTexto {

    public void ventExec(){
        LayoutEdicionTexto diseño = new LayoutEdicionTexto();
        diseño.setVisible(true);

        JCheckBox cursiva = diseño.getSeleccion();
        JTextField cajaTxt = diseño.getTxtBox();
        JRadioButton[] Abotones = diseño.getBtnRadio();
        
        cursiva.addActionListener(listener -> {
            if(cursiva.isSelected() == true){
               cajaTxt.setFont(cajaTxt.getFont().deriveFont(2));
            } else {
                cajaTxt.setFont(cajaTxt.getFont().deriveFont(0));
            }
        });

        for (int i = 0; i < Abotones.length; i++){
            JRadioButton radio = Abotones[i];
            radio.addActionListener(listener -> {
                if(diseño.getBtnRadio()[0].isSelected() == true){
                    Font fuente  = cajaTxt.getFont().deriveFont(12f);
                    cajaTxt.setFont(fuente);
                } else if(diseño.getBtnRadio()[1].isSelected() == true){
                    Font fuente  = cajaTxt.getFont().deriveFont(18f);
                    cajaTxt.setFont(fuente);
                } else if(diseño.getBtnRadio()[2].isSelected() == true){
                    Font fuente  = cajaTxt.getFont().deriveFont(24f);
                    cajaTxt.setFont(fuente);
                }
            });
        }   
    }
}
