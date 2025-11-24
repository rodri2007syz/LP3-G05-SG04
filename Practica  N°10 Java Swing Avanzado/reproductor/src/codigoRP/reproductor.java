package codigoRP;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class reproductor{
	private Clip clip;
	private long posicionM= 0;
	
	
	public void cargarSonido(String ruta) {
		try {
			File archivoSonido = new File(ruta);
			AudioInputStream audioAudioInputStream = AudioSystem.getAudioInputStream(archivoSonido);
			clip = AudioSystem.getClip();
			clip.open(audioAudioInputStream);
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void reproducir() {
		if(clip != null ) {

			clip.setFramePosition(0);
			clip.start();
							
			}
		}

	
	public void pausar() {
		if(clip != null && clip.isRunning()) {
			posicionM = clip.getMicrosecondPosition();
			clip.stop();
		}
	}
	
	public void reanudar() {
		if(clip != null && !clip.isRunning()) {
			if(posicionM > 0) {
			clip.setMicrosecondPosition(posicionM);
			clip.start();
			}
		}
	}
	

}

class Ventana extends JFrame{
	private reproductor rp;
	
	public Ventana() {			
		setTitle("Reproductor musical");
		setSize(500,100);
		JPanel panel = new JPanel();
		rp = new reproductor();
		rp.cargarSonido("src/musica/AREA21-No-Angel.wav");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		panel.setLayout(new FlowLayout(FlowLayout.CENTER));
		

		
		JButton BOTON1 = new JButton("Play");
		BOTON1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				rp.reproducir();
				
			}
		});
		
		
		JButton BOTON2 = new JButton("Pausa");
		BOTON2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				rp.pausar();
			}
		});
		
		JButton BOTON3 = new JButton("Reanudar");
		BOTON3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				rp.reanudar();
				
			}
		});
		
		
		panel.add(BOTON1);
		panel.add(BOTON2);
		panel.add(BOTON3);
		add(panel);

		setLocale(null);
		setVisible(true);
		
		
		
	
	}
	
}
