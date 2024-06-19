package RepasoExamen;

import javax.swing.JButton;

public class ColoresControlador {
    
    public ColoresControlador(){
        ColoresLayout layout = new ColoresLayout();
        layout.setVisible(true);

        JButton[] botones = layout.botonesColores;

        for(int i = 0; i < botones.length; i++){
            JButton boton = botones[i];
            boton.addActionListener(listener ->{
                layout.cp.setBackground(boton.getBackground());
            });
        }
    }

    public static void main(String[] args) {
        new ColoresControlador();
    }
}