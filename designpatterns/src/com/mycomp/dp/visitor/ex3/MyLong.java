package com.mycomp.dp.visitor.ex3;

public class MyLong implements Visitable{
	private long value;

	MyLong(long l) {
	this.value = l;
	}

	public int accept(Visitor visitor) {
	return visitor.visit(this);
	}

	public long getValue() {
	return value;
	}
}
