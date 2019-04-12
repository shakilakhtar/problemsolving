package com.mycomp.dp.visitor.ex3;

public class AddVisitor implements Visitor{
	int value;

	public AddVisitor(int value) {
	this.value = value;
	}

	public int visit(MyInteger i) {
	System.out.println("Adding integer");
	return (value + i.getValue());
	}

	public int visit(MyLong l) {
	System.out.println("Adding long");
	return (value + (int) l.getValue());
	}
}
