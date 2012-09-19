package org.crockeo.jcode.backend;

import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.awt.Frame;

/*
 * Class: Display
 * 
 * Purpose:
 *  The back end for creating a display
 */

public class Display {
	private static Frame frame;
	private static BufferedImage canvas;
	
	private static boolean created = false;
	
	// Creating the display
	public static void create(int width, int height,
							  boolean fullscreen,
							  String title) {
		frame = new Frame();
		if (fullscreen) {
			frame.setExtendedState(Frame.MAXIMIZED_BOTH);
			frame.setUndecorated(true);
		} else {
			frame.setSize(640, 480);
		}
		
		canvas = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		
		created = true;
	}
	
	// Destroying the display
	public static void destroy() {
		frame.dispose();
		
		frame = null;
		canvas = null;
		
		created = false;
	}
	
	// Accessors
	public static Frame getFrame() { return frame; }
	public static BufferedImage getCanvas() { return canvas; }
	public static Graphics getGraphics() { return getCanvas().getGraphics(); }
	public static boolean isCreated() { return created; }
}
