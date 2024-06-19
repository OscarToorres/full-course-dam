import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.*;

public class VentanaBorder extends JFrame{
    JPanel panelN = new JPanel();
    JPanel panelC = new JPanel();
    JPanel panelS = new JPanel();

    //Definir elementos del panel
    JTextField texto1 = new JTextField(8);
    JTextField texto2 = new JTextField(8);
    JTextField texto3 = new JTextField(8);
    JTextField texto4 = new JTextField(8);

    JButton boton1 = new JButton("Comprobar");
    JButton boton2 = new JButton("Salir");

    JLabel etiqueta1 = new JLabel("Soy una etiqueta ;)");

    public VentanaBorder() {

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
        boton1.addActionListener(new VentanaBorderTest(this));
        boton2.addActionListener(new VentanaBorderTest(this));
    }
}