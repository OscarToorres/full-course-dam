package Practica08_Ejemplos;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class VentanasInternas extends JFrame implements InternalFrameListener, ActionListener{

    JTextArea texto;
    JDesktopPane escritorio;
    JInternalFrame ventana;
    JInternalFrame escuchaVentana;
    static final String MOSTRAR = "show";
    static final String LIMPIAR = "clear";
    String nuevaLinea = "\n";
    static final int ancho = 500;
    static final int alto = 300;

    public VentanasInternas() {
        super("InternalVentana");
        addWindowListener(new WindowAdapter() {
            public void windowClosing(InternalFrameEvent e) {
            System.exit(0);
        }
    });
    escritorio= new JDesktopPane();
    escritorio.setPreferredSize(new Dimension(ancho, alto));
    setContentPane(escritorio);
    createDisplayWindow();
    escritorio.add(ventana);
    Dimension displayTamaño = ventana.getSize();
    ventana.setSize(ancho, displayTamaño.height);
    //The following probably would save significant time if we reused
    //the internal frame. We can't reuse it, due to bug #4128975.
    //createListenedToWindow();
}
    //Create the window that displays event information.
    protected void createDisplayWindow() {
        JButton b1 = new JButton("Show internal frame");
        b1.setActionCommand(MOSTRAR);
        b1.addActionListener(this);

        JButton b2 = new JButton("Clear event info");
        b2.setActionCommand(LIMPIAR);
        b2.addActionListener(this);

        texto = new JTextArea(5, 40);
        texto.setEditable(false);
        JScrollPane textScroller = new JScrollPane(ventana);

        ventana = new JInternalFrame("Event Watcher",
                                        true, //resizable
                                        false, //not closable
                                       false, //not maximizable
                                        true); //iconifiable
        JPanel contentPane = new JPanel();
        contentPane.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        contentPane.setLayout(new BoxLayout(contentPane,BoxLayout.Y_AXIS));
        
        b1.setAlignmentX(CENTER_ALIGNMENT);
        contentPane.add(b1);
        contentPane.add(Box.createRigidArea(new Dimension(0, 5)));
        contentPane.add(textScroller);
        contentPane.add(Box.createRigidArea(new Dimension(0, 5)));
        b2.setAlignmentX(CENTER_ALIGNMENT);
        contentPane.add(b2);

        ventana.setContentPane(contentPane);
        ventana.pack();
    }
    //Create the listened-to window.
    protected void createListenedToWindow() {
        escuchaVentana = new JInternalFrame("Event Generator",
                                    true, //resizable
                                    true, //closable
                                    true, //maximizable
                                    true); //iconifiable
        //The next statement is necessary to work around bug 4128975.
        escuchaVentana.setDefaultCloseOperation(
        WindowConstants.DISPOSE_ON_CLOSE);
        escuchaVentana.setSize(300, 100);
    }
    public void internalFrameClosing(InternalFrameEvent e) {
        displayMessage("Internal frame closing", e);
    }
    public void internalFrameClosed(InternalFrameEvent e) {
        displayMessage("Internal frame closed", e);
        escuchaVentana = null;
    }
    public void internalFrameOpened(InternalFrameEvent e) {
        displayMessage("Internal frame opened", e);
        //XXX: Why do we get one of these when we dispose of a window?
        //XXX: And not when you first show the window?
    }
    public void internalFrameIconified(InternalFrameEvent e) {
        displayMessage("Internal frame iconified", e);
    }
    public void internalFrameDeiconified(InternalFrameEvent e) {
        displayMessage("Internal frame deiconified", e);
    }
    public void internalFrameActivated(InternalFrameEvent e) {
        displayMessage("Internal frame activated", e);
    }
    public void internalFrameDeactivated(InternalFrameEvent e) {
        displayMessage("Internal frame deactivated", e);
    }
    void displayMessage(String prefix, InternalFrameEvent e) {
        String s = prefix + ": " + e.getSource();
        texto.append(s + nuevaLinea);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(MOSTRAR)) {
            //Can't show/setVisible, due to bug 4128975.
            //listenedToWindow.setVisible(true);
            //Crea una nueva ventana interna.
            if (escuchaVentana == null) {
                createListenedToWindow();
                escuchaVentana.addInternalFrameListener(this);
                escritorio.add(escuchaVentana);
                Dimension size = escuchaVentana.getSize();
                escuchaVentana.setLocation(ancho/2 - size.width/2,
                                            alto - size.height);
            }
        } else {
            texto.setText("");
        }
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.pack();
        frame.setVisible(true);
    }
}

