package Practica_08_Ejercicio1;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButtonMenuItem;

public class ControladorMenus {

    public void controlador() {
        DiseñoMenus menu = new DiseñoMenus();
        menu.setVisible(true);

        JRadioButtonMenuItem[] colores = menu.getItemsColores();
        JRadioButtonMenuItem[] coloresFondo = menu.getItemsColoresFondo();
        JRadioButtonMenuItem[] tipos = menu.getItemsTipo();
        JCheckBoxMenuItem[] estilos = menu.getItemsEstilo();
        JMenuItem salir = menu.getItem12();
        JMenuItem acercaDe = menu.getItem11();

        // CONTROLADOR DE COLORES
        for (int i = 0; i < colores.length; i++) {
            JRadioButtonMenuItem color = colores[i];
            color.addActionListener(listener -> {
                if (menu.getItemsColores()[0].isSelected()) {
                    menu.getTexto().setForeground(Color.BLACK);
                } else if (menu.getItemsColores()[1].isSelected()) {
                    menu.getTexto().setForeground(Color.BLUE);
                } else if (menu.getItemsColores()[2].isSelected()) {
                    menu.getTexto().setForeground(Color.RED);
                } else if (menu.getItemsColores()[3].isSelected()) {
                    menu.getTexto().setForeground(Color.GREEN);
                }
            });
        }
        // CONTROLADOR DE COLORES DE FONDO
        for (int i = 0; i < coloresFondo.length; i++) {
            JRadioButtonMenuItem color = coloresFondo[i];
            color.addActionListener(listener -> {
                if (menu.getItemsColoresFondo()[0].isSelected()) {
                    menu.getContentPane().setBackground(Color.BLACK);
                } else if (menu.getItemsColoresFondo()[1].isSelected()) {
                    menu.getContentPane().setBackground(Color.BLUE);
                } else if (menu.getItemsColoresFondo()[2].isSelected()) {
                    menu.getContentPane().setBackground(Color.RED);
                } else if (menu.getItemsColoresFondo()[3].isSelected()) {
                    menu.getContentPane().setBackground(Color.GREEN);
                }
            });
        }
        // CONTROLADOR DE TIPOS
        for (int i = 0; i < tipos.length; i++) {
            JRadioButtonMenuItem tipo = tipos[i];
            Integer style = menu.getTexto().getFont().getStyle();
            Integer size = menu.getTexto().getFont().getSize();
            tipo.addActionListener(listener -> {
                if (menu.getItemsTipo()[0].isSelected()) {
                    Font fuente = new Font("Serif", style, size);
                    menu.getTexto().setFont(fuente);
                } else if (menu.getItemsTipo()[1].isSelected()) {
                    Font fuente = new Font("Monospaced", style, size);
                    menu.getTexto().setFont(fuente);
                } else if (menu.getItemsTipo()[2].isSelected()) {
                    Font fuente = new Font("Sans Serif", style, size);
                    menu.getTexto().setFont(fuente);
                }
            });
        }
        // CONTROLADOR DE ESTILOS
        for (int i = 0; i < estilos.length; i++) {
            JCheckBoxMenuItem estilo = estilos[i];
            estilo.addActionListener(listener -> {
                if (menu.getItemsEstilo()[0].isSelected() == true && menu.getItemsEstilo()[1].isSelected() == false) {
                    Font fuente = menu.getTexto().getFont().deriveFont(1);
                    menu.getTexto().setFont(fuente);
                } else if (menu.getItemsEstilo()[1].isSelected() == true && menu.getItemsEstilo()[0].isSelected() == false) {
                    Font fuente = menu.getTexto().getFont().deriveFont(2);
                    menu.getTexto().setFont(fuente);
                } else if (menu.getItemsEstilo()[0].isSelected() == true && menu.getItemsEstilo()[1].isSelected() == true) {
                    Font fuente = menu.getTexto().getFont().deriveFont(3);
                    menu.getTexto().setFont(fuente);
                } else if (menu.getItemsEstilo()[0].isSelected() == false && menu.getItemsEstilo()[1].isSelected() == false) {
                    Font fuente = menu.getTexto().getFont().deriveFont(0);
                    menu.getTexto().setFont(fuente);
                }
            });
        }
        // CONTROLADOR DE SALIR
        salir.addActionListener(listener -> {
            System.out.println("Entra en salir");
            System.exit(-1);
        });

        acercaDe.addActionListener(listener -> {
            JOptionPane.showMessageDialog(null,"Esta aplicacion fue desarrollada por Oscar Torres durante las clases de DI");
        });
    }
}