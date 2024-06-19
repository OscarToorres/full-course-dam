package Practica_07_B;

import java.awt.*;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class ControladorEdicionTexto {

    public void ventExec(){
        LayoutEdicionTexto diseño = new LayoutEdicionTexto();
        diseño.setVisible(true);

        JCheckBox cursiva = diseño.seleccion;
        JTextField cajaTxt = diseño.txtBox;
        JRadioButton[] Abotones = diseño.btnRadio;
        
        // JRadioButton radioBtn1 = diseño.radio1;
        // JRadioButton radioBtn2 = diseño.radio2;
        // JRadioButton radioBtn3 = diseño.radio3;
        
        cursiva.addActionListener(listener -> {
            if(cursiva.isSelected() == true){
               cajaTxt.setFont(cajaTxt.getFont().deriveFont(2));
            } else {
                cajaTxt.setFont(cajaTxt.getFont().deriveFont(0));
            }
        });

        for (int i = 0; i < Abotones.length; i++){
            System.out.println("Entra al for");
            JRadioButton radio = Abotones[i];
            radio.addActionListener(listener -> {
                if(diseño.btnRadio[0].isSelected() == true){
                    System.out.println("Entra al btn1");
                    Font fuente  = cajaTxt.getFont().deriveFont(12f);
                    cajaTxt.setFont(fuente);
                } else if(diseño.btnRadio[1].isSelected() == true){
                    System.out.println("Entra al btn2");
                    Font fuente  = cajaTxt.getFont().deriveFont(18f);
                    cajaTxt.setFont(fuente);
                } else if(diseño.btnRadio[2].isSelected() == true){
                    System.out.println("Entra al btn3");
                    Font fuente  = cajaTxt.getFont().deriveFont(24f);
                    cajaTxt.setFont(fuente);
                }
            });
        }   
    }

    public static void main(String[] args) {
        ControladorEdicionTexto controlador = new ControladorEdicionTexto();
        controlador.ventExec();
        
    }
    
}
