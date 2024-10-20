package task2;

import java.util.HashMap;
import java.util.Map;

public class CurrencyConverter {

    private Map<String, Double> exchangeRate;

    public CurrencyConverter() {
        exchangeRate = new HashMap<>();

        exchangeRate.put("USD", 1.0);
        exchangeRate.put("EUR", 0.9195);
        exchangeRate.put("RUR", 96.4172);
        exchangeRate.put("GBP", 0.7075);
        exchangeRate.put("JPY", 150.0299);
    }

    public String convertOneToAll(String fromCurrency, double amount) {
        StringBuilder sb = new StringBuilder();

        for (Map.Entry<String, Double> entry : exchangeRate.entrySet()) {
            sb.append("%s\n".formatted(convertToString(fromCurrency, entry.getKey(), amount)));
        }

        return sb.toString();
    }

    public double convert(String fromCurrency, String toCurrency, double amount) {
        double result;

        double amountInUsd = amount / exchangeRate.get(fromCurrency);
        result = amountInUsd * exchangeRate.get(toCurrency);

        return result;
    }

    public String convertToString(String fromCurrency, String toCurrency, double amount) {
        return "%.4f %s = %.4f %s".formatted(amount, fromCurrency, convert(fromCurrency, toCurrency, amount), toCurrency);
    }

}
