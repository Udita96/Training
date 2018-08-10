package com.visa.training.lambdas;
import java.util.*;
import java.util.function.Predicate;
public class InbuiltFunctionalInterfaces {
	
	public static List<String> allMatches(List<String> wordList, Predicate<String> p){
		List<String> matchedList = new ArrayList<>();
		for(String str : wordList)
		{
			if(p.test(str))
				matchedList.add(str);
		}
		return matchedList;
	}
	
	public static void addWords(List<String> ll)
	{
		ll.add("Hi");
		ll.add("Hello");
		ll.add("for");
		ll.add("test");
		ll.add("start");
	}
	
	public static void display(String criteria,List<String> ll){
		System.out.println(criteria);
		for(String str : ll){
			System.out.println(str);
		}
	}
	
	public static void main(String[] args){
		List<String> ll = new ArrayList<>();
		addWords(ll);
		List<String> ans;
		ans = allMatches(ll,s->s.length()<4);
		display("Length<4",ans);
		ans = allMatches(ll,s->s.contains("a"));
		display("Contains 'a' ",ans);
		ans = allMatches(ll,s->(s.length()%2==0));
		display("Even length",ans);
		
	}

}
