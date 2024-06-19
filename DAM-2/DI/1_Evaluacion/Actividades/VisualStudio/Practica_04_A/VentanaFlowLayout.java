import javax.swing.*;

public class VentanaFlowLayout extends JFrame{
    private JPanel panel = new JPanel();

    //Definir elementos del panel
    private JTextField texto1 = new JTextField(8);
    private JTextField texto2 = new JTextField(8);
    private JTextField texto3 = new JTextField(8);
    private JTextField texto4 = new JTextField(8);

    private JButton boton1 = new JButton("Comprobar");
    private JButton boton2 = new JButton("Salir");

    private JLabel etiqueta1 = new JLabel("Soy una etiqueta ;)");

    public VentanaFlowLayout() {
        super("Practica_04");
        setSize(600,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Añadimos los elementos al panel
        panel.add(texto1);     
        panel.add(texto2);
        panel.add(texto3);
        panel.add(texto4);
        panel.add(etiqueta1);
        panel.add(boton1);
        panel.add(boton2);

        //Establecemos el panel en mi Contenedor
        setContentPane(panel);

        //Añadir al escuchador
        boton1.addActionListener(new VentanaFlowControlador(this));
        boton2.addActionListener(new VentanaFlowControlador(this));
    }

    public JTextField getTexto1() {
        return texto1;
    }

    public void setTexto1(JTextField texto1) {
        this.texto1 = texto1;
    }

    public JTextField getTexto2() {
        return texto2;
    }

    public void setTexto2(JTextField texto2) {
        this.texto2 = texto2;
    }

    public JTextField getTexto3() {
        return texto3;
    }

    public void setTexto3(JTextField texto3) {
        this.texto3 = texto3;
    }

    public JTextField getTexto4() {
        return texto4;
    }

    public void setTexto4(JTextField texto4) {
        this.texto4 = texto4;
    }

    public JButton getBoton1() {
        return boton1;
    }

    public void setBoton1(JButton boton1) {
        this.boton1 = boton1;
    }

    public JButton getBoton2() {
        return boton2;
    }

    public void setBoton2(JButton boton2) {
        this.boton2 = boton2;
    }

    public JLabel getEtiqueta1() {
        return etiqueta1;
    }

    public void setEtiqueta1(JLabel etiqueta1) {
        this.etiqueta1 = etiqueta1;
    }

    
}