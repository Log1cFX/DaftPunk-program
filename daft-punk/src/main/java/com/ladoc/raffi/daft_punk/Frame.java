package com.ladoc.raffi.daft_punk;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JFrame;

public class Frame extends JFrame{
	Frame(){
		this.setResizable(true);
		this.setLayout(new GridLayout(3, 1, 0, 0));
		this.add(new Panel(),BorderLayout.CENTER);
		this.add(new imagePanel(),BorderLayout.SOUTH);
		this.add(new AudioControlPanel(),BorderLayout.SOUTH);
		this.setTitle("audio Player");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}
}