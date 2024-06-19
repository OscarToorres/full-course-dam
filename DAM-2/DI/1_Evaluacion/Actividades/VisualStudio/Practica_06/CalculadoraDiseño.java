package Practica_06;

import java.awt.*;
import java.awt.Container;

import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class CalculadoraDiseño extends JFrame {

    //DECLARACION DE OBJETOS

    //Paneles
    private JPanel panel1 = new JPanel();
    private JPanel panel2 = new JPanel();
    private JPanel panel3 = new JPanel();

    //Desplegable
    private Integer contenidoCaja[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    private JComboBox caja = new JComboBox<Integer>(contenidoCaja);

    //Cajas de texto
    private JTextField txt1 = new JTextField(10);
    private JTextField txt2 = new JTextField(10);
    private JTextField txt3 = new JTextField(10);

    //Botones
    private JButton sumar = new JButton("Sumar");

    //Etiquetas
    private JLabel etq = new JLabel("Tabla de Multiplicar");

    private JLabel[] etq1_30 = new JLabel[30]; 
 

    private JLabel numero1 = new JLabel("Numero1:");
    private JLabel numero2 = new JLabel("Numero2:");
    private JLabel resultado = new JLabel("Resultado");
    
    public CalculadoraDiseño() {

        //Declaracion de la ventana
        super("TREMENDA TABLA DE MULTIPLICAR PA");
        setSize(400,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //Creacion de las etiquetas y su diseño (falta)
        for (int i = 0; i < etq1_30.length;i++) {
            etq1_30[i] = new JLabel();
            etq1_30[i].setHorizontalAlignment(SwingConstants.CENTER);
            etq1_30[i].setBorder(BorderFactory.createLineBorder(Color.GRAY,2));
            etq1_30[i].setBackground(Color.BLACK);

            if (i < 10) {
                etq1_30[i].setText(i + "");
            } else  if (i < 20) {
                etq1_30[i].setText("=");
            }
        }

        //Diseño de la etiqueta de inicio
        etq.setHorizontalAlignment(SwingConstants.CENTER);
        etq.setFont(new Font("Arial", Font.BOLD, 20));

        //Creacion del contenedor
        Container cp = getContentPane();
        BorderLayout bl = new BorderLayout();
        bl.setVgap(10);

        GridLayout gl1 = new GridLayout(2,1);
        gl1.setVgap(10);
        GridLayout gl2 = new GridLayout(10,3);
        gl2.setHgap(10);
        gl2.setVgap(10);

        GridBagLayout gbl = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(5,10,5,10);

        //Aplicar el layout al container
        cp.setLayout(bl);
        
        //Aplicacion de los objetos al BorderLayout (NORTH)
        //Declaracion del layout al panel1
        panel1.setLayout(gl1);
        //Añadir los objetos al panel
        panel1.add(etq);
        panel1.add(caja);
        //Añadir el panel al container
        cp.add(panel1, BorderLayout.NORTH);

        //Aplicacion de los objetos al BorderLayout (CENTER)
        //Declaracion del layout al panel2
        panel2.setLayout(gl2);
        //Añadir los objetos al panel
        panel2.add(etq1_30[0]);
        panel2.add(etq1_30[10]);
        panel2.add(etq1_30[20]);
        panel2.add(etq1_30[1]);
        panel2.add(etq1_30[11]);
        panel2.add(etq1_30[21]);
        panel2.add(etq1_30[2]);
        panel2.add(etq1_30[12]);
        panel2.add(etq1_30[22]);
        panel2.add(etq1_30[3]);
        panel2.add(etq1_30[13]);
        panel2.add(etq1_30[23]);
        panel2.add(etq1_30[4]);
        panel2.add(etq1_30[14]);
        panel2.add(etq1_30[24]);
        panel2.add(etq1_30[5]);
        panel2.add(etq1_30[15]);
        panel2.add(etq1_30[25]);
        panel2.add(etq1_30[6]);
        panel2.add(etq1_30[16]);
        panel2.add(etq1_30[26]);
        panel2.add(etq1_30[7]);
        panel2.add(etq1_30[17]);
        panel2.add(etq1_30[27]);
        panel2.add(etq1_30[8]);
        panel2.add(etq1_30[18]);
        panel2.add(etq1_30[28]);
        panel2.add(etq1_30[9]);
        panel2.add(etq1_30[19]);
        panel2.add(etq1_30[29]);
        //Añadir el panel al container
        cp.add(panel2, BorderLayout.CENTER);

        //Declaracion del layout a panel3
        panel3.setLayout(gbl);

        //Añadir los Objetos al panel
        gbc.gridx = 0; //El label esta en la columna cero
        gbc.gridy = 0; //El label esta en la fila cero
        gbc.gridheight = 1; //El label ocupa 1 fila 
        gbc.gridwidth = 1; //El label ocupa 1 columna
        //Definida la posicion se añade el objeto al lienzo
        panel3.add(numero1, gbc);

        gbc.gridx = 0; //El label esta en la columna cero
        gbc.gridy = 1; //El label esta en la fila uno
        gbc.gridheight = 1; //El label ocupa 1 fila 
        gbc.gridwidth = 1; //El label ocupa 1 columna
        //Definida la posicion se añade el objeto al lienzo
        panel3.add(numero2, gbc);

        gbc.gridx = 0; //El label esta en la columna cero
        gbc.gridy = 2; //El label esta en la fila dos
        gbc.gridheight = 1; //El label ocupa 1 fila 
        gbc.gridwidth = 1; //El label ocupa 1 columna
        //Definida la posicion se añade el objeto al lienzo
        panel3.add(resultado, gbc);

        gbc.gridx = 1; //El label esta en la columna uno
        gbc.gridy = 0; //El label esta en la fila cero
        gbc.gridheight = 1; //El label ocupa 1 fila 
        gbc.gridwidth = 1; //El label ocupa 1 columna
        //Definida la posicion se añade el objeto al lienzo
        panel3.add(txt1, gbc);

        gbc.gridx = 1; //El label esta en la columna uno
        gbc.gridy = 1; //El label esta en la fila uno
        gbc.gridheight = 1; //El label ocupa 1 fila 
        gbc.gridwidth = 1; //El label ocupa 1 columna
        //Definida la posicion se añade el objeto al lienzo
        panel3.add(txt2, gbc);

        gbc.gridx = 1; //El label esta en la columna uno
        gbc.gridy = 2; //El label esta en la fila dos
        gbc.gridheight = 1; //El label ocupa 1 fila 
        gbc.gridwidth = 1; //El label ocupa 1 columna
        //Definida la posicion se añade el objeto al lienzo
        panel3.add(txt3, gbc);

        gbc.weightx = 1;
        gbc.gridx = 2; //El label esta en la columna dos
        gbc.gridy = 0; //El label esta en la fila cero
        gbc.gridheight = 3; //El label ocupa 3 filas 
        gbc.gridwidth = 2; //El label ocupa 2 columnas
        //Definida la posicion se añade el objeto al lienzo
        panel3.add(sumar, gbc);

        //Añadir el panel al contenedor
        cp.add(panel3, BorderLayout.SOUTH);
        
        sumar.addActionListener(new CalculadoraManejadorEventos(this));
        caja.addActionListener(new CalculadoraManejadorEventos(this));
        txt2.addActionListener(new CalculadoraManejadorEventos(this));
    }

    public Integer[] getContenidoCaja() {
        return contenidoCaja;
    }

    public void setContenidoCaja(Integer[] contenidoCaja) {
        this.contenidoCaja = contenidoCaja;
    }

    public JComboBox getCaja() {
        return caja;
    }

    public void setCaja(JComboBox caja) {
        this.caja = caja;
    }

    public JTextField getTxt1() {
        return txt1;
    }

    public void setTxt1(JTextField txt1) {
        this.txt1 = txt1;
    }

    public JTextField getTxt2() {
        return txt2;
    }

    public void setTxt2(JTextField txt2) {
        this.txt2 = txt2;
    }

    public JTextField getTxt3() {
        return txt3;
    }

    public void setTxt3(JTextField txt3) {
        this.txt3 = txt3;
    }

    public JButton getSumar() {
        return sumar;
    }

    public void setSumar(JButton sumar) {
        this.sumar = sumar;
    }

    public JLabel getEtq() {
        return etq;
    }

    public void setEtq(JLabel etq) {
        this.etq = etq;
    }

    public JLabel[] getEtq1_30() {
        return etq1_30;
    }

    public void setEtq1_30(JLabel[] etq1_30) {
        this.etq1_30 = etq1_30;
    }

    public JLabel getNumero1() {
        return numero1;
    }

    public void setNumero1(JLabel numero1) {
        this.numero1 = numero1;
    }

    public JLabel getNumero2() {
        return numero2;
    }

    public void setNumero2(JLabel numero2) {
        this.numero2 = numero2;
    }

    public JLabel getResultado() {
        return resultado;
    }

    public void setResultado(JLabel resultado) {
        this.resultado = resultado;
    }

    
}