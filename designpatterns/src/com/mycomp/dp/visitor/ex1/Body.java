package com.mycomp.dp.visitor.ex1;

public class Body implements CarElement {

	@Override
	public void accept(CarElementVisitor visitor) {
		 visitor.visit(this);

	}

}
