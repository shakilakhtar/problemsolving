package com.mycomp.dp.visitor.ex3;

public class MyInteger implements Visitable{
	private int value;

	MyInteger(int i) {
	this.value = i;
	}

	public int accept(Visitor visitor) {
	return visitor.visit(this);
	}

	public int getValue() {
	return value;
	}
}
