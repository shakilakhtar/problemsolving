package com.mycomp.dp.visitor.ex3;

public class SubtractVisitor implements Visitor{
	int value;

	public SubtractVisitor(int value) {
	this.value = value;
	}

	public int visit(MyInteger i) {
	System.out.println("Subtract integer");
	return (i.getValue() - value);
	}

	public int visit(MyLong l) {
	System.out.println("Subtract long");
	return ((int) l.getValue() - value);
	}

}
