package com.visa.training.collections;
import java.util.*;

public class ImplementingMap {
	Map<String,String> empMap = new HashMap<>(); //Second blank <> forces compiler to take type from LHS
	
	
	/*private int hashValue(String key){
		int hash = 0;
		for(int i=1;i<=key.length();i++)
			hash += (i*key.charAt(i-1));
		return hash;
	}*/
	
	public ImplementingMap()
	{
		empMap.put("E1234","Steve Jobs");
		empMap.put("E2345", "Bill Gates");
		empMap.put("E3456", "Larry Ellison");
		empMap.put("E4567", "Jeff Bezos");
		empMap.put("E5678", "Mark Zuckerberg");
		empMap.put("E6789", "Larry Page");
	}
	
	public void search(Scanner s){
		String empId;
		while(true)
		{
			System.out.print("Enter employee Id : ");
			empId = s.nextLine();
			if(empId.equalsIgnoreCase("quit"))
			{
				break;
			}
			if(empMap.containsKey(empId)){
				System.out.println("Employee exists and name is "+empMap.get(empId));
			}
			else
			{
				System.out.println("No such employee");
			}
		}
		System.out.println("Contents of the Map: ");
		Set<String> keys = empMap.keySet();
		for(String aKey : keys){
			System.out.println(aKey+" : "+empMap.get(aKey));
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		ImplementingMap im = new ImplementingMap();
		im.search(s);
	}

}
