package FlowLayout;

import javax.swing.JFrame;


public class main {
    public static void main(String[] args) {
        MarcoFlowLayout marcoFlowLayout = new MarcoFlowLayout();
        marcoFlowLayout.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marcoFlowLayout.setSize(550, 250); // Tamaño ajustado para visualizar los controles y el panel de demo
        marcoFlowLayout.setVisible(true);
    }
}