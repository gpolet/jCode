package org.crockeo.jcode;

/*
 * Class: ApplicationConfig
 * 
 * Purpose:
 *  Used for configuring the application
 */

public class ApplicationConfig {
	public int displayWidth = 640;
	public int displayHeight = 480;
	public boolean fullscreen = false;
	public String title = "Untitled";

	// Mutators
	public ApplicationConfig setDisplayWidth(int displayWidth) { this.displayWidth = displayWidth; return this; }
	public ApplicationConfig setDisplayHeight(int displayHeight) { this.displayHeight = displayHeight; return this; }
	public ApplicationConfig setFullscreen(boolean fullscreen) { this.fullscreen = fullscreen; return this; }
	public ApplicationConfig setTitle(String title) { this.title = title; return this; }
}
