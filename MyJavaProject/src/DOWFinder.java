
public class DOWFinder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findDOW(30,9,2017));

	}
	
	public static String findDOW(int day, int month, int year)
	{
		int number_of_days;
		String day_of_week = null;
		number_of_days = (year-1900)*365;
		number_of_days += (year-1900)/4;
		if(year%4==0)
		{
			if(month<=2)
			{
				number_of_days--;
			}
		}
		
		if(month>1)
		{
			number_of_days+=31;
		}
		if(month>2)
		{
			number_of_days+=28;
		}
		if(month>3)
		{
			number_of_days+=31;
		}
		if(month>4)
		{
			number_of_days+=30;
		}
		if(month>5)
		{
			number_of_days+=31;
		}
		if(month>6)
		{
			number_of_days+=30;
		}
		if(month>7)
		{
			number_of_days+=31;
		}
		if(month>8)
		{
			number_of_days+=31;
		}
		if(month>9)
		{
			number_of_days+=30;
		}
		if(month>10)
		{
			number_of_days+=31;
		}
		if(month>11)
		{
			number_of_days+=30;
		}
		
		number_of_days+=day;
		
		int iday_of_week = number_of_days%7;
		switch(iday_of_week)
		{
		case 0:
			day_of_week = "Sunday";
			break;
		case 1:
			day_of_week = "Monday";
			break;
		case 2:
			day_of_week = "Tuesday";
			break;
		case 3:
			day_of_week = "Wednesday";
			break;
		case 4:
			day_of_week = "Thursday";
			break;
		case 5:
			day_of_week = "Friday";
			break;
		case 6:
			day_of_week = "Saturday";
			break;
			default:
				day_of_week = "Error";
		}
		
		return day_of_week;
	}

}
