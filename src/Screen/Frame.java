package Screen;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class Frame extends JFrame{
	Frame(){
		this.setResizable(true);
		this.setLayout(new BorderLayout());
		this.add(new Panel(),BorderLayout.CENTER);
		this.add(new imagePanel(),BorderLayout.SOUTH);
		this.setTitle("audio Player");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}
}