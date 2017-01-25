import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import net.aksingh.owmjapis.DailyForecast;
import net.aksingh.owmjapis.OpenWeatherMap;

public class WeatherForecast {
	public DailyWeather[] weatherForecast = new DailyWeather[3];
	
	public WeatherForecast(String cityName, OpenWeatherMap owm) throws IOException, JSONException
	{
		
		DailyForecast ded = owm.dailyForecastByCityName(cityName, (byte) 3);
		JSONObject obj = new JSONObject(ded.getRawResponse());
		JSONArray dayArray = obj.getJSONArray("list");

		for (int i = 0; i < 3; i++)
		{
			weatherForecast[i] = new DailyWeather((JSONObject) dayArray.get(i));
		}
	}
	
	public DailyWeather[] getWeatherForecast()
	{
		return weatherForecast;
	}
}
