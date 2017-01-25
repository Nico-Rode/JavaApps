import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Pattern;

import javax.swing.*;

import net.aksingh.owmjapis.CurrentWeather;
import net.aksingh.owmjapis.DailyForecast;
import net.aksingh.owmjapis.OpenWeatherMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class WeatherDetail {
	
	private String windSpeed;
	private String temp;
	private String pressure;
	private String humidity;
	private String rain3H;
	private String country;
	private String city;
	private String description;
	private ImageIcon iconImage;
	private boolean detailFlag;
	
	public WeatherDetail(String cityName, OpenWeatherMap owm) throws JSONException, IOException
	{
		CurrentWeather ced = owm.currentWeatherByCityName(cityName);
		JSONObject obj = new JSONObject(ced.getRawResponse()); //This is where all of the hard work is
		JSONArray weatherArray = obj.getJSONArray("weather"); //Parses through the JSON array/Object
		
		
		
		setIcon("http://openweathermap.org/img/w/" + weatherArray.getJSONObject(0).getString("icon") + ".png");
	
		setDescription(weatherArray.getJSONObject(0).getString("description"));
		
		setTemp(obj.getJSONObject("main").get("temp").toString());
		
		setCity(obj.getString("name").toString());
		
		setWindSpeed(obj.getJSONObject("wind").get("speed").toString());
		
		setPressure(obj.getJSONObject("main").get("pressure").toString());
		
		setHumidity(obj.getJSONObject("main").get("humidity").toString());
		
		try {setRain3H(obj.getJSONObject("rain").get("3h").toString());} catch(Exception ex){;}
		
		setCountry(obj.getJSONObject("sys").get("country").toString());
		
		setDetailFlag(false);
		
	}
	
	public void setWindSpeed(String windSpeed)
	{
		this.windSpeed = "Windspeed: " + windSpeed + "mph";
	}
	
	public void setTemp(String temp)
	{
		this.temp = "Current Temp: " + temp + "F";
	}
	
	public void setDetailFlag(boolean detailFlag)
	{
		this.detailFlag = detailFlag; 
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
	
	public void setPressure(String pressure)
	{
		this.pressure = "Presssure: " + pressure;
	}
	
	public void setHumidity(String humidity)
	{
		this.humidity = "Humidity: " + humidity + "%";
	}
	
	public void setRain3H(String rain3H)
	{
		this.rain3H= "Three hour rain fall: " + rain3H + "in";
	}
	
	public void setCountry(String country)
	{
		this.country = "Country: " + country;
	}
	
	public void setCity(String city)
	{
		this.city = "City: " + city;
	}
	
	public String getDescription()
	{
		return description;
	}
	
	public ImageIcon getIcon()
	{
		return iconImage;
	}
	
	public String getWindSpeed()
	{
		return windSpeed;
	}

	public String getTemp()
	{
		return temp;
	}

	public String getPressure()
	{
		return pressure;
	}
	
	public String getHumidity()
	{
		return humidity;
	}
	
	public String getRain3H()
	{
		try {return rain3H;} catch (Exception ex){return "No rain";}
	}
	
	public String getCountry()
	{
		return country;
	}
	
	public String getCity()
	{
		return city;
	}
	
	public Boolean getDetailFlag()
	{
		return detailFlag;
	}
	
	
	
	
}
