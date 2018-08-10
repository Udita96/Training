package com.visa.training.lambdas;

import com.visa.training.oo.ChemicalElement;

public class StringUtils {
	
	public static String betterString(String s1,String s2, TwoStringPredicate decider){
		if(decider.isFirstBetter(s1, s2)){
			return s1;
		}
		else{
			return s2;
		}
	}
	
	public static <T> T betterElement(T s1,T s2, TwoElementPredicate<T> decider){//generic methods : the class is not generic but method is generic 
		if(decider.isFirstBetter(s1, s2)){
			return s1;
		}
		else{
			return s2;
		}
	}
	
	public static void main(String[] args) {
		String s1 = "zenith";
		String s2 = "xylophone";
		
		/*System.out.println("The lengthier of the 2 is "+betterString(s1,s2,(x,y)->x.length()>y.length()));
		System.out.println("Alphabetically greater "+betterString(s1,s2,(x,y)->x.compareTo(y)>0));*/
		
		System.out.println("The lengthier of the 2 is "+betterElement(s1,s2,(x,y)->x.length()>y.length()));//length works becoz the first two arguments passed are of type String and the third argument depends on the first two arguments
		System.out.println("Alphabetically greater "+betterElement(s1,s2,(x,y)->x.compareTo(y)>0));
		
		
		ChemicalElement h = new ChemicalElement(1,"H","hydrogen");
		ChemicalElement k = new ChemicalElement(19,"K","Potassium");
		ChemicalElement heavier = betterElement(k,h,(e1,e2)->e1.getAtomicNumber()>e2.getAtomicNumber());
		System.out.println("Heavier Element : "+heavier.getFullName());
		
	}

}
