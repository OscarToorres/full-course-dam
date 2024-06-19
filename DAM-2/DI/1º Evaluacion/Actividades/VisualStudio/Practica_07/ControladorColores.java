package Practica_07;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.JTextField;
import java.awt.event.FocusEvent;

import java.awt.*;
import java.awt.event.FocusListener;

public class ControladorColores {

    //MANEJADOR DE EVENTOS

    public void ventExec() {
        DiseñoColores diseño = new DiseñoColores();
        JButton[] botonColor = diseño.colores;
        JScrollBar[] scrollBar = diseño.barra;
        JTextField[] cajasTexto = diseño.getRgbNumero();
        

        for(int i = 0; i < botonColor.length; i++) {
            JButton boton = botonColor[i];
            boton.addActionListener(listener -> {
                diseño.panelCentro.setBackground(boton.getBackground());
                Color colorFondo = diseño.panelCentro.getBackground();
                diseño.getRgbNumero()[0].setText(String.valueOf(colorFondo.getRed()));
                diseño.getRgbNumero()[1].setText(String.valueOf(colorFondo.getGreen()));
                diseño.getRgbNumero()[2].setText(String.valueOf(colorFondo.getBlue()));
                diseño.barra[0].setValue(colorFondo.getRed());
                diseño.barra[1].setValue(colorFondo.getGreen());
                diseño.barra[2].setValue(colorFondo.getBlue());
            });
        }
        
        for (int i = 0; i < cajasTexto.length; i++) {
            JTextField rgbTxt = diseño.getRgbNumero()[i];
            rgbTxt.addFocusListener(new FocusListener() {
                public void focusGained(FocusEvent e) {
                    
                }
                public void focusLost(FocusEvent e) {
                    try {
                        String numero = rgbTxt.getText();
                        Integer enteroFiltrado = diseño.filtrarTexto(numero);
                        rgbTxt.setText(enteroFiltrado.toString());

                        System.out.println("Valor en el evento " + rgbTxt.getText());
                        if (!diseño.estado[0].equals(diseño.getRgbNumero()[0].getText()) && !diseño.estado[1].equals(diseño.getRgbNumero()[1].getText()) 
                        && !diseño.estado[2].equals(diseño.getRgbNumero()[2].getText()) ) {
                            Color colorTexto = new Color(Integer.parseInt(diseño.getRgbNumero()[0].getText()),Integer.parseInt(diseño.getRgbNumero()[1].getText()),Integer.parseInt(diseño.getRgbNumero()[2].getText()));
                            diseño.panelCentro.setBackground(colorTexto);
                            diseño.barra[0].setValue(colorTexto.getRed());
                            diseño.barra[1].setValue(colorTexto.getGreen());
                            diseño.barra[2].setValue(colorTexto.getBlue());
                            diseño.estado[0] = diseño.getRgbNumero()[0].getText();
                            diseño.estado[1] = diseño.getRgbNumero()[1].getText();
                            diseño.estado[2] = diseño.getRgbNumero()[2].getText();
                        }

                    }catch(NumberFormatException ex){
                        System.out.println("Entra por el catch");
                        JOptionPane.showMessageDialog(rgbTxt, "Esto no es un numero entre 1 y 255");
                    }
                }

                });
                
            }

            for(int i = 0; i < scrollBar.length; i++) {
                JScrollBar boton = scrollBar[i];
                boton.addAdjustmentListener(listener -> {
                        Color colorBarra = new Color(diseño.barra[0].getValue(), diseño.barra[1].getValue(), diseño.barra[2].getValue());
                        diseño.panelCentro.setBackground(colorBarra); 
                        diseño.getRgbNumero()[0].setText(String.valueOf(colorBarra.getRed()));
                        diseño.getRgbNumero()[1].setText(String.valueOf(colorBarra.getGreen()));
                        diseño.getRgbNumero()[2].setText(String.valueOf(colorBarra.getBlue()));                  
                });
            }    
        }

        //MAIN
        public static void main (String [] args) {
        ControladorColores cc = new ControladorColores();
        cc.ventExec();
    }
    
}
