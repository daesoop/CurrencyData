package WireCodingTest.CodingTest;

import WireCodingTest.CodingTest.domain.Information;

import java.util.Map;

public class ParseInfo {
    private static String sendCountry;
    private static String receiveCountry;
    private static double sendMoney;
    private static double receiveMoney;
    private static double money;
    public static double calculateCurrency(Information information, Map<String, String> quotes) {
        parseInfo(information, quotes);
        return 0;
    }

    private static void parseInfo(Information information, Map<String, String> quotes) {
        parseSendCountry(information);
        parseReceiveCountry(information);
        parseSendMoney(quotes);
    }

    private static void parseSendMoney(Map<String, String> quotes) {
        if (sendCountry.equals("USDAUD")) {
            sendMoney = Double.valueOf(quotes.get(sendCountry));
        }
        receiveMoney = Double.parseDouble(quotes.get(receiveCountry));
        System.out.println("parseSendMoney send Test : " +  sendMoney);
        System.out.println("parseSendMoney receive Test : " + receiveMoney);

    }

    private static void parseReceiveCountry(Information information) {
        if (information.getReceive().equals("korea")) {
            receiveCountry = "USDKRW";
        } else if (information.getReceive().equals("japan")) {
            receiveCountry = "USDJPY";
        } else if (information.getReceive().equals("philippine")) {
            receiveCountry = "USDPHP";
        }
    }

    private static void parseSendCountry(Information information) {
        if (information.getSend().equals("australia")) {
            sendCountry = "USDAUD";
        } else if (information.getSend().equals("america")) {
            sendCountry = "USD";
            sendMoney = 1;
        }
    }
}
