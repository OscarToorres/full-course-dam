package Practica_09_Eje02;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.*;

public class JuegoCartasLayout extends JFrame {

    private JPanel panel = new JPanel();
    private JToggleButton[] carta = new JToggleButton[8];
    private JLabel contador = new JLabel("Intentos: 1");
    // private ArrayList<String> listaCartasDesordenadas = new ArrayList<>();


    public JuegoCartasLayout() {
        inicioLayout();
        desarrolloLayout();
    }

    private void inicioLayout() {
        setTitle("Juego de cartas");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 600);
    }

    private void desarrolloLayout() {

        Container cp = getContentPane();
        BorderLayout bl = new BorderLayout();
        GridLayout gl = new GridLayout(2, 4);
        gl.setHgap(10);
        gl.setVgap(10);
        panel.setBackground(Color.BLACK);

        cp.setLayout(bl);

        panel.setLayout(gl);
        for (int i = 0; i < carta.length; i++) {
            carta[i] = new JToggleButton();
            carta[i].setText("Carta: " + (i + 1));
            carta[i].setSelected(true);
            panel.add(carta[i]);
        }
        this.generarColoresAleatorios();
        // this.generarCartasAleatorias();
        // ImageIcon icon = new ImageIcon("E:\\DAM 2\\DI\\1º
        // Evaluacion\\Teoria\\Actividades\\Imagenes\\SotaBastos.PNG");
        // carta[0].setIcon(icon);

        // for (int i = 0; i < carta.length; i++) {
        //     carta[i].setText("Carta: " + (i + 1) + " " + carta[i].getBackground());
        // }

        cp.add(panel, BorderLayout.CENTER);
        // contador.setHorizontalAlignment(SwingsConstraints);
        cp.add(contador, BorderLayout.NORTH);
    }

    public JToggleButton[] getCarta() {
        return carta;
    }

    public void setCarta(JToggleButton[] carta) {
        this.carta = carta;
    }

    public JLabel getContador() {
        return contador;
    }

    public void setContador(JLabel contador) {
        this.contador = contador;
    }

    private void generarColoresAleatorios() {
        Color[] colores = { Color.RED, Color.BLUE, Color.GREEN, Color.ORANGE,
                Color.RED, Color.BLUE, Color.GREEN,
                Color.ORANGE };
        int j = colores.length;
        ArrayList<Color> color = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < colores.length; i++) {
            color.add(colores[i]);
        }

        for (int i = 0; i < j; i++) {
            int r = random.nextInt(color.size());
            carta[i].setBackground(color.get(r));
            color.remove(r);
        }
    }

    private void generarCartasAleatorias() {
        String[] ImagenCartas = { "E:\\DAM 2\\DI\\1º Evaluacion\\Teoria\\Actividades\\Imagenes\\SotaBastos.PNG",
                "E:\\DAM 2\\DI\\1º Evaluacion\\Teoria\\Actividades\\Imagenes\\SotaBastos.PNG",
                "E:\\DAM 2\\DI\\1º Evaluacion\\Teoria\\Actividades\\Imagenes\\SotaOro.PNG",
                "E:\\DAM 2\\DI\\1º Evaluacion\\Teoria\\Actividades\\Imagenes\\SotaOro.PNG",
                "E:\\DAM 2\\DI\\1º Evaluacion\\Teoria\\Actividades\\Imagenes\\SotaEspadas.PNG",
                "E:\\DAM 2\\DI\\1º Evaluacion\\Teoria\\Actividades\\Imagenes\\SotaEspadas.PNG",
                "E:\\DAM 2\\DI\\1º Evaluacion\\Teoria\\Actividades\\Imagenes\\SotaCopas.PNG",
                "E:\\DAM 2\\DI\\1º Evaluacion\\Teoria\\Actividades\\Imagenes\\SotaCopas.PNG" };
        int j = carta.length;
        ArrayList<String> listaCartas = new ArrayList<>();

        Random random = new Random();

        for (int i = 0; i < ImagenCartas.length; i++) {
            listaCartas.add(ImagenCartas[i]);
        }

        for (int i = 0; i < j; i++) {
            int r = random.nextInt(listaCartas.size());
            // ImageIcon icon = new ImageIcon("whatever.jpg");
            // Image img = icon.getImage();
            // BufferedImage bi = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
            // Image newimg = img.getScaledInstance( NEW_WIDTH, NEW_HEIGHT,  java.awt.Image.SCALE_SMOOTH ) ;  
            carta[i].setIcon(new ImageIcon(listaCartas.get(r)));
            //listaCartasDesordenadas.add(listaCartas.get(r));
            listaCartas.remove(r);
        }
    }
}