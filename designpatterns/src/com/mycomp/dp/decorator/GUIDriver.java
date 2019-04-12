package com.mycomp.dp.decorator;

public class GUIDriver {

	public static void main(String[] args) {
		
		
		// create a new window 
		
		//Window window = new ConcreteWindow();
		Window window =null;
		
		window.renderWindow();
		
		// at some point later 
		// maybe text size becomes larger than the window 
		// thus the scrolling behavior must be added 
		
		// decorate old window 
		window = new ScrollableWindow(window);
		
		//  now window object 
		// has additional behavior / state 
		
		window.renderWindow();
		
	}
}
