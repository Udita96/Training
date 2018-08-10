package com.visa.training.lambdas;
import java.util.*;
import java.util.stream.Collectors;
public class StreamsList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> ll = Arrays.asList("Hi","Hello","for","start","test");
		ll.stream().forEach(str->System.out.println("  "+str));
		System.out.println("Method Reference");
		ll.stream().forEach(System.out::println);
		List<String> excitingWords = ll.stream().map(s->s+"!").collect(Collectors.toList());
		System.out.println();
		excitingWords.stream().forEach(System.out::println);
		List<String> eyeWords = ll.stream().map(s->s.replace("i", "eye")).collect(Collectors.toList());
		System.out.println();
		eyeWords.stream().forEach(System.out::println);
		List<String> upperCaseWords = ll.stream().filter(s->s.length()>4).collect(Collectors.toList());
		System.out.println();
		upperCaseWords.stream().forEach(System.out::println);
		
	}

}
