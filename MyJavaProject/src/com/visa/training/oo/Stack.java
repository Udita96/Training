package com.visa.training.oo;

public interface Stack<E> {		//Stack of E	//Allows type specific elements and hence is called generic interface
	/*void push(Object anElement);
	Object pop();*/		
	void push(E anElement);
	E pop();
	int size();

}
