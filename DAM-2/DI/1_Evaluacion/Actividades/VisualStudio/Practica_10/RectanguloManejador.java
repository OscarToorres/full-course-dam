package Practica_10;

import javax.swing.*;
import javax.swing.JTextField;
import javax.swing.text.html.HTMLEditorKit.Parser;

import java.awt.*;

public class RectanguloManejador {

    private RectanguloVentana ventana = new RectanguloVentana();
    Punto p = new Punto();
    int lado = 0;

    public RectanguloManejador() {
        ventana.setVisible(true);

        JButton[] botones = ventana.getBoton();
        JTextField[] textos = ventana.getCajaTexto();
        JComboBox caja = ventana.getCaja();

        for (int i = 0; i < botones.length; i++) {
            System.out.println("Entra en el for");
            JButton boton = botones[i];
            boton.addActionListener(listener -> {

                if (boton.getText().equals("Calcular")) {

                    lado = (int) Math.round(this.calcularLado());

                } else if (boton.getText().equals("Dibujar")) {

                    lado = (int) Math.round(this.calcularLado());

                    Graphics g = ventana.getPanelPunto().getGraphics();                    
                    ventana.getPanelPunto().paintComponent(g, lado);

                } else if (boton.getText().equals("Limpiar")) {

                    this.limpiarVentana();

                }
            });
        }

        caja.addItemListener(listener ->{
            System.out.println("Entra a cambiar el color");
            Color color = (Color) caja.getSelectedItem();
            ventana.getPanelPunto().setBackground(color);
        });
    }

    private Double calcularLado(){

        p.asignarX(Double.parseDouble(ventana.getCajaTexto()[0].getText()));
        p.asignarY(Double.parseDouble(ventana.getCajaTexto()[1].getText()));
        Punto punto2 = new Punto(Double.parseDouble(ventana.getCajaTexto()[2].getText()), Double.parseDouble(ventana.getCajaTexto()[3].getText()));
        ventana.getResultado().setText("Distancia entre puntos: " + (String.valueOf(p.calcularDistancia(punto2))));
        Double lado = p.calcularDistancia(punto2);

        return lado;
    }

    private void limpiarVentana(){
        ventana.getCajaTexto()[0].setText("0");
        ventana.getCajaTexto()[1].setText("0");
        ventana.getCajaTexto()[2].setText("0");
        ventana.getCajaTexto()[3].setText("0");
        ventana.getResultado().setText("Distancia entre puntos: ");
        ventana.getPanelPunto().repaint();
        ventana.getPanelPunto().setBackground(null);

    }
}
