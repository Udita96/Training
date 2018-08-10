package com.visa.training.oo;

public class StackUser {	
	
	public void workWithStack(Stack s){ //reference of interface is possible
	System.out.println("About to push an element");
	s.push("test");
	System.out.println("About to pop an element");
	Object element = s.pop();
	System.out.println("Popped : "+element);
	}

}
