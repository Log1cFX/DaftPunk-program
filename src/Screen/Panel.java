package Screen;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JPanel;

public class Panel extends JPanel implements ActionListener {
	ArrayList<CustomButton> buttonArray = new ArrayList<>();
	
	Panel() {
		// this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
		this.setBackground(Color.BLACK);
		this.setFocusable(true);
		this.setLayout(new GridLayout(4,5,10,10));
		addButtons();
		buttonArray.forEach(b -> this.add(b));
		buttonArray.forEach(b -> b.addActionListener(this));
		startAudio();
		//startPeriodicTask();
	}

	private void addButtons() {
		buttonArray.add(new CustomButton("work it"));
		buttonArray.add(new CustomButton("make it"));
		buttonArray.add(new CustomButton("do it"));
		buttonArray.add(new CustomButton("make us"));
		buttonArray.add(new CustomButton("harder"));
		buttonArray.add(new CustomButton("better"));
		buttonArray.add(new CustomButton("faster"));
		buttonArray.add(new CustomButton("stronger"));
		buttonArray.add(new CustomButton("more than"));
		buttonArray.add(new CustomButton("hour"));
		buttonArray.add(new CustomButton("our"));
		buttonArray.add(new CustomButton("never"));
		buttonArray.add(new CustomButton("ever"));
		buttonArray.add(new CustomButton("after"));
		buttonArray.add(new CustomButton("work is"));
		buttonArray.add(new CustomButton("over"));
	}

	public void playSound(String name) {
		try {
			Clip clip = AudioSystem.getClip();
			File file = new File("ressources/" + name + ".wav");
			AudioInputStream inputStream = AudioSystem.getAudioInputStream(file);
			clip.open(inputStream);
			clip.start();
		} catch (LineUnavailableException | UnsupportedAudioFileException | IOException e) {
			e.printStackTrace();
		}
	}

	public void paintComponent(Graphics g) {
		((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		super.paintComponent(g);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for (CustomButton a : buttonArray) {
			if (a.getText() == e.getActionCommand()) {
				playSound(a.getText());
			}
		}
	}
}
