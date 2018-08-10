package com.visa.training.oo;

public class ArrayStack<E> implements Stack<E>{	//ArrayStack is generic class

	private Object[] contents;
	private int top = -1; //not 0 because 0 is a valid array index
	
	public ArrayStack(int capacity){
		contents  = new Object[capacity];
	}
	
	@Override  //Good practice to put this annotation
	public void push(E anElement) {
		// TODO Auto-generated method stub
		System.out.println("Received by arrayStack : "+anElement);
		contents[++top] = anElement;
	}

	@Override
	public E pop() {
		// TODO Auto-generated method stub
		System.out.println("Returning from arrayStack : "+contents[top]);
		return (E) contents[top--];
	}
	
	public int size(){
		return top+1;
	}
	

}
