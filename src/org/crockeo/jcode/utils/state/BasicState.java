package org.crockeo.jcode.utils.state;

/*
 * Class: BasicState
 * 
 * Purpose:
 *  Making the enter and exit functions unnecessary
 */

public abstract class BasicState
		implements State {
	public void enter(StateHandler sh) { }
	public void exit(StateHandler sh) { }
}
