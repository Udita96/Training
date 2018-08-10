package com.visa.training.oo;

public class ChemicalElementApp {
	
	public static void printMetalDetails(ChemicalElement c)
	{
		System.out.println(c.getFullName());
		System.out.println("Alkali Metal? "+c.isAlkaliMetal());
		System.out.println("Metal? "+c.isMetal());
		System.out.println("Transition Metal? "+c.isTransitionMetal());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ChemicalElement ele = new ChemicalElement(8,"O","Oxygen");
		printMetalDetails(ele);
		ChemicalElement ele1 = new ChemicalElement(111,"X","Xyz");
		printMetalDetails(ele1);
	}

}
