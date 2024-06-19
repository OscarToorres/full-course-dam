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
    private JPanel panelNorth = new JPanel();
    private JPanel panelWest = new JPanel();
    private JPanel panelEast = new JPanel();
    private JPanel panelSouth = new JPanel();

    //Etiquetas
    private JLabel etiqueta = new JLabel("Introduce cualquier texto");

    //Cajas de texto
    private JTextField txtBox = new JTextField();

    //Check Box
    private JCheckBox seleccion = new JCheckBox("Cursiva");

    //Radio Buttons
    private JRadioButton[] btnRadio = new JRadioButton[3];
    private ButtonGroup bg = new ButtonGroup();

    //Datis bb
    private String[] tamaño = {"12","18","24"};

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

        //Layout East
        panelEast.setLayout(glEast);
        panelEast.setBorder(new LineBorder(Color.BLACK));
        panelEast.setBorder(new TitledBorder("Tamaño"));
        panelEast.add(btnRadio[0]);
        panelEast.add(btnRadio[1]);
        panelEast.add(btnRadio[2]);

        //Layout South
        panelSouth.setLayout(glSouth);
        
        panelSouth.add(panelWest);
        panelSouth.add(panelEast);

        cp.add(panelSouth, BorderLayout.SOUTH);
    }

    public JLabel getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(JLabel etiqueta) {
        this.etiqueta = etiqueta;
    }

    public JTextField getTxtBox() {
        return txtBox;
    }

    public void setTxtBox(JTextField txtBox) {
        this.txtBox = txtBox;
    }

    public JCheckBox getSeleccion() {
        return seleccion;
    }

    public void setSeleccion(JCheckBox seleccion) {
        this.seleccion = seleccion;
    }

    public JRadioButton[] getBtnRadio() {
        return btnRadio;
    }

    public void setBtnRadio(JRadioButton[] btnRadio) {
        this.btnRadio = btnRadio;
    }

    public ButtonGroup getBg() {
        return bg;
    }

    public void setBg(ButtonGroup bg) {
        this.bg = bg;
    }

    public String[] getTamaño() {
        return tamaño;
    }

    public void setTamaño(String[] tamaño) {
        this.tamaño = tamaño;
    }   
}