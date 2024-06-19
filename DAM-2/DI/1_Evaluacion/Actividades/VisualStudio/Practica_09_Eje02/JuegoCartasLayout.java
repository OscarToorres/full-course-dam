package Practica_09_Eje02;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.*;

public class JuegoCartasLayout extends JFrame {

    private JPanel panel = new JPanel();
    private JToggleButton[] carta = new JToggleButton[8];

    //Las cartasEstado guardaran el valor de las cartas
    private JToggleButton[] estadoCarta = new JToggleButton[8];
    private JLabel contador = new JLabel("Intentos: 1");

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
            //Generamos cartas estado
            estadoCarta[i] = new JToggleButton();
        }
        // this.generarColoresAleatorios();
        this.generarCartasAleatorias();

        cp.add(panel, BorderLayout.CENTER);
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
        String[] imagenCartas = { "I:\\DAM 2\\DI\\1º Evaluacion\\Teoria\\Actividades\\Imagenes\\SotaBastos.PNG",
        "I:\\DAM 2\\DI\\1º Evaluacion\\Teoria\\Actividades\\Imagenes\\SotaBastos.PNG",
        "I:\\DAM 2\\DI\\1º Evaluacion\\Teoria\\Actividades\\Imagenes\\SotaOro.PNG",
        "I:\\DAM 2\\DI\\1º Evaluacion\\Teoria\\Actividades\\Imagenes\\SotaOro.PNG",
        "I:\\DAM 2\\DI\\1º Evaluacion\\Teoria\\Actividades\\Imagenes\\SotaEspadas.PNG",
        "I:\\DAM 2\\DI\\1º Evaluacion\\Teoria\\Actividades\\Imagenes\\SotaEspadas.PNG",
        "I:\\DAM 2\\DI\\1º Evaluacion\\Teoria\\Actividades\\Imagenes\\SotaCopas.PNG",
        "I:\\DAM 2\\DI\\1º Evaluacion\\Teoria\\Actividades\\Imagenes\\SotaCopas.PNG" };
        // String[] imagenCartas = {"SotaBastos.PNG","SotaBastos.PNG","SotaOro.PNG", "SotaOro.PNG", "SotaEspadas.PNG", "SotaEspadas.PNG" ,"SotaCopas.PNG", "SotaCopas.PNG"  };
        int j = imagenCartas.length;
        ArrayList<String> listaCartas = new ArrayList<>();

        Random random = new Random();

        for (int i = 0; i < imagenCartas.length; i++) {
            listaCartas.add(imagenCartas[i]);
        }

        for (int i = 0; i < j; i++) {
            int r = random.nextInt(listaCartas.size());
            // estadoCarta[i].setIcon(new ImageIcon(getClass().getResource("imagenes\\"+ listaCartas.get(r))));
            carta[i].setDisabledIcon(new ImageIcon(listaCartas.get(r)));
            listaCartas.remove(r);
        }
    }

    public void asignarCarta(int i) {
        carta[i].setIcon(estadoCarta[i].getIcon());
    }

    
}