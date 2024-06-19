package Practica_10;

import java.awt.*;
import javax.swing.*;

public class RectanguloVentana extends JFrame {

    private JPanel panelNorte = new JPanel();
    private JPanel panelNorte2 = new JPanel();
    private JPanel panelSur = new JPanel();
    private PanelPunto panelPunto = new PanelPunto();

    private JLabel[] coordenadas = new JLabel[4];
    private JTextField[] cajaTexto = new JTextField[4];
    private String[] titulos = { "Coordenada X", "Coordenada Y", "Coordenada X", "Coordenada Y" };
    private JButton[] boton = new JButton[3];
    private String[] titulosBotones = { "Calcular","Dibujar", "Limpiar" };

    // private String contenidoCaja[] = {"Negro", "Rojo", "Azul", "Verde","Amarillo","Rosa"};
    private Color contenidoCaja[] = {Color.BLACK, Color.RED,Color.BLUE, Color.GREEN,Color.YELLOW,Color.PINK};
    private JComboBox caja = new JComboBox<Color>(contenidoCaja);
    
    private JLabel resultado = new JLabel("Distancia entre puntos: ");

    public RectanguloVentana() {
        setTitle("Calcular reactangulo");
        setSize(550, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        Container cp = getContentPane();
        BorderLayout bl = new BorderLayout();
        GridLayout glN = new GridLayout(2, 4);
        GridLayout glN2 = new GridLayout(2, 1);
        GridLayout glS = new GridLayout(1, 3);

        cp.setLayout(bl);
        panelNorte.setLayout(glN);
        panelNorte2.setLayout(glN2);
        panelSur.setLayout(glS);

        for (int i = 0; i < coordenadas.length; i++) {
            coordenadas[i] = new JLabel(titulos[i]);
            cajaTexto[i] = new JTextField();
            panelNorte.add(coordenadas[i]);
            panelNorte.add(cajaTexto[i]);
        }
        
        panelNorte2.add(caja);
        panelNorte2.add(panelNorte);

        cp.add(panelNorte2, BorderLayout.NORTH);

        for (int i = 0; i < boton.length; i++) {
            boton[i] = new JButton(titulosBotones[i]);
            panelSur.add(boton[i]);
        }

        cp.add(panelSur, BorderLayout.SOUTH);

        panelPunto.add(resultado);
        cp.add(panelPunto, BorderLayout.CENTER);
    }

    public JTextField[] getCajaTexto() {
        return cajaTexto;
    }

    public void setCajaTexto(JTextField[] cajaTexto) {
        this.cajaTexto = cajaTexto;
    }

    public JButton[] getBoton() {
        return boton;
    }

    public void setBoton(JButton[] boton) {
        this.boton = boton;
    }

    public PanelPunto getPanelPunto() {
        return panelPunto;
    }

    public void setPanelPunto(PanelPunto panelPunto) {
        this.panelPunto = panelPunto;
    }

    public JLabel getResultado() {
        return resultado;
    }

    public void setResultado(JLabel resultado) {
        this.resultado = resultado;
    }

    public JComboBox getCaja() {
        return caja;
    }

    public void setCaja(JComboBox caja) {
        this.caja = caja;
    }

    

    

    

    
}