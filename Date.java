
public class Date 
{
	private int month;
	private int day;
	private int year;
	
	public Date(int month, int day, int year)
	{
		this.month = month;
		this.day = day;
		this.year = year;
	}
	
	public int getDay()
	{
		return day;
	}
	
	public int getYear()
	{
		return year;
	}
	
	public int getMonth()
	{
		return month;
	}

	public void setDay(int day)
	{
		this.day = day;
	}
	
	public void setMonth(int month)
	{
		this.month = month;
	}

	public void setYear(int year)
	{
		this.year = year;
	}
	
	public void displayDate()
	{
		System.out.printf("The current date is %d/%d/%d\n", this.month, this.day, this.year);
	}
	
}
