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
        if (e.getSource() == calculadora.getCaja()) {
            int j = 0;
            for (int i = 20; i < calculadora.getEtq1_30().length; i++) {
                while (j < 10) {
                    calculadora.getEtq1_30()[i].setText(j * (Integer) calculadora.getCaja().getSelectedItem() + "");
                    j++;
                    break;
                }
            }
        } else if (e.getSource() == calculadora.getSumar() || e.getSource() == calculadora.getTxt2()) {
            double n1 = Double.parseDouble(calculadora.getTxt1().getText());
            double n2 = Double.parseDouble(calculadora.getTxt2().getText());
            double suma = n1 + n2;
            calculadora.getTxt3().setText(suma + "");
        } 
    }     
}