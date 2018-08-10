package com.visa.training.collections;
import java.util.*;

public class SetWord {
	Set<String> wordSet = new TreeSet<>();
	
	public void add(){
		Scanner s  = new Scanner(System.in);
		String word;
		int i = 0;
		while(i<5){
			System.out.print("Enter word : ");
			word = s.nextLine();
			if(wordSet.contains(word))
			{
				System.out.println("Duplicate Word");
				continue;
			}
			wordSet.add(word);
			i++;
		}
		System.out.println(i+" unique words added!");
		
		for(String str : wordSet)
		{
			System.out.println(str);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SetWord obj = new SetWord();
		obj.add();

	}

}
