import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Pattern;

import javax.swing.*;

import net.aksingh.owmjapis.CurrentWeather;
import net.aksingh.owmjapis.OpenWeatherMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Test extends JFrame {
	private JTextField txtCityName;
	private JButton btnSubmit;
	private JLabel lblDescription;
	private JLabel lblTemp;
	private JLabel lblCity;
	private OpenWeatherMap owm;
	public boolean keyBoardFlag = false;
	private JButton btnWeatherDetails;
	private WeatherDetail weather;
	private JLabel lblHumidity;
	private JLabel lbl3HRain;
	private JLabel lblWindSpeed;
	private JLabel lblCountry;
	private JLabel lblCurrentTemp;
	private DailyWeather[] weatherForecast = new DailyWeather[3];
	private JButton btnForecast;
	private int buttonIndex = 0;
	private String[] days = {"1 day away", "2 days away", "3 days out"};
	


	public static void main(String[] args) throws IOException, JSONException, InterruptedException
	{
		Test test = new Test();
	}
	
	public Test()
	{	
		initialize();
		
		
		this.setVisible(true);
		
	}
	public void initialize()
	{
		
		owm = new OpenWeatherMap("");
		owm.setApiKey("c7cd50e84aa18aae22a7fe6793b99c1c");
		
		
		
		this.setSize(800, 300);
		
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.SOUTH);
		
		txtCityName = new JTextField();
		txtCityName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if (txtCityName.getText().equals("City Name"))
					txtCityName.setText("");
				if (arg0.getKeyCode() == KeyEvent.VK_ENTER)
				{
					fetchData();
					keyBoardFlag = true;
				}
				if (arg0.getKeyCode() == KeyEvent.VK_F1)
				{
					fetchDetailData();
				}
				else if (keyBoardFlag == true)
				{
					txtCityName.setText("");
					keyBoardFlag = false;
				}
			}
		});
		txtCityName.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				txtCityName.setText("");
			}
		});
		
		btnWeatherDetails = new JButton("Weather Details");
		btnWeatherDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				fetchDetailData();
			}
		});
		
		btnForecast = new JButton("Current Weather");
		btnForecast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (buttonIndex > 2)
				{
					buttonIndex = 0;
					btnForecast.setText("Current Weather");
					displayCurrentWeather();
				}
				else
				{
					btnForecast.setText(days[buttonIndex]);
					displayForecast(buttonIndex);
					buttonIndex++;
				}
			}
		});
		panel.add(btnForecast);
		panel.add(btnWeatherDetails);
		txtCityName.setText("City Name");
		panel.add(txtCityName);
		txtCityName.setColumns(10);
		
		btnSubmit = new JButton("Submit!");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (txtCityName.getText() != null)
				{
					fetchData();
					keyBoardFlag = true;
				}
			}
		});
		panel.add(btnSubmit);
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.CENTER);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0, 0, 0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		lblDescription = new JLabel("");
		GridBagConstraints gbc_lblDescription = new GridBagConstraints();
		gbc_lblDescription.fill = GridBagConstraints.BOTH;
		gbc_lblDescription.insets = new Insets(10, 0, 5, 5);
		gbc_lblDescription.gridx = 0;
		gbc_lblDescription.gridy = 0;
		panel_1.add(lblDescription, gbc_lblDescription);
		
		lblCountry = new JLabel("");
		GridBagConstraints gbc_lblCountry = new GridBagConstraints();
		gbc_lblCountry.insets = new Insets(-15, 54, 5, 5);
		gbc_lblCountry.fill = GridBagConstraints.BOTH;
		gbc_lblCountry.gridx = 0;
		gbc_lblCountry.gridy = 1;
		panel_1.add(lblCountry, gbc_lblCountry);
		
		lblCity = new JLabel("");
		GridBagConstraints gbc_lblCity = new GridBagConstraints();
		gbc_lblCity.insets = new Insets(60, 54, 5, 5);
		gbc_lblCity.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblCity.gridx = 0;
		gbc_lblCity.gridy = 0;
		panel_1.add(lblCity, gbc_lblCity);
		
		lblHumidity = new JLabel("");
		GridBagConstraints gbc_lblHumidity = new GridBagConstraints();
		gbc_lblHumidity.insets = new Insets(0, -110, 5, 0);
		gbc_lblHumidity.gridx = 3;
		gbc_lblHumidity.gridy = 0;
		panel_1.add(lblHumidity, gbc_lblHumidity);
		
		lbl3HRain = new JLabel("");
		GridBagConstraints gbc_lbl3HRain = new GridBagConstraints();
		gbc_lbl3HRain.insets = new Insets(-40, 0, 5, 0);
		gbc_lbl3HRain.gridx = 3;
		gbc_lbl3HRain.gridy = 2;
		panel_1.add(lbl3HRain, gbc_lbl3HRain);
		
		lblWindSpeed = new JLabel("");
		GridBagConstraints gbc_lblWindSpeed = new GridBagConstraints();
		gbc_lblWindSpeed.insets = new Insets(-70, -60, 5, 0);
		gbc_lblWindSpeed.gridx = 3;
		gbc_lblWindSpeed.gridy = 1;
		panel_1.add(lblWindSpeed, gbc_lblWindSpeed);
		
		lblCurrentTemp = new JLabel("");
		GridBagConstraints gbc_lblCurrentTemp = new GridBagConstraints();
		gbc_lblCurrentTemp.insets = new Insets(-10, 54, 5, 5);
		gbc_lblCurrentTemp.gridx = 0;
		gbc_lblCurrentTemp.gridy = 3;
		panel_1.add(lblCurrentTemp, gbc_lblCurrentTemp);
		
	}
	public void fetchData()
	{
		try 
		{
			buttonIndex = 0;
			btnForecast.setText("Current Weather");
			weather = new WeatherDetail(txtCityName.getText(), owm);
			WeatherForecast test = new WeatherForecast(txtCityName.getText(), owm);
			weatherForecast = test.getWeatherForecast();
			for (DailyWeather p : weatherForecast)
			{
				p.setCity(weather.getCity());
				p.setCountry(weather.getCountry());
			}
			
			displayCurrentWeather();

		}
		catch (Exception ex){System.out.print(ex);}
	}
	
	public void displayCurrentWeather()
	{
		lblHumidity.setText("");
		lblWindSpeed.setText("");
		lbl3HRain.setText("");
		
		lblDescription.setIcon(weather.getIcon());
		lblDescription.setText(weather.getDescription());
		lblDescription.setFont(lblDescription.getFont().deriveFont(26.0f));
		
		
		lblCountry.setText(weather.getCountry());
		lblCountry.setFont(lblCountry.getFont().deriveFont(26.0f));
		
		
		lblCity.setText(weather.getCity());
		lblCity.setFont(lblCity.getFont().deriveFont(26.0f));
		
		lblCurrentTemp.setText(weather.getTemp());
		lblCurrentTemp.setFont(lblCurrentTemp.getFont().deriveFont(26.0f));
	}
	
	public void displayForecast(int index)
	{
		
		lblDescription.setIcon(weatherForecast[index].getIcon());
		lblDescription.setText(weatherForecast[index].getDescription());
		lblDescription.setFont(lblDescription.getFont().deriveFont(26.0f));
		
		
		lblCurrentTemp.setText(weatherForecast[index].getMinTemp() + "   " + weatherForecast[index].getMaxTemp());
		lblCurrentTemp.setFont(lblCurrentTemp.getFont().deriveFont(26.0f));
		
		
	}
	
	public void fetchDetailData()
	{
		try
		{	
			if (weather.getDetailFlag())
			{
				lblHumidity.setText("");
				lblWindSpeed.setText("");
				lbl3HRain.setText("");
				weather.setDetailFlag(false);
			}
			else
			{
				lblHumidity.setText(weather.getHumidity());
				lblWindSpeed.setText(weather.getWindSpeed());
				lbl3HRain.setText(weather.getRain3H());
				
				lblHumidity.setFont(lblHumidity.getFont().deriveFont(20.0f));
				lblWindSpeed.setFont(lblWindSpeed.getFont().deriveFont(20.0f));
				lbl3HRain.setFont(lbl3HRain.getFont().deriveFont(20.0f));
				
				weather.setDetailFlag(true);
			}
		}
		catch (Exception ex){;}
	}
}
