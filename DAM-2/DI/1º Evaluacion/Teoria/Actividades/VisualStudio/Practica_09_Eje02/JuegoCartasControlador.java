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
    }

    public void Controlador() {
        layout = new JuegoCartasLayout();
        layout.setVisible(true);

        JToggleButton[] botones = layout.getCarta();

        for (int i = 0; i < botones.length; i++) {

            JToggleButton boton = botones[i];
            boton.addActionListener(listener -> {
                System.out.println(contadorCartas);
                System.out.println("Carta seleccionada: " + boton.getText());
                System.out.println("Estado de la carta seleccionada: " + boton.isSelected());
                if (contadorCartas == 2) {
                    System.out.println("Entra en el if");
                    java.awt.EventQueue.invokeLater(new Runnable() {

                        @Override
                        public void run() {
                            try {
                                System.out.println("Se duerme");
                                Thread.sleep(1000);
                                if (cartaAnterior.get(0).getBackground() == cartaAnterior.get(1).getBackground()) {

                                    System.out.println("Acertaste");
                                    boton.setVisible(false);
                                    layout.getCarta()[recuperarCartaAnterior()].setVisible(false);
                                    layout.getContador().setText(contadorTexto + aciertoTexto);
                                    contadorParejas++;
                                    if (contadorParejas == 4) {
                                        JOptionPane.showMessageDialog(null, "Has completado mi desafio querido padawan");   
                                    }
                                } else {
                                    System.out.println("fallaste");
                                    boton.setSelected(true);
                                    System.out.println("Entra a encontrar la carta");
                                    layout.getCarta()[recuperarCartaAnterior()].setSelected(true);
                                    contadorIntentos++;
                                    contadorTexto = "Intentos: " + contadorIntentos;
                                    layout.getContador().setText(contadorTexto);
                                }
                                System.out.println("Eliminar la lista");
                                cartaAnterior.removeAll(cartaAnterior);
                                System.out.println(contadorCartas);
                                contadorCartas = 1;
                            } catch (IllegalArgumentException ex) {
                                ex.printStackTrace();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    });
                }
                cartaAnterior.add(boton);
                System.out.println("Carta pulsada guardada");
                for (int j = 0; j < cartaAnterior.size(); j++) {
                    System.out.println(cartaAnterior.get(j).getText());
                }
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

    public ArrayList<JToggleButton> getCartaAnterior() {
        return cartaAnterior;
    }

    public void setCartaAnterior(ArrayList<JToggleButton> cartaAnterior) {
        this.cartaAnterior = cartaAnterior;
    }
}