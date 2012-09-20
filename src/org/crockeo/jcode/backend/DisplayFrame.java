package org.crockeo.jcode.backend;

import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import java.awt.Graphics;

/*
 * Class: DisplayFrame
 * 
 * Purpose:
 *  A container around the JFrame class
 */

class DisplayFrame extends JFrame {
	private BufferedImage canvas;
	
	public DisplayFrame(int width, int height,
						boolean fullscreen,
						String title) {
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		if (fullscreen) {
			setExtendedState(MAXIMIZED_BOTH);
			setUndecorated(true);
		} else
			setSize(width, height);
		setResizable(false);
		
		canvas = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		
		setVisible(true);
	}
	
	// Painting the DisplayFrame
	public void paint(Graphics g) {
		g.drawImage(canvas, 0, 0, getWidth(), getHeight(), null);
	}	
	
	// Accessors
	public BufferedImage getCanvas() { return canvas; }
}
