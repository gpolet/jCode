package org.crockeo.jcode;

import org.crockeo.jcode.utils.state.StateHandler;
import org.crockeo.jcode.utils.state.BasicState;
import org.crockeo.jcode.graphics.Graphics;

/*
 * Class BasicTest
 * 
 * Purpose:
 *  Testing the basic nature of this library
 */

public class BasicTest {
	public BasicTest() {
		ApplicationConfig cfg = new ApplicationConfig().setTitle("BasicTest");
		
		Application app = new Application(cfg, new StateSwitcher());
		app.start();
	}
	
	
	private class StateSwitcher extends StateHandler {
		public void addStates() {
			addState(new State());
		}
	}
	
	private class State extends BasicState {
		public void init(StateHandler sh) {
			
		}
		
		public void tick(StateHandler sh, float delta) {
			
		}
		
		public void draw(StateHandler sh, Graphics g) {
			g.setColor(255, 255, 255);
			g.fillRect(50, 50, 50, 50);
		}
		
		public int getId() { return 0; }
	}
	
	public static void main(final String[] args) { new BasicTest(); }
}
