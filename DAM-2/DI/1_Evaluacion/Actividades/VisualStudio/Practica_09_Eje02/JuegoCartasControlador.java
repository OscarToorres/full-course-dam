package Practica_09_Eje02;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JToggleButton;

public class JuegoCartasControlador {

    private JuegoCartasLayout layout = new JuegoCartasLayout();

    private int contadorCartas = 1;
    private int contadorIntentos = 1;
    private int contadorParejas = 0;
    private String contadorTexto = layout.getContador().getText();
    private String aciertoTexto = "     A por otra pareja compeón ;)";
    private ArrayList<JToggleButton> cartaAnterior = new ArrayList<>();

    public JuegoCartasControlador() {
        layout.setVisible(true);

    }

    public void Controlador() {

        JToggleButton[] botones = layout.getCarta();

        for (int i = 0; i < botones.length; i++) {

            JToggleButton boton = botones[i];
            boton.addActionListener(listener -> {
                if (contadorCartas == 2) {
                    java.awt.EventQueue.invokeLater(new Runnable() {

                        @Override
                        public void run() {
                            try {
                                Thread.sleep(1000);
                                // if (cartaAnterior.get(0).getBackground() ==
                                // cartaAnterior.get(1).getBackground()) {
                                if (cartaAnterior.get(0).getIcon().toString()
                                        .equals(cartaAnterior.get(1).getIcon().toString())) {
                                    boton.setVisible(false);
                                    layout.getCarta()[recuperarCartaAnterior()].setVisible(false);
                                    layout.getContador().setText(contadorTexto + aciertoTexto);
                                    contadorParejas++;
                                    if (contadorParejas == 4) {
                                        JOptionPane.showMessageDialog(null,
                                                "Has completado mi desafio querido padawan");
                                    }
                                } else {
                                    // CODIGO PARA LAS CARTAS CON COLORES
                                    boton.setSelected(true);
                                    layout.getCarta()[recuperarCartaAnterior()].setSelected(true);
                                    // CODIGO PARA LAS CARTAS CON IMAGENES
                                    boton.setIcon(null);
                                    layout.getCarta()[recuperarCartaAnterior()].setIcon(null);
                                    contadorIntentos++;
                                    contadorTexto = "Intentos: " + contadorIntentos;
                                    layout.getContador().setText(contadorTexto);
                                }
                                cartaAnterior.removeAll(cartaAnterior);
                                contadorCartas = 1;
                                boton.setEnabled(true);
                                layout.getCarta()[recuperarCartaAnterior()].setEnabled(true);
                            } catch (IllegalArgumentException ex) {
                                ex.printStackTrace();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    });
                }
                cartaAnterior.add(boton);
                // boton.setIcon(layout.asignarCarta(boton));
                // for (int k = 0; k < layout.getCarta().length; k++) {
                //     if (boton.getText().toString().equals(layout.getCarta()[k].getText().toString())) {
                //         layout.asignarCarta(k);
                //     }
                // }
                boton.setEnabled(false);
                contadorCartas++;
            });
        }
    }

    // Metodo para encontrar la primera carta de la lista
    private int recuperarCartaAnterior() {
        int numeroCarta = 0;
        for (int j = 0; j < layout.getCarta().length; j++) {
            if (layout.getCarta()[j].getText().equals(cartaAnterior.get(0).getText())) {
                numeroCarta = j;
            }
        }
        return numeroCarta;
    }
}