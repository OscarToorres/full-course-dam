package Practica_07;

import java.awt.*;
import javax.swing.*;
import java.awt.Container;

public class DiseñoColores extends JFrame {

    // ¡¡¡OJO!!!
    // Tener en cuenta que las variables hay que declararlas privadas y trabajar
    // fuera con getters y setters
    // aunque aqui no se este haciendo por ser un ejercicio de clase
    // Declaracion de objetos

    // Paneles
    private JPanel panel1 = new JPanel();
    private JPanel panel2 = new JPanel();
    private JPanel panel3 = new JPanel();
    private JPanel panelCentro = new JPanel();

    // Barras de scroll
    private JScrollBar[] barra = new JScrollBar[3];

    // Etiquetas
    private JLabel rgbRojo = new JLabel("rojo");
    private JLabel rgbVerde = new JLabel("verde");
    private JLabel rgbAzul = new JLabel("azul");

    // Cajas de texto
    private JTextField[] rgbNumero = new JTextField[3];

    // Array de Botones de colores
    private JButton[] colores = new JButton[13];

    // Array de String con los colores por defecto
    private String[] color = { "negro", "gris oscuro", "gris", "grisClaro", "blanco",
            "magenta", "azul", "cian", "verde", "amarillo", "naranja", "rojo", "rosa" };

    // Bojetos para guardar el estado de las cajas de texto
    private String estado[] = new String[3];

    public DiseñoColores() {
        // Especificaciones basicas de la ventana
        super("Colores");
        setSize(600, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Modificacion de estilos de los Objetos
        // Botones
        // Primero se crea un botos y despues se asigna al Array, esto se hace para
        // evitar posibles fallos e incongruencias
        for (int i = 0; i < colores.length; i++) {
            JButton boton = new JButton();
            boton.setText(color[i]);
            boton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
            boton.setForeground(Color.BLACK);
            colores[i] = boton;
        }

        colores[0].setBackground(java.awt.Color.BLACK);
        colores[0].setForeground(Color.WHITE);
        colores[1].setBackground(java.awt.Color.DARK_GRAY);
        colores[1].setForeground(Color.WHITE);
        colores[2].setBackground(java.awt.Color.GRAY);
        colores[3].setBackground(java.awt.Color.LIGHT_GRAY);
        colores[4].setBackground(java.awt.Color.WHITE);
        colores[5].setBackground(java.awt.Color.MAGENTA);
        colores[6].setBackground(java.awt.Color.BLUE);
        colores[7].setBackground(java.awt.Color.CYAN);
        colores[8].setBackground(java.awt.Color.GREEN);
        colores[9].setBackground(java.awt.Color.YELLOW);
        colores[10].setBackground(java.awt.Color.ORANGE);
        colores[11].setBackground(java.awt.Color.RED);
        colores[12].setBackground(java.awt.Color.PINK);

        // Etiquetas
        rgbRojo.setOpaque(true);
        rgbRojo.setBackground(Color.RED);
        rgbRojo.setForeground(Color.BLACK);
        rgbVerde.setOpaque(true);
        rgbVerde.setBackground(Color.GREEN);
        rgbVerde.setForeground(Color.BLACK);
        rgbAzul.setOpaque(true);
        rgbAzul.setBackground(Color.BLUE);
        rgbAzul.setForeground(Color.BLACK);

        // Cajas de texto
        for (int i = 0; i < rgbNumero.length; i++) {
            rgbNumero[i] = new JTextField();
            rgbNumero[i].setText("0");
        }

        // Barras
        for (int i = 0; i < barra.length; i++) {
            // Orientacion indica si es vertical o horizontal, value el valor con el que
            // empieza, extent es la longitud de la barra desplazadora min valor minimo, max
            // valor maximmo
            barra[i] = new JScrollBar(1, 1, 20, 0, 275);
        }

        // Objetos estado
        for (int i = 0; i < estado.length; i++) {
            estado[i] = new String();
            estado[i] = rgbNumero[i].getText();
        }

        // Cracion de los layouts
        Container cp = getContentPane();
        BorderLayout bl = new BorderLayout();

        GridLayout gl1 = new GridLayout(1, 3);
        gl1.setHgap(0);

        GridLayout gl2 = new GridLayout(1, 6);
        gl2.setHgap(0);

        GridLayout gl3 = new GridLayout(13, 1);
        gl3.setVgap(0);

        // Establecer layout
        cp.setLayout(bl);
        panel1.setLayout(gl1);
        panel2.setLayout(gl2);
        panel3.setLayout(gl3);

        // AÑADIR ELEMENTOS AL PANEL

        // Zona WEST
        panel1.add(barra[0]);
        panel1.add(barra[1]);
        panel1.add(barra[2]);
        cp.add(panel1, BorderLayout.WEST);

        // Zona SOUTH
        panel2.add(rgbRojo);
        panel2.add(rgbNumero[0]);
        panel2.add(rgbVerde);
        panel2.add(rgbNumero[1]);
        panel2.add(rgbAzul);
        panel2.add(rgbNumero[2]);
        cp.add(panel2, BorderLayout.SOUTH);

        // Zona EAST
        for (int i = 0; i < colores.length; i++) {
            panel3.add(colores[i]);
        }
        cp.add(panel3, BorderLayout.EAST);

        // Zona CENTER
        // panelCentro.setBackground(java.awt.Color.LIGHT_GRAY);
        cp.add(panelCentro, BorderLayout.CENTER);

        setVisible(true);
    }

    // Getters & Setters

    public Integer filtrarTexto(String rgbTexto) {
        Integer numero = Integer.parseInt(rgbTexto);
        System.out.println("Entra por el filtro");
        System.out.println("Valor del filtro " + numero);
        if (numero >= 0 && numero <= 255) {
            return numero;
        } else if (numero < 0) {
            return 0;
        } else {
            return 255;
        }
    }

    public JTextField[] getRgbNumero() {
        return rgbNumero;
    }

    public void setRgbNumero(JTextField[] rgbNumero) {
        this.rgbNumero = rgbNumero;
    }

    public JPanel getPanelCentro() {
        return panelCentro;
    }

    public void setPanelCentro(JPanel panelCentro) {
        this.panelCentro = panelCentro;
    }

    public JScrollBar[] getBarra() {
        return barra;
    }

    public void setBarra(JScrollBar[] barra) {
        this.barra = barra;
    }

    public JLabel getRgbRojo() {
        return rgbRojo;
    }

    public void setRgbRojo(JLabel rgbRojo) {
        this.rgbRojo = rgbRojo;
    }

    public JLabel getRgbVerde() {
        return rgbVerde;
    }

    public void setRgbVerde(JLabel rgbVerde) {
        this.rgbVerde = rgbVerde;
    }

    public JLabel getRgbAzul() {
        return rgbAzul;
    }

    public void setRgbAzul(JLabel rgbAzul) {
        this.rgbAzul = rgbAzul;
    }

    public JButton[] getColores() {
        return colores;
    }

    public void setColores(JButton[] colores) {
        this.colores = colores;
    }

    public String[] getColor() {
        return color;
    }

    public void setColor(String[] color) {
        this.color = color;
    }

    public String[] getEstado() {
        return estado;
    }

    public void setEstado(String[] estado) {
        this.estado = estado;
    }   
}