package Burger_Project.Burger_Project;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Weather211 {

	public static double CityWeather(String cityName) throws Exception {

		double cityTemp = 0.0;

		try {
			String firstPartURL = "https://api.openweathermap.org/data/2.5/weather?q=";
			String secondPartURL = "&APPID=0fba4f746bb48d75fb50bae146c6ad34";
			String theURL = firstPartURL + cityName + secondPartURL;

			@SuppressWarnings("deprecation")
			URL url = new URL(theURL);

			/// Reads information from URL
			BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));

			// JSON parser object to parse read file
			JSONParser jsonParser = new JSONParser();
			// Read JSON file. All the data for the city is stored in "jsonObj"
			JSONObject myObject = (JSONObject) jsonParser.parse(br);
			System.out.print(myObject);
			JSONObject Main = (JSONObject) myObject.get("main");
			double rawtemperature = (double) Main.get("temp");

			cityTemp = (rawtemperature - 273.15) * 1.8 + 32;
		}

		catch (Exception ex) {

		}
		return cityTemp;
	}

}