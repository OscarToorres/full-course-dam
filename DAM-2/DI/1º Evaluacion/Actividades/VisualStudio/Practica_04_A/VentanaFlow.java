import javax.swing.*;

public class VentanaFlow extends JFrame{
    JPanel panel = new JPanel();

    //Definir elementos del panel
    JTextField texto1 = new JTextField(8);
    JTextField texto2 = new JTextField(8);
    JTextField texto3 = new JTextField(8);
    JTextField texto4 = new JTextField(8);

    JButton boton1 = new JButton("Comprobar");
    JButton boton2 = new JButton("Salir");

    JLabel etiqueta1 = new JLabel("Soy una etiqueta ;)");

    public VentanaFlow() {
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
        boton1.addActionListener(new VentanaFlowTest(this));
        boton2.addActionListener(new VentanaFlowTest(this));
    }
}