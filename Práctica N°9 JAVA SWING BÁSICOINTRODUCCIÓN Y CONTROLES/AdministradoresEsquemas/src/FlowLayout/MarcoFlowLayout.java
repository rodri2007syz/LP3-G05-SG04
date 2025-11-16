package FlowLayout;

import java.awt.FlowLayout;
import java.awt.Container;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JButton;

public class MarcoFlowLayout extends JFrame
{
 private final JButton botonJButtonIzquierda; 
 private final JButton botonJButtonCentro; 
 private final JButton botonJButtonDerecha; 
 private final FlowLayout esquema; 
 private final Container contenedor; // establecer el esquema

 public MarcoFlowLayout()
 {
     super("Huanqui , Rodrigo funcionamiento de FlowLayout");

     esquema = new FlowLayout();
     contenedor = getContentPane();
     setLayout(esquema);

     // establece botonJButtonIzquierda 
     botonJButtonIzquierda = new JButton("Izquierda");
     add(botonJButtonIzquierda); //
     botonJButtonIzquierda.addActionListener(
         new ActionListener() // clase interna 
         {

             @Override
             public void actionPerformed(ActionEvent evento)
             {
                 esquema.setAlignment(FlowLayout.LEFT);

                 esquema.layoutContainer(contenedor);
             }
         }
     );

     botonJButtonCentro = new JButton("Centro");
     add(botonJButtonCentro); 
     botonJButtonCentro.addActionListener(
         new ActionListener()
         {
             // procesa evento de botonJButtonCentro
             @Override
             public void actionPerformed(ActionEvent evento)
             {
                 esquema.setAlignment(FlowLayout.CENTER);


                 esquema.layoutContainer(contenedor);
             }
         }
     );


     botonJButtonDerecha = new JButton("Derecha");
     add(botonJButtonDerecha);
     botonJButtonDerecha.addActionListener(
         new ActionListener()
         {

             @Override
             public void actionPerformed(ActionEvent evento)
             {
                 esquema.setAlignment(FlowLayout.RIGHT);


                 esquema.layoutContainer(contenedor);
             }
         }
     );
 }

 public static void main(String[] args)
 {
     MarcoFlowLayout marcoFlowLayout = new MarcoFlowLayout();
     marcoFlowLayout.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     marcoFlowLayout.setSize(300, 75);
     marcoFlowLayout.setVisible(true);
 }
}