package org.crockeo.jcode.graphics;

import org.crockeo.jcode.backend.Display;

import java.awt.Color;

/*
 * Class: Graphics
 * 
 * Purpose:
 *  Front end for graphics handling
 */

public class Graphics {
	private Graphics() { }
	
	// Drawing operations
	public void drawRect(float x, float y,
						 float w, float h) {
		Display.getGraphics().drawRect((int)x, (int)y, (int)w, (int)h);
	}
	
	public void fillRect(float x, float y,
						 float w, float h) {
		Display.getGraphics().fillRect((int)x, (int)y, (int)w, (int)h);
	}
	
	// Accessors
	public int[] getRGBA() { return new int[] { getRed(), getGreen(), getBlue(), getAlpha() }; }
	public int[] getRGB() { return new int[] { getRed(), getGreen(), getBlue() }; }
	public int getRed() { return Display.getGraphics().getColor().getRed(); }
	public int getGreen() { return Display.getGraphics().getColor().getGreen(); }
	public int getBlue() { return Display.getGraphics().getColor().getBlue(); }
	public int getAlpha() { return Display.getGraphics().getColor().getAlpha(); }
	
	// Mutators
	public void setColor(int r, int g, int b, int a) { Display.getGraphics().setColor(new Color(r, g, b, a)); }
	public void setColor(int r, int g, int b) { Display.getGraphics().setColor(new Color(r, g, b)); }
	
	
	// Singleton
	public final Object clone() { return null; }
	
	private static Graphics instance;
	public static Graphics instance() {
		if (instance == null)
			instance = new Graphics();
		return instance;
	}
}
