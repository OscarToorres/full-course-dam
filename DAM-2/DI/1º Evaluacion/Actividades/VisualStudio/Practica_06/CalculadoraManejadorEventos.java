package Practica_06;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculadoraManejadorEventos implements ActionListener {
    
    CalculadoraDiseño calculadora;

    public CalculadoraManejadorEventos() {
        this.calculadora = new CalculadoraDiseño(); 
    }   

    public CalculadoraManejadorEventos(CalculadoraDiseño calculadora) {
        this.calculadora = calculadora;
    }

    @Override
    public void actionPerformed(ActionEvent e) { 
        if (e.getSource() == calculadora.caja) {
            int j = 0;
            for (int i = 20; i < calculadora.etq1_30.length; i++) {
                while (j < 10) {
                    calculadora.etq1_30[i].setText(j * (Integer) calculadora.caja.getSelectedItem() + "");
                    j++;
                    break;
                }
            }
        } else if (e.getSource() == calculadora.sumar || e.getSource() == calculadora.txt2) {
            double n1 = Double.parseDouble(calculadora.txt1.getText());
            double n2 = Double.parseDouble(calculadora.txt2.getText());
            double suma = n1 + n2;
            calculadora.txt3.setText(suma + "");
        } 
    }
    
    public static void main (String [] args) { 
        CalculadoraDiseño diseño = new CalculadoraDiseño();
        diseño.setVisible(true);

    }
        
}