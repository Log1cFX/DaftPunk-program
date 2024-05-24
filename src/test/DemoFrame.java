package test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.adonax.audiocue.AudioCue;

class DemoFrame extends JFrame {
	private AudioCue bell;

	public DemoFrame() {
		JPanel panel = new JPanel();
		JButton button = new JButton("Play sound");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bell.play();
			}
		});
		panel.add(button);
		add(panel);

		// Set up the AudioCue
		URL url = this.getClass().getResource("/bell.wav");
		try {
			bell = AudioCue.makeStereoCue(url, 6);
			bell.open();
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
			e.printStackTrace();
		}
	}
}