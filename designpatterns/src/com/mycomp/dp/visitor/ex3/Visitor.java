package com.mycomp.dp.visitor.ex3;

public interface Visitor {
	public int visit(MyInteger wheel);

	public int visit(MyLong engine);
}
