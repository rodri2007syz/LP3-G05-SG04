package JCheckBoxEjmp2;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JCheckBox;

public class MarcoCasillaVerificacion  extends JFrame{

	private JTextField campoTexto;
	private JCheckBox negritaJCheckBox;
	private JCheckBox cursivaCheckBox;
	
	
	public MarcoCasillaVerificacion() {
		
		super("Huanqui , Rodrigo JCheckBox");
		setLayout(new FlowLayout());
		
		
		//establecres el jtexfield y su tipo de letra
		campoTexto = new JTextField("Obsera como cambia el estilo de tipo de letra ",20);
		campoTexto.setFont(new Font("Serif", Font.PLAIN, 14));
		add(campoTexto);
		
		
		negritaJCheckBox = new JCheckBox("Nerita");
		cursivaCheckBox = new JCheckBox("Cursiva");
		
		add(negritaJCheckBox);
		add(cursivaCheckBox);
		
		
		//registro dde escuchas para objetos Jcheckbox
		ManejadorCheckBox manejador = new ManejadorCheckBox();
		negritaJCheckBox.addItemListener(manejador);
		cursivaCheckBox.addItemListener(manejador);	
	}
	
	private class ManejadorCheckBox implements ItemListener{
		@Override
		public void itemStateChanged(ItemEvent evento) {
			Font tipoletra;
			
			if(negritaJCheckBox.isSelected() && cursivaCheckBox.isSelected())
				tipoletra = new Font("Serif",Font.BOLD+ Font.ITALIC,14);
			else if(negritaJCheckBox.isSelected())
				tipoletra = new Font("Serif",Font.BOLD , 14);
			else if(cursivaCheckBox.isSelected())
				tipoletra = new Font("Serif",Font.ITALIC,14);
			else
				tipoletra = new Font("Serif",Font.PLAIN, 14); 
			
			campoTexto.setFont(tipoletra); ///<------
			}
		
		
	}

}
