import java.awt.Container;
import java.awt.*;

import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AnalizarFraseLayout extends JFrame {
    //Declaracion de objetos

    JPanel panel1 = new JPanel();
    
    JTextField texto1 = new JTextField(8);
    JTextField texto2 = new JTextField(8);
    JTextField texto3 = new JTextField(8);

    JLabel etiqueta1 = new JLabel("Introduce frase");
    JLabel etiqueta2 = new JLabel("Número de letras");
    JLabel etiqueta3 = new JLabel("Número de palabras");

    JButton boton = new JButton("Procesar frase");

    //Contructor

    public AnalizarFraseLayout(){
        super("Practica_05");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crear un lienzo donde poner nuestros objetos
        Container cp = getContentPane();

        //Divide como quiere que sea nuestro lienzo
        GridLayout gl1 = new GridLayout(2,2);
        GridLayout gl2 = new GridLayout(2,2);
        gl1.setHgap(50);
        gl1.setVgap(50);

        //Se aplica al lienzo el el grid que me interesa
        cp.setLayout(gl1);

        //Añadimos los elementos al Container que es un GridLayout de 2x2
        cp.add(etiqueta1);
        cp.add(texto1);
        cp.add(boton);

        //En el 4 hueco colocamos un panel y lo definimos como otro
        //GridLayout de 2x2
        cp.add(panel1);
        panel1.setLayout(gl2);

        //Se añade al panel el resto de objetos
        panel1.add(etiqueta2);
        panel1.add(texto2);
        panel1.add(etiqueta3);
        panel1.add(texto3);

        //Llamamos al action listener
        boton.addActionListener(new AnalizarFraseApp(this));


    }

    

    


}
