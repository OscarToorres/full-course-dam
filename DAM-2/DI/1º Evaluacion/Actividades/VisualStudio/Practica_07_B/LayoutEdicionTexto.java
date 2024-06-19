package Practica_07_B;

import java.awt.*;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.FontUIResource;

public class LayoutEdicionTexto extends JFrame{

    //CREACION DE OBJETOS

    //Paneles
    JPanel panelNorth = new JPanel();
    JPanel panelWest = new JPanel();
    JPanel panelEast = new JPanel();
    JPanel panelSouth = new JPanel();

    //Etiquetas
    JLabel etiqueta = new JLabel("Introduce cualquier texto");

    //Cajas de texto
    JTextField txtBox = new JTextField();

    //Check Box
    JCheckBox seleccion = new JCheckBox("Cursiva");

    //Radio Buttons
    JRadioButton[] btnRadio = new JRadioButton[3];
    ButtonGroup bg = new ButtonGroup();

    //Datis bb
    String[] tamaño = {"12","18","24"};

    public LayoutEdicionTexto(){
        //Ventana inicial
        super.setTitle("Ventana tamaño fuente");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //Inicializacion de los objetos
        //Check box
        for (int i = 0; i < btnRadio.length; i++) {
            btnRadio[i] = new JRadioButton();
            btnRadio[i].setText(tamaño[i]);
            bg.add(btnRadio[i]);
        }

        //Etiquetas de texto
        etiqueta.setFont(new FontUIResource("Calibri", 1, 20));

        //Cracion de los layouts
        Container cp = getContentPane();
        BorderLayout bl = new BorderLayout();
        bl.setVgap(50);
        
        GridLayout glNorth = new GridLayout(2,1,0,30);
        GridLayout glEast = new GridLayout(3,1);
        GridLayout glSouth = new GridLayout(1,2,100,0);

        
        // GridBagLayout gbl = new GridBagLayout();
        // GridBagConstraints gbc = new GridBagConstraints();
        // gbc.fill = GridBagConstraints.BOTH;
        // gbc.insets = new Insets(5,10,5,10);

        //Aplicacion del layout
        cp.setLayout(bl);

        //Layout North
        panelNorth.setLayout(glNorth);
        panelNorth.add(etiqueta);
        panelNorth.add(txtBox);

        cp.add(panelNorth, BorderLayout.NORTH);

        //Layout West
        panelWest.setBorder(new LineBorder(Color.BLACK));
        panelWest.setBorder(new TitledBorder("Estilo"));
        panelWest.add(seleccion);
        // gbc.gridx = 0;
        // gbc.gridy = 0;
        // gbc.gridheight = 1;
        // gbc.gridwidth = 1;

        // panelWest.add(seleccion, gbc);

        //Layout East
        panelEast.setLayout(glEast);
        panelEast.setBorder(new LineBorder(Color.BLACK));
        panelEast.setBorder(new TitledBorder("Tamaño"));
        panelEast.add(btnRadio[0]);
        panelEast.add(btnRadio[1]);
        panelEast.add(btnRadio[2]);

        // gbc.gridx = 0;
        // gbc.gridy = 0;
        // gbc.gridheight = 1;
        // gbc.gridwidth = 1;
        // panelEast.add(btnRadio[0], gbc);

        // gbc.gridx = 0;
        // gbc.gridy = 1;
        // gbc.gridheight = 1;
        // gbc.gridwidth = 1;
        // panelEast.add(btnRadio[1], gbc);

        // gbc.gridx = 0;
        // gbc.gridy = 2;
        // gbc.gridheight = 1;
        // gbc.gridwidth = 1;
        // panelEast.add(btnRadio[2], gbc);


        //Layout South
        panelSouth.setLayout(glSouth);
        

        panelSouth.add(panelWest);
        panelSouth.add(panelEast);

        cp.add(panelSouth, BorderLayout.SOUTH);



    }   
}