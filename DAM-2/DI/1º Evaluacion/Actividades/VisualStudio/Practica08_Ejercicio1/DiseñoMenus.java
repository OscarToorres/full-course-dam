package Practica08_Ejercicio1;

import javax.swing.*;

import java.awt.*;

public class DiseñoMenus extends JFrame {

    // CREACION DE OBJETOS
    JPanel panel = new JPanel();

    JLabel texto;

    JMenuBar menubar = new JMenuBar();

    JMenu archivo = new JMenu("Archivo");
    JMenu formato = new JMenu("Formato");
    JMenu color = new JMenu("Color");
    JMenu letra = new JMenu("Tipo de letra");

    JMenuItem item11 = new JMenuItem("Acerca de...");
    JMenuItem item12 = new JMenuItem("Salir");

    ButtonGroup btnGroupColores = new ButtonGroup();
    ButtonGroup btnGroupEstilo = new ButtonGroup();

    JRadioButtonMenuItem negro = new JRadioButtonMenuItem("Negro");
    JRadioButtonMenuItem azul = new JRadioButtonMenuItem("Azul");
    JRadioButtonMenuItem rojo = new JRadioButtonMenuItem("Rojo");
    JRadioButtonMenuItem verde = new JRadioButtonMenuItem("Verde");

    JRadioButtonMenuItem serif = new JRadioButtonMenuItem("Serif");
    JRadioButtonMenuItem monospaced = new JRadioButtonMenuItem("Monospaced");
    JRadioButtonMenuItem sansSerif = new JRadioButtonMenuItem("Sans Serif");

    JCheckBoxMenuItem negrita = new JCheckBoxMenuItem("Negrita");
    JCheckBoxMenuItem cursiva = new JCheckBoxMenuItem("Cursiva");

    public DiseñoMenus() {
        inicioFrame();
        CreacionJMenu();
        creacionLayout();
    }

    private void inicioFrame() {

        setTitle("Uso de objetos JMenu"); // Título del JFrame
        setSize(500, 250); // Dimensiones del JFrame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Cerrar proceso al cerrar ventana
    }

    private void creacionLayout() {

        Container cp = getContentPane();
        cp.setBackground(Color.CYAN);
        texto = new JLabel();
        texto.setText("Texto de ejemplo");
        texto.setHorizontalAlignment(SwingConstants.CENTER);
        Font fuente = new Font("Sans", 1, 50);
        texto.setFont(fuente);

        cp.add(texto);
    }

    private void CreacionJMenu() {
        setJMenuBar(menubar);

        archivo.add(item11);
        archivo.add(item12);
        menubar.add(archivo);

        btnGroupColores.add(negro);
        btnGroupColores.add(azul);
        btnGroupColores.add(rojo);
        btnGroupColores.add(verde);

        color.add(negro);
        color.add(azul);
        color.add(rojo);
        color.add(verde);

        formato.add(color);
        formato.addSeparator();

        btnGroupEstilo.add(serif);
        btnGroupEstilo.add(monospaced);
        btnGroupEstilo.add(sansSerif);

        letra.add(serif);
        letra.add(monospaced);
        letra.add(sansSerif);
        letra.addSeparator();
        letra.add(negrita);
        letra.add(cursiva);

        formato.add(letra);
        menubar.add(formato);
    }
}