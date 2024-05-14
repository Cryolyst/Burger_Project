package Burger_Project.Burger_Project;

import java.text.DecimalFormat;
import java.util.Currency;
import java.util.Locale;

public class Menu extends Burger211 {

	String country;
	String franchise;
	double discountRate;
	String promotion;
	String currencyCode;
	String currencySymbol;
	int updatedBurgerKey = -1;
	String updatedTopping;

	static double exchangeRate;
	static double temperature;

	String[] localPrice = new String[getHowManyBurgers() + 1]; // applied discount
	String pro = "";
	DecimalFormat format = new DecimalFormat("#0.0");

	Menu(String country, String franchise) throws Exception {
		init(country, franchise);
	}

	void init(String country, String franchise) throws Exception {

		Locale locale = new Locale.Builder().setRegion(country).build();

		currencyCode = Currency.getInstance(locale).getCurrencyCode();
		currencySymbol = Currency.getInstance(locale).getSymbol();

		this.country = country;
		this.franchise = franchise;

		temperature = Weather211.CityWeather(franchise);
		exchangeRate = ExchangeRate.getRate(currencyCode);

	}

	@Override
	public void printMenu() {

		new MenuGUI(franchise, pro, getName(1), currencySymbol + localPrice[1] + " (regular: " + regularPrices(1) + ")",
				getTopping(1), getName(2), currencySymbol + localPrice[2] + " (regular: " + regularPrices(2) + ")",
				getTopping(2), getName(3), currencySymbol + localPrice[3] + " (regular: " + regularPrices(3) + ")",
				getTopping(3), exchangeRate, temperature);
	}

	public void Promotion(double discountRate, String promotion) {

		this.discountRate = discountRate;
		this.pro = promotion;
		getPrices();

	}

	public String regularPrices(int i) {

		return format.format(this.getPrice(i) * exchangeRate);
	}

	private void getPrices() {

		for (int i = 1; i <= getHowManyBurgers(); i++) {
			double price = (exchangeRate * this.getPrice(i) * (1 - this.discountRate));
			localPrice[i] = format.format(price);
		}
	}

	public void PromotionTooHot(int toohot) {
		if (temperature > toohot) {
			discountRate = discountRate + 0.1;
			getPrices();
			pro += " ------- Too hot to eat: 10% discount applied! ------- ";
		}
	}
}