package Burger_Project.Burger_Project;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class ExchangeRate {

	static double rate = 1.0;
	static JSONObject myObject;

	public static double getRate(String currencyCode) throws Exception {
		try {
			String firstPartURL = "https://v6.exchangerate-api.com/v6/";
			String key = "5e1042612349f001c8670cb5";
			String thirdPartURL = "/latest/USD";
			String theURL = firstPartURL + key + thirdPartURL;

			@SuppressWarnings("deprecation")
			URL url = new URL(theURL);
			BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
			JSONParser jsonParser = new JSONParser();
			JSONObject myObject = (JSONObject) jsonParser.parse(br);
			JSONObject rates = (JSONObject) myObject.get("conversion_rates");
			Number rate = (Number) rates.get(currencyCode);
			double exchangerate = rate.doubleValue();
			return exchangerate;

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
}