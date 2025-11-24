package codigo;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class reproductorSonidos {
	private Clip clip;
	
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
		if(clip != null) {
			clip.setFramePosition(0);
			clip.start();
		}
	}
	
	
	public void detener() {
		if(clip != null && clip.isRunning()) {
			clip.stop();
		}
	}
	
	
}

class ventana extends JFrame{
	private reproductorSonidos Reproductor;
	
	public ventana() {
		setTitle("Huanqui Y Sanchez || Sonido de animales");
		setSize(300,300);
		JPanel panel = new JPanel();
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		Reproductor = new reproductorSonidos();
		
		//boton aplauso
		ImageIcon iconoAplauso = new ImageIcon("src/imagenes/aplauso.png");//aqui va aplausos
		Image OriIconoAplauso = iconoAplauso.getImage();
		Image NuevaEscalaIconoAplauso = OriIconoAplauso.getScaledInstance(50,50 ,Image.SCALE_SMOOTH);
		iconoAplauso = new ImageIcon(NuevaEscalaIconoAplauso);
		///
		JButton botonAplauso = new JButton("Aplauso", iconoAplauso); //Boton aplauso
		botonAplauso.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Reproductor.cargarSonido("src/sonidos/AplausosAUD.wav");
				Reproductor.reproducir();
				
			}
		});
		
		//boton campana
		ImageIcon iconoCampana = new ImageIcon("src/imagenes/campana.png");//aqui va campana
		Image OriIconoCampana = iconoCampana.getImage();
		Image NuevaEscalaIconoCampana = OriIconoCampana.getScaledInstance(50,50 ,Image.SCALE_SMOOTH);
		iconoCampana = new ImageIcon(NuevaEscalaIconoCampana);
		
		JButton botonCampana = new JButton("Campana", iconoCampana); //Boton campana
		botonCampana.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Reproductor.cargarSonido("src/sonidos/Campana.wav");
				Reproductor.reproducir();
				
			}
		});
		
		
		//boton Explosion epica
				ImageIcon iconoExplosion  = new ImageIcon("src/imagenes/explosion.png");
				Image OriIconoExplosion  = iconoExplosion .getImage();
				Image NuevaEscalaIconoExplosion  = OriIconoExplosion.getScaledInstance(50,50 ,Image.SCALE_SMOOTH);
				iconoExplosion  = new ImageIcon(NuevaEscalaIconoExplosion);
				
				JButton botonExplosion  = new JButton("Explosion ", iconoExplosion );
				botonExplosion .addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						Reproductor.cargarSonido("src/sonidos/explosion.wav");
						Reproductor.reproducir();
						
					}
				});
		
		
				
				
		panel.add(botonAplauso);
		panel.add(botonCampana);
		panel.add(botonExplosion);
		add(panel);
		
		setVisible(true);
		
	}
	
	
}
