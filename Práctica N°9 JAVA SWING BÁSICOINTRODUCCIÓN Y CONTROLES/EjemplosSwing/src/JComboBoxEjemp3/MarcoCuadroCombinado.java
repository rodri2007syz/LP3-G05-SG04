package JComboBoxEjemp3;
import java.awt.FlowLayout;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class MarcoCuadroCombinado extends JFrame{

	private final JComboBox<String> imageneCB; // contendra el nombre de los iconos
	private final JLabel etiqueta;//mostrara el icono seleccionado
	
	private static final String nombres[] = 
		{"imagen1","imagen2","imagen3","imagen4"};
	private final Icon[] iconos = {
		new ImageIcon(getClass().getResource("imagen1.jpg")),
		new ImageIcon(getClass().getResource("imagen2.jpg")),
		new ImageIcon(getClass().getResource("imagen3.jpg")),
		new ImageIcon(getClass().getResource("imagen4.jpg"))};
	
	public MarcoCuadroCombinado() {
		super("Huanqui , Rodrigo JComboBox");
		setLayout(new FlowLayout()); // esquema dde marco
		
		imageneCB = new JComboBox<String>(nombres);
		imageneCB.setMaximumRowCount(3); // 3 filas
		
		imageneCB.addItemListener(
				new ItemListener() {
					
					@Override
					public void itemStateChanged(ItemEvent evento) {
						//determinar si esta seleccionado el elemento
						if(evento.getStateChange()==ItemEvent.SELECTED)
							etiqueta.setIcon(iconos[
							                        imageneCB.getSelectedIndex()]);
					}
				}
			);
		add(imageneCB);
		etiqueta = new JLabel(iconos[0]);
		add(etiqueta);
	}
}



