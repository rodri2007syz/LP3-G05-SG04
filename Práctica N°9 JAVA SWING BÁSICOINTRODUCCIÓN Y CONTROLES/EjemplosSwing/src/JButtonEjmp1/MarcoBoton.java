package JButtonEjmp1;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class MarcoBoton extends JFrame {
	private final JButton BTSimple;  //boton simple
	private JButton BTImagen;
	
	public MarcoBoton() {
		super("Huanqui , Rodrigo ");
		setLayout(new FlowLayout());
		
		BTSimple = new JButton("Boton simple"); 
		add(BTSimple);
		
		Icon imagen1 = new ImageIcon(getClass().getResource("gato1.gif"));
		Icon imagen2 = new ImageIcon(getClass().getResource("gato2.gif"));
		
		BTImagen = new JButton("Boton elegante",imagen1);
		
		
		BTImagen.setRolloverIcon(imagen2);
		add(BTImagen);
		
		ManejadorBoton manejador = new ManejadorBoton();
		BTImagen.addActionListener(manejador);
		BTSimple.addActionListener(manejador);
	} 
	
	//clase que maneja eentos del boton
	private class ManejadorBoton implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent evento) {
			JOptionPane.showMessageDialog(MarcoBoton.this, String.format("Usted oprimio: %s" , evento.getActionCommand()));
		}
	}
}


