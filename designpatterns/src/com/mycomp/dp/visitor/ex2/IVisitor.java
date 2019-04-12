package com.mycomp.dp.visitor.ex2;

public interface IVisitor {
	   public void visit(Customer customer);
	   public void visit(Order order);
	   public void visit(Item item); 
}
