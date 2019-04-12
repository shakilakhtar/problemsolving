package com.mycomp.dp.visitor.ex1;

public interface CarElement {
	void accept(CarElementVisitor visitor); // CarElements have to provide accept().
}
