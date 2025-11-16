package MarcoBorderLayou;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JButton;

public class MarcoBorderLayout extends JFrame implements ActionListener
{
 private final JButton botones[];
 private static final String nombres[] = {"Ocultar Norte", "Ocultar Sur",
     "Ocultar Este", "Ocultar Oeste", "Ocultar Centro"};
 private final BorderLayout esquema;

  public MarcoBorderLayout()
 {
     super("Huanqui , Rodrigo de BorderLayout");

     esquema = new BorderLayout(5, 5); // espacios de 5 píxeles
     setLayout(esquema);
     botones = new JButton[nombres.length];

     for (int cuenta = 0; cuenta < nombres.length; cuenta++)
     {
         botones[cuenta] = new JButton(nombres[cuenta]);
         botones[cuenta].addActionListener(this);
     }

     add(botones[0], BorderLayout.NORTH);  // Norte (arriba)
     add(botones[1], BorderLayout.SOUTH);  // Sur (abajo)
     add(botones[2], BorderLayout.EAST);   // Este (derecha)
     add(botones[3], BorderLayout.WEST);   // Oeste (izquierda)
     add(botones[4], BorderLayout.CENTER); // Centro
 }


 @Override
 public void actionPerformed(ActionEvent evento)
 {

     for (JButton boton : botones)
     {
         if (evento.getSource() == boton)
             boton.setVisible(false); 
         else
             boton.setVisible(true);
     }

     esquema.layoutContainer(getContentPane());
 }
 

 public static void main(String[] args)
 {
     MarcoBorderLayout marcoBorderLayout = new MarcoBorderLayout();
     marcoBorderLayout.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     marcoBorderLayout.setSize(300, 200);
     marcoBorderLayout.setVisible(true);
 }
}
