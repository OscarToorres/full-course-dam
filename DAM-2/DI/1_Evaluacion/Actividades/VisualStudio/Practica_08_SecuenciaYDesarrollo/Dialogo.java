package Practica_08_SecuenciaYDesarrollo;

import java.applet.*;
import java.awt.*;

import javax.swing.JFrame;

public class Dialogo extends Dialog{

    Dialogo(Frame madre,String título,boolean modal,int x,int y,int dx,int dy) {
        super(madre,título,modal);
        Label lbl=new Label("Dialog",Label.CENTER);
        lbl.setBackground(Color.yellow);
        add("Center",lbl);
        setSize(dx,dy);
        setLocation(x,y);
        setVisible(true);
        }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        Dialogo dialogo = new Dialogo(frame, "A ver si funciona el dialogo", true, 100, 100, 400, 400);
    }
}
