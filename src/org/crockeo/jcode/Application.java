package org.crockeo.jcode;

import org.crockeo.jcode.utils.state.StateHandler;
import org.crockeo.jcode.backend.Display;

/*
 * Class: Window
 * 
 * Purpose:
 *  Front end for creating the display and game
 */

public class Application {
	private ApplicationConfig cfg;
	private StateHandler sh;
	
	public Application(ApplicationConfig cfg,
					   StateHandler sh) {
		this.cfg = cfg;
		this.sh = sh;
		
		recreate();
	}
	
	// (Re)creating the application
	public void recreate() {
		if (Display.isCreated())
			Display.destroy();
		
		Display.create(cfg.displayWidth, cfg.displayHeight,
					   cfg.fullscreen,
					   cfg.title);
	}
	
	
	// Accessors
	public ApplicationConfig getConfig() { return cfg; }
	public StateHandler getStateHandler() { return sh; }
	
	// Mutators
	public void setApplicationConfig(ApplicationConfig cfg) { this.cfg = cfg; }
}
