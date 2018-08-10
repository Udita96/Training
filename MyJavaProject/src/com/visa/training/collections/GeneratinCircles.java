package com.visa.training.collections;
import java.util.*;

public class GeneratinCircles {
	ArrayList<Circle> circleRadius;
	Circle c;
	public void generateRadius()
	{
		circleRadius = new ArrayList<Circle>();
		c = new Circle(Math.random());
		
		while(c.getRadius()>=0.01){
			circleRadius.add(c);
			c = new Circle(Math.random());
		}
	}
	
	public void displayList()
	{
		for(int i = 0;i<circleRadius.size();i++)
		{
			System.out.println(circleRadius.get(i).getRadius() + " : " + circleRadius.get(i).area());
		}
	}
	
	public void deleteCircles(double r){
		Iterator<Circle> it = circleRadius.iterator();
		Circle aux;
		while(it.hasNext())
		{
			aux = it.next();
			if(aux.getRadius()<0.5)
				it.remove();
			
		}
	}
	
	public static void main(String[] args){
		GeneratinCircles gc = new GeneratinCircles();
		System.out.println("New : ");
		gc.generateRadius();
		gc.displayList();
		gc.deleteCircles(0.5);
		
		System.out.println("Updated : ");
		gc.displayList();
	}
	

}
