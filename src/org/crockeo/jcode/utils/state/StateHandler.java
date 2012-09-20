package org.crockeo.jcode.utils.state;

import org.crockeo.jcode.graphics.Graphics;
import org.crockeo.jcode.backend.Display;

import java.util.ArrayList;

/*
 * Class: StateHandler
 * 
 * Purpose:
 *  Handling the switching between states
 */

public abstract class StateHandler {
	private ArrayList<State> states;
	private State currState;
	private boolean running;
	
	public StateHandler() {
		states = new ArrayList<>();
		addStates();
		
		if (currState == null)
			currState = states.get(0);
		
		running = false;
	}
	
	// Adding states
	protected abstract void addStates();
	protected void addState(State s) {
		s.init(this);
		states.add(s);
	}
	
	// Accessors
	public State[] getStates() { return (State[])states.toArray(); }
	public State getStateByIndex(int index) { return states.get(index); }
	public State getStateById(int id) { return getStateByIndex(searchFor(id)); }
	public State getCurrentState() { return currState; }
	
	// Mutators
	public void setStateByIndex(int index) {
		currState.exit(this);
		currState = states.get(index);
		currState.enter(this);
	}
	
	public void setStateById(int id) {
		int index = searchFor(id);
		
		if (index != -1)
			setStateByIndex(index);
	}
	
	// Searching for a given id
	private int searchFor(int id) {
		for (int i = 0; i < states.size(); i++)
			if (states.get(i).getId() == id)
				return i;
		return -1;
	}
	
	
	// Loop functions
	public void start() {
		running = true;
		loop();
	}
	
	public void stop() {
		running = false;
	}
	
	private void loop() {
		long lastTime, currTime;
		
		lastTime = System.currentTimeMillis();
		while (running) {
			currTime = System.currentTimeMillis();
			
			// Ticking
			currState.tick(this, (currTime - lastTime) / 1000.0f);
			
			// Drawing			
			currState.draw(this, Graphics.instance());
			
			// Flipping the display
			Display.flip();
			
			lastTime = currTime;
		}
	}
}
