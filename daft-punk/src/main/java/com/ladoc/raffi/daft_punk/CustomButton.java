package com.ladoc.raffi.daft_punk;

import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.RoundRectangle2D;
import java.util.Random;

import javax.swing.JButton;

public class CustomButton extends JButton {

	Color c1 = null;
	Color c2 = null;
	RoundRectangle2D roundRect;
	GradientPaint gradient = null;
	boolean firstUpdate = true;
	Rectangle oldBounds = null;

	CustomButton(String text) {
		this.setText(text);
		this.setFont(new Font("Arial", Font.BOLD, 20));
		this.setBorderPainted(false);
		this.setContentAreaFilled(false);
		this.setFocusPainted(false);
	}

	public static Color[] randomGradient() {
		Random rand = new Random();
		Color color1 = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
		Color color2 = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
		return new Color[] { color1, color2 };
	}

	boolean wasResized() {
		return oldBounds.equals(this.getBounds()) ? false : true;
	}

	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g.create();
		if (firstUpdate || wasResized()) {
			oldBounds = this.getBounds();
			if (firstUpdate) {
				Color[] color = randomGradient();
				c1 = color[0];
				c2 = color[1];
			}
			int width = this.getWidth();
			int height = this.getHeight();
			int arcWidth = width / 2;
			int arcHeight = height;
			gradient = new GradientPaint(0, 0, c1, width, height, c2, true);
			roundRect = new RoundRectangle2D.Double(0, 0, width, height, arcWidth, arcHeight);
			firstUpdate = false;
		}
		g2d.setPaint(gradient);
		g2d.fill(roundRect);
		super.paintComponent(g);
		g2d.dispose(); // Dispose of the graphics context to release system resources
	}

}
