import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.*;

public class VentanaBorderLayout extends JFrame{
    private JPanel panelN = new JPanel();
    private JPanel panelC = new JPanel();
    private JPanel panelS = new JPanel();

    //Definir elementos del panel
    private JTextField texto1 = new JTextField(8);
    private JTextField texto2 = new JTextField(8);
    private JTextField texto3 = new JTextField(8);
    private JTextField texto4 = new JTextField(8);

    private JButton boton1 = new JButton("Comprobar");
    private JButton boton2 = new JButton("Salir");

    private JLabel etiqueta1 = new JLabel("Soy una etiqueta ;)");

    public VentanaBorderLayout() {

        super("Practica_04");
        setSize(600,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container cp = getContentPane();
    
        //Añadimos los paneles al CONTAINER
        cp.add(panelN, BorderLayout.NORTH);
        cp.add(panelS, BorderLayout.SOUTH);
        cp.add(panelC, BorderLayout.CENTER);

        //Añadimos los elementos al panel
        panelC.add(texto1);     
        panelC.add(texto2);
        panelC.add(texto3);
        panelC.add(texto4);
        panelN.add(etiqueta1);
        panelS.add(boton1);
        panelS.add(boton2);

        //Añadir al escuchador
        boton1.addActionListener(new VentanaBorderControlador(this));
        boton2.addActionListener(new VentanaBorderControlador(this));
    }

    public JTextField getTexto1() {
        return texto1;
    }

    public void setTexto1(JTextField texto1) {
        this.texto1 = texto1;
    }

    public JTextField getTexto2() {
        return texto2;
    }

    public void setTexto2(JTextField texto2) {
        this.texto2 = texto2;
    }

    public JTextField getTexto3() {
        return texto3;
    }

    public void setTexto3(JTextField texto3) {
        this.texto3 = texto3;
    }

    public JTextField getTexto4() {
        return texto4;
    }

    public void setTexto4(JTextField texto4) {
        this.texto4 = texto4;
    }

    public JButton getBoton1() {
        return boton1;
    }

    public void setBoton1(JButton boton1) {
        this.boton1 = boton1;
    }

    public JButton getBoton2() {
        return boton2;
    }

    public void setBoton2(JButton boton2) {
        this.boton2 = boton2;
    }

    public JLabel getEtiqueta1() {
        return etiqueta1;
    }

    public void setEtiqueta1(JLabel etiqueta1) {
        this.etiqueta1 = etiqueta1;
    }
}