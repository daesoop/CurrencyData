package WireCodingTest.CodingTest;

import java.util.HashMap;
import java.util.Map;

public class Calculate {
    private static String sendCountry;
    private static String receiveCountry;
    private static double sendMoney;
    private static double receiveMoney;
    private static double money;
    public static double calculateCurrency(Map<String, Double> information, Map<String, String> quotes) {
        parseInfo(information, quotes);
        return 0;
    }

    private static void parseInfo(Map<String, Double> information, Map<String, String> quotes) {
        parseSendCountry(information);
        parseReceiveCountry(information);
        parseSendMoney(quotes);
    }

    private static void parseSendMoney(Map<String, String> quotes) {
        sendMoney = Double.valueOf(quotes.get(sendCountry));
        receiveMoney = Double.valueOf(quotes.get(receiveCountry));
        System.out.println("parseSendMoney send Test : " + sendMoney);
        System.out.println("parseSendMoney send Test : " + quotes.get(sendCountry));
        System.out.println("parseSendMoney receive Test : " + receiveMoney);
        System.out.println("parseSendMoney receive Test : " + quotes.get(receiveCountry));

    }

    private static void parseReceiveCountry(Map<String, Double> information) {
        if (information.get("receive").equals("한국")) {
            receiveCountry = "USDKRW";
        } else if (information.get("receive").equals("일본")) {
            receiveCountry = "USDJPY";
        } else if (information.get("receive").equals("필리핀")) {
            receiveCountry = "USDPHP";
        }
    }

    private static void parseSendCountry(Map<String, Double> information) {
        if (information.get("send").equals("호주")) {
            sendCountry = "USDAUD";
        } else {
            sendCountry = "USD";
        }
    }


}
