package org.crockeo.jcode.utils.state;

import org.crockeo.jcode.graphics.Graphics;

/*
 * Class: State
 * 
 * Purpose:
 *  Declaring all necessary functions for a given State
 */

public interface State {
	public void init(StateHandler sh); // Called once when adding the state
	
	public void enter(StateHandler sh); // Called when entering the state
	public void exit(StateHandler sh); // called when exiting the state
	
	public void tick(StateHandler sh, float delta); // Called every tick
	public void draw(StateHandler sh, Graphics g); // Called every draw tick
	
	public int getId(); // The state's id, 'cause, y'know, that's helpful.
}
