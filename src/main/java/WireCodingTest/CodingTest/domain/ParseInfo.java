package WireCodingTest.CodingTest.domain;

import WireCodingTest.CodingTest.country.ReceiveCountry;
import WireCodingTest.CodingTest.country.SendCountry;

import java.util.Map;

public class ParseInfo {
    private static ReceiveCountry receiveCountries;
    private static SendCountry sendCountries;
    private static double sendMoneyRate;
    private static double receiveMoneyRate;

    public static double calculateCurrency(CountryInformation countryInformation, Map<String, Double> countries) {
        parseInfo(countryInformation, countries);
        return CrossRate(countryInformation);
    }

    private static double CrossRate(CountryInformation countryInformation) {

        return receiveMoneyRate / sendMoneyRate * countryInformation.getSendMoney();
    }

    private static void parseInfo(CountryInformation information, Map<String, Double> countries) {
        receiveCountries = information.getReceive();
        sendCountries = information.getSend();
        sendMoney(countries);

    }

    private static void sendMoney(Map<String, Double> countries) {
        sendMoneyRate = sendCountries.moneyInfo(countries);
        receiveMoneyRate = receiveCountries.moneyInfo(countries);
        System.out.println("sendMoneyRate : " + sendMoneyRate);
        System.out.println("receiveMoneyRate : " + receiveMoneyRate);
    }
}
