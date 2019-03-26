package WireCodingTest.CodingTest.domain;

import WireCodingTest.CodingTest.country.ReceiveCountry;
import WireCodingTest.CodingTest.country.SendCountry;

import java.util.Map;

public class ParseInfo {
    private static ReceiveCountry receiveCountries;
    private static SendCountry sendCountries;
    private static String sendCountry;
    private static String receiveCountry;
    private static double sendMoneyRate;
    private static double receiveMoneyRate;
    private static double money;

    public static double calculateCurrency(Information information, Map<String, Double> quotes) {
        parseInfo(information, quotes);
        return receiveMoneyRate / sendMoneyRate * information.getSendMoney();
    }

    private static void parseInfo(Information information, Map<String, Double> quotes) {
        receiveCountries = information.getReceive();
        sendCountries = information.getSend();
        sendMoney(quotes);

    }

    private static void sendMoney(Map<String, Double> quotes) {
        sendMoneyRate = sendCountries.moneyInfo(quotes);
        receiveMoneyRate = receiveCountries.moneyInfo(quotes);
        System.out.println("sendMoneyRate : " + sendMoneyRate);
        System.out.println("receiveMoneyRate : " + receiveMoneyRate);
    }
}
