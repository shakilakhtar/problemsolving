package com.mycomp.dp.visitor.ex3;

public class VisitorTest {
	public static void main(String[] args) {
		AddVisitor cv = new AddVisitor(10);
		SubtractVisitor sv = new SubtractVisitor(10);
		MyInteger i = new MyInteger(20);
		MyLong l = new MyLong(20);
		System.out.println(i.accept(cv));
		System.out.println(l.accept(cv));

		System.out.println(i.accept(sv));
		System.out.println(l.accept(sv));

		}
}
