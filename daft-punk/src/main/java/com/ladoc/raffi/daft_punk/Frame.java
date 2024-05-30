package com.ladoc.raffi.daft_punk;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JFrame;

public class Frame extends JFrame {
	Frame() {
		this.setResizable(true);
		//this.setLayout(new GridLayout(3, 1, 0, 0));
		this.add(new Panel());
		this.add(new imagePanel());
		this.add(new AudioControlPanel());

		this.setTitle("audio Player");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}
}