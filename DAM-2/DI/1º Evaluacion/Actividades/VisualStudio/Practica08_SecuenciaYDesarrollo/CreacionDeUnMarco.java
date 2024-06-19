package Practica08_SecuenciaYDesarrollo;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class CreacionDeUnMarco extends Frame implements WindowListener {

    CreacionDeUnMarco(String título, int x, int y, int dx, int dy) {
        super(título);
        setBackground(Color.red);
        Label lbl = new Label("Frame", Label.CENTER);
        setBackground(Color.red);
        add("Center", lbl);
        MenuBar menubar = new MenuBar();
        setMenuBar(menubar);
        Menu menu1 = new Menu("menu1");
        menu1.add(new MenuItem("item 1.1"));
        menu1.add(new MenuItem("item 1.2"));
        menu1.add(new MenuItem("item 1.3"));
        Menu menu2 = new Menu("menu2");
        menu2.add(new MenuItem("item 2.1"));
        menu2.add(new MenuItem("item 2.2"));
        menubar.add(menu1);
        menubar.add(menu2);
        setSize(dx, dy);
        setLocation(x, y);
        setVisible(true);
        addWindowListener(this);
    }

    /*------------ WindowListener ----------*/
    public void windowOpened(WindowEvent e) {
    }

    public void windowActivated(WindowEvent e) {
    }

    public void windowDeactivated(WindowEvent e) {
    }

    public void windowIconified(WindowEvent e) {
    }

    public void windowDeiconified(WindowEvent e) {
    }

    public void windowClosed(WindowEvent e) {
    }

    public void windowClosing(WindowEvent e) {
        hide();
    }

    public static void main(String[] args) {
        CreacionDeUnMarco marco = new CreacionDeUnMarco("Que bonito eres bb <3", 100, 100, 500, 400);
    }
}
