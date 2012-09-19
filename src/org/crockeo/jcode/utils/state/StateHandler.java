package org.crockeo.jcode.utils.state;

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
	
	public StateHandler() {
		states = new ArrayList<>();
		addStates();
		
		if (currState == null)
			currState = states.get(0);
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
}
