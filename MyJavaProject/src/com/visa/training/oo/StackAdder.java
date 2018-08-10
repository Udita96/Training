package com.visa.training.oo;

public class StackAdder {
	
	public double findSum(Stack<? extends Number> s){ //unknown type that extends Number
		int size = s.size();
		double sum = 0;
		for(int i = 0;i<size;i++){
			sum += s.pop().doubleValue();
		}
		return sum;
	}

}
