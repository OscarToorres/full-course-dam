package Practica08_SecuenciaYDesarrollo;

import java.applet.*;
import java.awt.*;

import javax.swing.JFrame;

public class Ventana extends JFrame {

    Ventana(int x, int y, int dx, int dy) {
        super("Hola");
        Label lbl = new Label("Window", Label.CENTER);
        lbl.setBackground(Color.cyan);
        add("Center", lbl);
        setSize(dx, dy);
        setLocation(x, y);
        setVisible(true);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        Ventana ventana = new Ventana( 10, 10, 500, 400);
    }
}
