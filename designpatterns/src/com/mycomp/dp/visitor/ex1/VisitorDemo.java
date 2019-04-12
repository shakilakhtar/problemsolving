package com.mycomp.dp.visitor.ex1;

public class VisitorDemo {

	  static public void main(String[] args) {
	        Car car = new Car();
	        car.accept(new CarElementPrintVisitor());
	        car.accept(new CarElementDoVisitor());
	    }
}
