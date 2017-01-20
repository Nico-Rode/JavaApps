import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.List;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class InetDisplay {
	
	private static final int maxPagesToVisit = 100;
	public int counter = 0;
	private HashMap<String, Boolean> pagesVisited = new HashMap<String, Boolean>();
	private static final Pattern urlPattern = Pattern.compile(
	        "(?:^|[\\W])((ht|f)tp(s?):\\/\\/|www\\.)"
	                + "(([\\w\\-]+\\.){1,}?([\\w\\-.~]+\\/?)*"
	                + "[\\p{Alnum}.,%_=?&#\\-+()\\[\\]\\*$~@!:/{};']*)",
	        Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
	
	public InetDisplay()
	{
		pagesVisited.put("http://www.whitworth.edu/cms/", false);
		while (counter < maxPagesToVisit)
		{
			visit();
		}
		System.out.print(counter);
		
	}
	
	public void crawl(String webpage)
	{
			try
			{
				counter++;
				URL text = new URL(webpage);
				BufferedReader rdr = new BufferedReader(new InputStreamReader(text.openStream()));
				String line;
				while ((line = rdr.readLine()) != null)
				{
					Matcher matcher = urlPattern.matcher(line);
					while (matcher.find())
					{
						pagesVisited.put(line.substring(matcher.start(0), matcher.end(0)), false);
					}
				}
				
			}
			catch (Exception ex) {;}
		}
	
	public void visit()
	{
		try
		{
			for (String webpage : pagesVisited.keySet())
			{
				if (counter > maxPagesToVisit)
					break;
					if (pagesVisited.get(webpage).equals(false))
					{
						pagesVisited.put(webpage, true);
						crawl(webpage);
					}
			}
		}
		catch (Exception ex){;}
	}
	
	
	public static void main(String[] args)
	{
		InetDisplay test = new InetDisplay();
		
	}
	

}
