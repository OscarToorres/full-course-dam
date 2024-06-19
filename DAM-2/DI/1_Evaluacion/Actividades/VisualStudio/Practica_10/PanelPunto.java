package Practica_10;

import javax.swing.JPanel;
import java.awt.*;

public class PanelPunto extends JPanel {
    
    public PanelPunto(){
    }
    
    public void paintComponent(Graphics g, int lado){  
        g.fillRect(70, 30, lado, lado);
        
    }







    
    
}
