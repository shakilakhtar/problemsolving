package com.mycomp.dp.visitor.ex1;

public class Engine implements CarElement {

	@Override
	public void accept(CarElementVisitor visitor) {
		 visitor.visit(this);

	}

}
