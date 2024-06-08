package com.ladoc.raffi.daft_punk;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JPanel;

public class Panel extends JPanel implements ActionListener {
	ArrayList<CustomButton> buttonArray = new ArrayList<>();
	Image bg;

	Panel() {
		try {
			bg = ImageIO.read(this.getClass().getResourceAsStream("/daft_punk.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.setFocusable(true);
		this.setLayout(new GridLayout(4, 5, 10, 10));
		addButtons();
		buttonArray.forEach(b -> this.add(b));
		buttonArray.forEach(b -> b.addActionListener(this));
		// startPeriodicTask();
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
			InputStream rawInputStream = getClass().getResourceAsStream("/"+name+".wav");
			BufferedInputStream inputStream = new BufferedInputStream(rawInputStream);
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(inputStream);
			clip.open(audioInputStream);
			clip.start();
		} catch (LineUnavailableException | UnsupportedAudioFileException | IOException e) {
			e.printStackTrace();
		}
	}

	public void paintComponent(Graphics g) {
		((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		super.paintComponent(g);
		g.drawImage(bg, 0, 0, getWidth(), getHeight(), null);
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
