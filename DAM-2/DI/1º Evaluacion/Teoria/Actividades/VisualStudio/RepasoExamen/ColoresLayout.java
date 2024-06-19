package RepasoExamen;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.LineBorder;

public class ColoresLayout extends JFrame {

    Container cp;
    // OBJETOS PARA MENU
    private JMenuBar menuBar = new JMenuBar();
    private JMenu menu;
    private JMenu menu2;
    private JMenu menu3;
    private JMenu radio;

    private JMenuItem item1;
    private JMenuItem item2;

    private ButtonGroup radioGrupo = new ButtonGroup();
    private JRadioButtonMenuItem[] radios = new JRadioButtonMenuItem[4];

    private JCheckBoxMenuItem checkItem;

    // OBJETOS PARA JSCROLLBAR
    JScrollBar scroll1;
    JPanel panel = new JPanel();

    //OBJETOS PARA INTRODUCIR DATOS
    JTextField texto;
    JButton boton;
    JLabel etiqueta;

    //BOTONES PARA CAMBIAR EL COLOR DE FONDO
    JPanel panel2 = new JPanel();
    JButton[] botonesColores = new JButton[6];
    String[] colores = {"Red", "Blue", "Black", "Purple", "Yellow", "Green"};

    // CREACION DEL LAYOUT
    public ColoresLayout() {
        creacionVentana();
        creacionMeuBar();
        creacionVentanaLayout();
    }

    // CREACION DE LA VENTANA
    private void creacionVentana() {
        setTitle("Repaso");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);
    }

    // DECLARACION DE VARIABLES Y CREACION DEL MENUBAR
    private void creacionMeuBar() {
        // Menu 1
        setJMenuBar(menuBar);
        menu = new JMenu("Menu");
        checkItem = new JCheckBoxMenuItem("Ser mas guay");

        menu.add(checkItem);
        menuBar.add(menu);

        // Menu 2
        item1 = new JMenuItem("Acerca de...");
        menu2 = new JMenu("Menu 2");

        menu2.add(item1);
        menuBar.add(menu2);
        // Menu 3
        menu3 = new JMenu("Menu 3");
        radio = new JMenu("Radios");
        item2 = new JMenuItem("Separador");
        for (int i = 0; i < radios.length; i++) {
            radios[i] = new JRadioButtonMenuItem("Soy el radio " + (i + 1));
            radioGrupo.add(radios[i]);
            radio.add(radios[i]);
        }
        menu3.add(radio);
        menu3.addSeparator();
        menu3.add(item2);
        menuBar.add(menu3);
    }

    private void creacionVentanaLayout() {
        cp = getContentPane();
        BorderLayout bl = new BorderLayout();
        cp.setLayout(bl);
        cp.setBackground(Color.black);

        GridBagLayout gbl = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(5, 5,5, 5);

        GridLayout gl2 = new GridLayout(3,2);
        
        //Añadir barra
        scroll1 = new JScrollBar(1,1,10,0,265);
        cp.add(scroll1, BorderLayout.WEST);
        
        //Añadir textos
        texto = new JTextField(8);
        boton = new JButton("Pulsame");
        etiqueta = new JLabel("Mostrare el resultado");
        etiqueta.setBorder(new LineBorder(Color.BLUE, 2));
        panel.setLayout(gbl);
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridheight = 1; // filas
        gbc.gridwidth = 1; // columnas
        panel.add(texto, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridheight = 1; // filas
        gbc.gridwidth = 1; // columnas
        panel.add(boton, gbc);

        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.gridheight = 1; // filas
        gbc.gridwidth = 1; // columnas
        panel.add(etiqueta, gbc);

        cp.add(panel, BorderLayout.SOUTH);

        panel2.setLayout(gl2);
        for(int i = 0; i < botonesColores.length; i++){
            botonesColores[i] = new JButton(colores[i]);
            panel2.add(botonesColores[i]);
        }

        botonesColores[0].setBackground(Color.RED);
        botonesColores[1].setBackground(Color.BLUE);
        botonesColores[2].setBackground(Color.BLACK);
        botonesColores[3].setBackground(Color.PINK);
        botonesColores[4].setBackground(Color.YELLOW);
        botonesColores[5].setBackground(Color.GREEN);

        cp.add(panel2, BorderLayout.EAST);
    }
}
