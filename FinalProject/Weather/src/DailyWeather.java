import java.awt.Image;
import java.awt.Toolkit;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.ImageIcon;

import org.json.JSONException;
import org.json.JSONObject;

public class DailyWeather {
	private String minTemp;
	private String maxTemp;
	private String description;
	private ImageIcon iconImage;
	private String country;
	private String city;

	public DailyWeather(JSONObject obj) throws JSONException, MalformedURLException
	{
		
		
		setMaxTemp(obj.getJSONObject("temp").get("max").toString());
		setMinTemp(obj.getJSONObject("temp").get("min").toString());
		setDescription(obj.getJSONArray("weather").getJSONObject(0).get("description").toString());
		setIcon("http://openweathermap.org/img/w/" + obj.getJSONArray("weather").getJSONObject(0).getString("icon") + ".png");
	}
	
	
	
	
	public void setMinTemp(String minTemp)
	{
		this.minTemp = "Min Temp: " + minTemp + "F";
	}
	
	public void setCountry(String country)
	{
		this.country = "Country: " + country;
	}
	
	public void setCity(String city)
	{
		this.city = "City: " + city;
	}
	
	public void setMaxTemp(String maxTemp)
	{
		this.maxTemp = "Max Temp: " + maxTemp + "F";
	}
	
	public void setDescription(String description)
	{
		this.description = description;
	}
	
	public void setIcon(String icon) throws MalformedURLException
	{
		URL imgUrl = new URL(icon);
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image img = toolkit.getImage(imgUrl);
		iconImage = new ImageIcon(img);
	}
	
	public String getDescription()
	{
		return description;
	}
	
	public ImageIcon getIcon()
	{
		return iconImage;
	}
	
	public String getMinTemp()
	{
		return minTemp;
	}
	
	public String getMaxTemp()
	{
		return maxTemp;
	}
	
	public String getCountry()
	{
		return country;
	}
	
	public String getCity()
	{
		return city;
	}
	
}
