package Graficos2D;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;

public class AppGraficos2D extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        

        Graphics2D g2d = (Graphics2D) g;
        

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        // Definimos el color 
        g2d.setColor(Color.GRAY);
        int rectWidth = 100;
        int rectHeight = 50;
        g2d.fillRect(50, 50, rectWidth, rectHeight);
        
        // Guardamos el estado original
        AffineTransform originalTransform = g2d.getTransform();
        
        // Traslacion
        g2d.translate(200, 0); // 200 px derecha
        g2d.setColor(Color.BLUE);
        g2d.fillRect(50, 50, rectWidth, rectHeight);
        
        //forma original
        g2d.setTransform(originalTransform);
        
        // Rotacion
        g2d.translate(0, 150); //abajo
        g2d.rotate(Math.toRadians(45), 100, 75); // 45 grad
        g2d.setColor(Color.GREEN);
        g2d.fillRect(50, 90, rectWidth, rectHeight);
        
        // original
        g2d.setTransform(originalTransform);
        
        // Escalado
        g2d.translate(200, 150); // derecha y abajo
        g2d.scale(1.5, 0.5); // Escala 1.5x en X y 0.5x en Y
        g2d.setColor(Color.ORANGE);
        g2d.fillRect(50, 50, rectWidth, rectHeight);
        
        // original
        g2d.setTransform(originalTransform);
        
        // Sesgado (Shear)
        g2d.translate(0, 300); 
        g2d.shear(0.5, 0);
        g2d.setColor(Color.MAGENTA);
        g2d.fillRect(50, 50, rectWidth, rectHeight);
        
        g2d.setTransform(originalTransform);
    }
    
    public static void main(String[] args) {
        JFrame frame = new JFrame("Ejemplo de Transformaciones con Graphics2D");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        
        // Añadimos el panel de dibujo al frame
        frame.add(new AppGraficos2D());
        frame.setVisible(true);
    }
}
