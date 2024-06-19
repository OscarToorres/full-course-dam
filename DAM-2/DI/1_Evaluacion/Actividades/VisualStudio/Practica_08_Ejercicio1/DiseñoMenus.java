package Practica_08_Ejercicio1;

import javax.swing.*;
import java.awt.*;

public class DiseñoMenus extends JFrame {

    // CREACION DE OBJETOS
    private JLabel texto;

    private JMenuBar menubar = new JMenuBar();

    private JMenu archivo = new JMenu("Archivo");
    private JMenu formato = new JMenu("Formato");
    private JMenu color = new JMenu("Color");
    private JMenu letra = new JMenu("Tipo de letra");
    private JMenu colorFondo = new JMenu("Color fondo");

    private JMenuItem item11 = new JMenuItem("Acerca de...");
    private JMenuItem item12 = new JMenuItem("Salir");

    private ButtonGroup btnGroupColores = new ButtonGroup();
    private ButtonGroup btnGroupColoresFondo = new ButtonGroup();

    private JRadioButtonMenuItem[] itemsColores = new JRadioButtonMenuItem[4];
    private JRadioButtonMenuItem[] itemsColoresFondo = new JRadioButtonMenuItem[4];
    private JRadioButtonMenuItem[] itemsTipo = new JRadioButtonMenuItem[3];
    private JCheckBoxMenuItem[] itemsEstilo = new JCheckBoxMenuItem[2];

    private String[] colores = { "Negro", "Azul", "Rojo", "Verde" };
    private String[] tipos = { "Serif", "Monospaced", "Sans Serif" };
    private String[] estilos = { "Negrita", "Cursiva" };

    // Fuente
    private Font fuente;

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
        fuente = new Font(null, 0, 50);
        texto.setFont(fuente);

        cp.add(texto);
    }

    private void CreacionJMenu() {
        setJMenuBar(menubar);

        archivo.add(item11);
        archivo.add(item12);
        //Añadir items de colores fondo
        for (int i = 0; i < itemsColores.length; i++) {
            itemsColoresFondo[i] = new JRadioButtonMenuItem();
            itemsColoresFondo[i].setText(colores[i]);
            btnGroupColoresFondo.add(itemsColoresFondo[i]);
            colorFondo.add(itemsColoresFondo[i]);
        }
        archivo.addSeparator();        
        archivo.add(colorFondo);
        menubar.add(archivo);
        // Añadir Items de Colores
        for (int i = 0; i < itemsColores.length; i++) {
            itemsColores[i] = new JRadioButtonMenuItem();
            itemsColores[i].setText(colores[i]);
            btnGroupColores.add(itemsColores[i]);
            color.add(itemsColores[i]);
        }
        formato.add(color);
        formato.addSeparator();        
        // Añadir Items de fuente
        for (int i = 0; i < itemsTipo.length; i++) {
            itemsTipo[i] = new JRadioButtonMenuItem();
            itemsTipo[i].setText(tipos[i]);
            btnGroupColores.add(itemsTipo[i]);
            letra.add(itemsTipo[i]);
        }
        letra.addSeparator();

        // Añadir Items de estilo
        for (int i = 0; i < itemsEstilo.length; i++) {
            itemsEstilo[i] = new JCheckBoxMenuItem();
            itemsEstilo[i].setText(estilos[i]);
            letra.add(itemsEstilo[i]);
        }
        formato.add(letra);
        menubar.add(formato);
    }

    public JRadioButtonMenuItem[] getItemsColores() {
        return itemsColores;
    }

    public void setItemsColores(JRadioButtonMenuItem[] itemsColores) {
        this.itemsColores = itemsColores;
    }

    public JRadioButtonMenuItem[] getItemsColoresFondo() {
        return itemsColoresFondo;
    }

    public void setItemsColoresFondo(JRadioButtonMenuItem[] itemsColoresFondo) {
        this.itemsColoresFondo = itemsColoresFondo;
    }

    public JRadioButtonMenuItem[] getItemsTipo() {
        return itemsTipo;
    }

    public void setItemsTipo(JRadioButtonMenuItem[] itemsTipo) {
        this.itemsTipo = itemsTipo;
    }

    public JCheckBoxMenuItem[] getItemsEstilo() {
        return itemsEstilo;
    }

    public void setItemsEstilo(JCheckBoxMenuItem[] itemsEstilo) {
        this.itemsEstilo = itemsEstilo;
    }

    public JMenuItem getItem11() {
        return item11;
    }

    public void setItem11(JMenuItem item11) {
        this.item11 = item11;
    }

    public JMenuItem getItem12() {
        return item12;
    }

    public void setItem12(JMenuItem item12) {
        this.item12 = item12;
    }

    public JLabel getTexto() {
        return texto;
    }

    public void setTexto(JLabel texto) {
        this.texto = texto;
    }
}