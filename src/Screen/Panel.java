package Screen;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Panel extends JPanel {
	private static final int SCREEN_WIDTH = 800;
	private static final int SCREEN_HEIGHT = 400;
	private int YgridSize = SCREEN_HEIGHT / 7;
	private int XgridSize = SCREEN_WIDTH / 7;

	Panel() {
		this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
		this.setBackground(Color.BLACK);
		this.setFocusable(true);
		startAudio();
	}
	
	void startAudio() {
		new Thread(new Runnable() {
			// The wrapper thread is unnecessary, unless it blocks on the
			// Clip finishing; see comments.
			public void run() {
				try {
					Clip clip = AudioSystem.getClip();
					File file = new File("ressources/Harder_Better_Faster_Stronger_Instrumental.wav");
					AudioInputStream inputStream = AudioSystem.getAudioInputStream(file);
					clip.open(inputStream);
					clip.start();
				} catch (LineUnavailableException | UnsupportedAudioFileException | IOException e) {
					e.printStackTrace();
				}
			}
		}).start();
	}

	public void playSound(int index) {
		switch(index) {
		case 0 : 
		}
	}
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
	}
}
