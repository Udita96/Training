package com.visa.training.lambdas;

@FunctionalInterface
public interface TwoStringPredicate {
	
	public boolean isFirstBetter(String s1,String s2); //by default abstract
	
	public default void test(){
		System.out.println("Hi");
	}

}
