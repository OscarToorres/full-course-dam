package Practica_09_Eje01;

import javax.swing.*;
import java.awt.*;

public class fraVentanaControlador {

    String eje = "500x300";
    String posicion = "Centro";
    String texto = "Dimensiones y posiciones";

    public fraVentanaControlador() {
        FraVentana ventana = new FraVentana();
        ventana.setVisible(true);

        JButton ArribaIz = ventana.getBtnArribaIzda();
        JButton ArribaDcha = ventana.getBtnArribaDcha();
        JButton AbajoIz = ventana.getBtnAbajoIzda();
        JButton AbajoDcha = ventana.getBtnAbajoDcha();
        JToggleButton btnCentro = ventana.getBtnCentro();

        Dimension dimPantalla = Toolkit.getDefaultToolkit().getScreenSize();

        ArribaIz.addActionListener(listener -> {
            ventana.setLocation(0, 0);
            posicion = "Arriba izquierda";
            ventana.setTitle(texto + " - " + posicion + " - " + eje);
        });

        ArribaDcha.addActionListener(listener -> {
            Dimension dimVentana = ventana.getSize();
            ventana.setLocation(dimPantalla.width - dimVentana.width, 0);
            posicion = "Arriba derecha";
            ventana.setTitle(texto + " - " + posicion + " - " + eje);
        });

        AbajoIz.addActionListener(listener -> {
            Dimension dimVentana = ventana.getSize();
            ventana.setLocation(0, dimPantalla.height - dimVentana.height);
            posicion = "Abajo izquierda";
            ventana.setTitle(texto + " - " + posicion + " - " + eje);
        });

        AbajoDcha.addActionListener(listener -> {
            Dimension dimVentana = ventana.getSize();
            ventana.setLocation(dimPantalla.width - dimVentana.width, dimPantalla.height - dimVentana.height);
            posicion = "Abajo derecha";
            ventana.setTitle(texto + " - " + posicion + " - " + eje);
        });

        btnCentro.addActionListener(listener -> {
            if (btnCentro.isSelected() == true) {
                ventana.setSize(600, 600);
                eje = "600x600";
                ventana.setTitle(texto + " - " + posicion + " - " + eje);
                Dimension dimVentana = ventana.getSize();
                if (posicion.equals("Arriba derecha")) {
                    ventana.setLocation(dimPantalla.width - dimVentana.width, 0);
                } else if (posicion.equals("Abajo izquierda")) {
                    ventana.setLocation(0, dimPantalla.height - dimVentana.height);
                } else if (posicion.equals("Abajo derecha")) {
                    ventana.setLocation(dimPantalla.width - dimVentana.width, dimPantalla.height - dimVentana.height);
                }
            } else {
                ventana.setSize(500, 300);
                eje = "500x300";
                ventana.setTitle(texto + " - " + posicion + " - " + eje);
                Dimension dimVentana = ventana.getSize();
                if (posicion.equals("Arriba derecha")) {
                    ventana.setLocation(dimPantalla.width - dimVentana.width, 0);
                } else if (posicion.equals("Abajo izquierda")) {
                    ventana.setLocation(0, dimPantalla.height - dimVentana.height);
                } else if (posicion.equals("Abajo derecha")) {
                    ventana.setLocation(dimPantalla.width - dimVentana.width, dimPantalla.height - dimVentana.height);
                }
            }
        });
    }
}
