
public class TestDate 
{
	public static void main(String[] args)
	{
		Date currentDate = new Date(1,4,2017);
		currentDate.displayDate();
		
		int nextDay = (currentDate.getDay() + 1);
		currentDate.setDay(nextDay);
		System.out.print("Tomorrow it would say: ");
		currentDate.displayDate();
		
		int nextYear = (currentDate.getYear() + 1);
		currentDate.setDay(4);
		currentDate.setYear(nextYear);
		System.out.print("In a year it would say: ");
		currentDate.displayDate();
	}

}
