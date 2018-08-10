package com.visa.training.collections;
import java.util.*;

public class SortWords {
	List<String> wordList = new ArrayList<>();
	
	public void add()
	{
		Scanner sc = new Scanner(System.in);
		String str;
		while(true)
		{
			System.out.print("Enter Word : ");
			str = sc.nextLine();
			if(str.equalsIgnoreCase("quit")){
				break;
			}
			
			wordList.add(str);
		}
		/*Collections.sort(wordList);
		for(String s : wordList)
		{
			System.out.println(s);
		}
		System.out.println();
		Comparator<String> c = (s1,s2)->s1.length()-s2.length();  //lambda expression.Becoz of generics of wordList the compiler will itself deduce that the arguments of the function of interface will be of the same type. Thus specifying them is not necessary.
		Collections.sort(wordList,c);
		for(String s : wordList)
		{
			System.out.println(s);
		}*/
		
		/*Comparator<String> c = (s1,s2)->eChecker(s1,s2);
		Collections.sort(wordList,c);*/
		Collections.sort(wordList,SortWords::eChecker); //Method Reference if eChecker is static
		
		SortWords sw = new SortWords();
		Collections.sort(wordList,sw::eChecker2); //Method reference when function is non-static
		
		Collections.sort(wordList,SortWords::reverseSort);
		Collections.sort(wordList,SortWords::firstCharSort);
		
		for(String str1 : wordList)
		{
			System.out.println(str1);
		}
		
		
	}
	
	public static int firstCharSort(String s1, String s2)
	{
		if(s1.charAt(0)>s2.charAt(0))
			return 1;
		else
			return -1;
	}
	
	public static int reverseSort(String s1,String s2)
	{
		return s2.length()-s1.length();
	}
	
	/*public int compare(String s1,String s2){
		return s1.length()-s2.length();
	}*/
	
	public static int eChecker(String s1,String s2)
	{
		if(s1.contains("e") && !s2.contains("e"))
			return -1;
		else if(s2.contains("e") && !s1.contains("e"))
			return 1;
		else 
			return 0;
	}
	
	public int eChecker2(String s1,String s2)
	{
		if(s1.contains("e") && !s2.contains("e"))
			return -1;
		else if(s2.contains("e") && !s1.contains("e"))
			return 1;
		else 
			return 0;
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SortWords sc = new SortWords();
		sc.add();
	}

}
