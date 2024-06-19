package Practica_09_Eje01;

import java.awt.*;
import javax.swing.*;

public class FraVentana extends JFrame{
    
    private JPanel panelNorte = new JPanel();
    private JPanel panelSur = new JPanel();

    private JButton btnArribaIzda = new JButton("btnArribaIzda");
    private JButton btnArribaDcha = new JButton("btnArribaDcha");
    private JButton btnAbajoIzda = new JButton("btnAbajoIzda");
    private JButton btnAbajoDcha = new JButton("btnAbajoDcha");

    private JToggleButton btnCentro = new JToggleButton();

    public FraVentana(){
        inicioVentana();
        constuccionVentana();
    }

    private void inicioVentana(){
        super.setTitle("Dimensiones y posiciones - Centro - 500x300.");
        setSize(500, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        // setLocationRelativeTo(null); // coloca en el centro
        setLocation(400,200);
    }

    private void constuccionVentana(){
        Container cp = getContentPane();
        BorderLayout bl = new BorderLayout();
        GridLayout gl = new GridLayout(1,2);

        cp.setLayout(bl);


        panelNorte.setLayout(gl);
        panelNorte.add(btnArribaIzda);
        panelNorte.add(btnArribaDcha);
        cp.add(panelNorte, BorderLayout.NORTH);

        panelSur.setLayout(gl);
        panelSur.add(btnAbajoIzda);
        panelSur.add(btnAbajoDcha);
        cp.add(panelSur, BorderLayout.SOUTH);
        
        btnCentro.setText("Aumenta dimension");
        cp.add(btnCentro, BorderLayout.CENTER);
    }

    public JButton getBtnArribaIzda() {
        return btnArribaIzda;
    }

    public void setBtnArribaIzda(JButton btnArribaIzda) {
        this.btnArribaIzda = btnArribaIzda;
    }

    public JButton getBtnArribaDcha() {
        return btnArribaDcha;
    }

    public void setBtnArribaDcha(JButton btnArribaDcha) {
        this.btnArribaDcha = btnArribaDcha;
    }

    public JButton getBtnAbajoIzda() {
        return btnAbajoIzda;
    }

    public void setBtnAbajoIzda(JButton btnAbajoIzda) {
        this.btnAbajoIzda = btnAbajoIzda;
    }

    public JButton getBtnAbajoDcha() {
        return btnAbajoDcha;
    }

    public void setBtnAbajoDcha(JButton btnAbajoDcha) {
        this.btnAbajoDcha = btnAbajoDcha;
    }

    public JToggleButton getBtnCentro() {
        return btnCentro;
    }

    public void setBtnCentro(JToggleButton btnCentro) {
        this.btnCentro = btnCentro;
    }
}