package org.crockeo.jcode.backend;

import java.awt.Graphics;

/*
 * Class: Display
 * 
 * Purpose:
 *  Front end(ish) for the DisplayFrame
 */

public class Display {
	private static DisplayFrame frame = null;
	private static boolean created = false;
	
	// Creating the display
	public static void create(int width, int height,
							  boolean fullscreen,
							  String title) {
		frame = new DisplayFrame(width, height, fullscreen, title);
		created = true;
	}
	
	// Destroying the display
	public static void destroy() {
		frame = null;
		created = false;
	}
	
	// Flipping the display
	public static void flip() { frame.repaint(); }
	
	// Accessors
	public static DisplayFrame getFrame() { return frame; }
	public static Graphics getDrawingGraphics() { return frame.getCanvas().getGraphics(); }
	public static boolean isCreated() { return created; }
	public static int[] getSize() { return new int[] { getWidth(), getHeight() }; }
	public static int getWidth() { return getFrame().getWidth(); }
	public static int getHeight() { return getFrame().getHeight(); }
}