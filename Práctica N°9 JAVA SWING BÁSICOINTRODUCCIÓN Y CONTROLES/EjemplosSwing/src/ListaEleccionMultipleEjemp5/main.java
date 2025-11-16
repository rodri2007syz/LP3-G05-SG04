package ListaEleccionMultipleEjemp5;

import javax.swing.JFrame;

public class main
{
    public static void main(String[] args)
    {
        MarcoSeleccionMultiple marcoSeleccionMultiple = 
            new MarcoSeleccionMultiple();
        marcoSeleccionMultiple.setDefaultCloseOperation(
            JFrame.EXIT_ON_CLOSE);
        marcoSeleccionMultiple.setSize(350, 140);
        marcoSeleccionMultiple.setVisible(true);
    }
}
