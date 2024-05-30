package com.ladoc.raffi.daft_punk;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class imagePanel extends JPanel {
	imagePanel(){
		this.setBackground(Color.black);
		ImageIcon imageIcon = new ImageIcon("src/main/resources/daft_punk.jpg");
        JLabel label = new JLabel(imageIcon);
		label.setVisible(true);
		this.add(label);
	}
}
