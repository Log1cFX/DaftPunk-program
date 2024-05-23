package Screen;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JPanel;

public class AudioControlPanel extends JPanel implements ActionListener{
	ArrayList<CustomButton> buttonArray = new ArrayList<>();
	Clip clip;
	AudioControlPanel(Clip clip) {
		startAudio();
		addButton();
		buttonArray.forEach(b -> this.add(b));
		buttonArray.forEach(b -> b.addActionListener(this));
	}
	
	void startAudio() {
		try {
			clip = AudioSystem.getClip();
			File file = new File("ressources/Harder_Better_Faster_Stronger_Instrumental.wav");
			AudioInputStream inputStream = AudioSystem.getAudioInputStream(file);
			clip.open(inputStream);
			clip.start();
		} catch (LineUnavailableException | UnsupportedAudioFileException | IOException e) {
			e.printStackTrace();
		}
	}
	
	private void addButton() {
		buttonArray.add(new CustomButton("work it"));
	}
	public void paintComponent(Graphics g) {
		((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		super.paintComponent(g);
	}

	private void perfomAudioAction(String text) {
		speedChange(1.5);
	}
	
	private void speedChange(Double speed) {
		clip.
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		for (CustomButton a : buttonArray) {
			if (a.getText() == e.getActionCommand()) {
				perfomAudioAction(a.getText());
			}
		}
	}
}
