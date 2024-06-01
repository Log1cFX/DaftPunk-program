package com.ladoc.raffi.daft_punk;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class Frame extends JFrame {
	Panel panel;
	ImagePanel imagePanel;
	AudioControlPanel audioControlPanel;

	Frame() {
		this.setResizable(true);

		panel = new Panel();
        audioControlPanel = new AudioControlPanel();
        this.setLayout(new BorderLayout()); // Use BorderLayout for better control
		this.add(panel, BorderLayout.CENTER); // Add to the top
        this.add(audioControlPanel, BorderLayout.SOUTH); // Add to the bottom

		this.setTitle("audio Player");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}	
}