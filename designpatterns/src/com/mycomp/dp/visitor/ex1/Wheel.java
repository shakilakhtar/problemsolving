package com.mycomp.dp.visitor.ex1;

public class Wheel implements CarElement {

	   private String name;
	   
	    public Wheel(String name) {
	        this.name = name;
	    }
	 
	    public String getName() {
	        return this.name;
	    }
	 
	    @Override
	    public void accept(CarElementVisitor visitor) {
	        visitor.visit(this);
	    }
}
