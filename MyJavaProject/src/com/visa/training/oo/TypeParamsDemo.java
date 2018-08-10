package com.visa.training.oo;

public class TypeParamsDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		StackAdder adder = new StackAdder();
		Stack<Integer>  s = new ArrayStack<Integer>(5);
		s.push(10);
		s.push(20);
		s.push(30);
		s.push(40);
		s.push(50);
		double sum = adder.findSum(s);
		System.out.println(sum);
	}

}
