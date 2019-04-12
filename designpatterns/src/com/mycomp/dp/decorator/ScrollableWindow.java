package com.mycomp.dp.decorator;

/**
 * Concrete Decorator with extended state 
 * 
 *  Scrollable window creates a window that is scrollable
 * 
 *
 */
public class ScrollableWindow extends DecoratedWindow {

	/**
	 * Additional State
	 */
	private Object scrollBarObjectRepresentation = null;

	public ScrollableWindow(Window windowRefernce) {

		super(windowRefernce);
	}

	@Override
	public void renderWindow() {

		// render scroll bar
		renderScrollBarObject();

		// render decorated window
		super.renderWindow();
	}

	private void renderScrollBarObject() {

		// prepare scroll bar
		scrollBarObjectRepresentation = new Object();

		// render scrollbar

	}

}
