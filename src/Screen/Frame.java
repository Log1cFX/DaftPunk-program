package Screen;

import java.awt.BorderLayout;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;

public class Frame extends JFrame{
	Frame(){
		this.setResizable(true);
		this.setLayout(new BorderLayout());
		this.add(new Panel(),BorderLayout.CENTER);
		this.add(new imagePanel(),BorderLayout.SOUTH);
		this.add(new AudioControlPanel(),BorderLayout.EAST);
		this.setTitle("audio Player");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}
}