package Practica_05_B;

import java.awt.*;

import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ConversionLayout extends JFrame {

    //Declaracion de objetos

    public JButton boton = new JButton("Aceptar");

    JLabel etiqueta1 = new JLabel("Grados centígrados:");
    JLabel etiqueta2 = new JLabel("Grados Farenheit:");

    JTextField texto1 = new JTextField("0.00");
    JTextField texto2 = new JTextField("32.00");

    String txt1Ant = "0.00", txt2Ant = "32.00";

    //Declaracion del constructor
    public ConversionLayout() {
        super("Conversion de temperaturas");
        setSize(400,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //Creacion del contenerdor, que será nuestro lienzo
        Container cp = getContentPane();
        GridBagLayout gbl = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(10,10,10,5);

        //Aplicacion del grid que nos interesa en el lienzo
        cp.setLayout(gbl);

        //Division del lienzo
        //El GridBagConstraints es un nuevo lienzo, se declara y se alade junto con el objeto en el layout.
        //Este especifica la posicion y lo que ocupa el objeto. Los dos primeros indican la posicion y los 
        //dos siguientes lo que ocupa
        //Se pueden crear varios constraint o se puede crear uno y segun se especifica se añade y asi se 
        //puede volver a modificar para otro objeto, en vez de crear varios y despues añadir el correspondiente a
        //cada objeto.
        gbc.gridx = 0; //El label esta en la columna cero
        gbc.gridy = 0; //El label esta en la fila cero
        gbc.gridheight = 1; //El label ocupa 1 fila 
        gbc.gridwidth = 1; //El label ocupa 1 columna
        //Definida la posicion se añade el objeto al lienzo
        cp.add(etiqueta1, gbc);

        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.gridheight = 1;
        gbc.gridwidth = 2;
        cp.add(texto1, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        cp.add(etiqueta2, gbc);

        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.gridheight = 1;
        gbc.gridwidth = 2;
        cp.add(texto2, gbc);

        gbc.gridx = 2;
        gbc.gridy = 3;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        cp.add(boton, gbc);

        boton.addActionListener(new ConversionApp(this));

    }

    
}
