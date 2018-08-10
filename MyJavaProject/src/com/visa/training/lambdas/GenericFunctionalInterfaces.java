package com.visa.training.lambdas;
import java.util.*;
import java.util.function.Predicate;
public class GenericFunctionalInterfaces {
	
	public static <T> List<T> allMatches(List<T> wordList, Predicate<T> p){
		List<T> matchedList = new ArrayList<>();
		for(T str : wordList)
		{
			if(p.test(str))
				matchedList.add(str);
		}
		return matchedList;
	}
	

	
	/*public static <T> void display(List<T> ll){
		System.out.println(criteria);
		for(T str : ll){
			System.out.println(str);
		}*/
	
	public static <T> void display(List<T> ll){
		/*for(T str:ll){
			System.out.println(str);
		}*/
		//ll.forEach(str-> System.out.println(str));
		ll.forEach(System.out::println);
	}
	
	public static  void main(String[] args){
		List<String> ll = Arrays.asList("Hi","Hello","for","test","start");
		List<String> ans;
		ans = allMatches(ll,s->s.length()<4);
		System.out.println("Length<4");
		display(ans);
		ans = allMatches(ll,s->s.contains("a"));
		System.out.println("Contains a");
		display(ans);
		ans = allMatches(ll,s->(s.length()%2==0));
		System.out.println("Even length");
		display(ans);
		
		List<Integer> li = Arrays.asList(1,100,400,8080,7878,456);
		List<Integer> ans1;
		ans1 = allMatches(li,n->n>500);
		System.out.println("Numbers greater than 500");
		display(ans1);
		
		
		
		
	}

}
