package CurrencyCalculator.domain;

import CurrencyCalculator.country.ReceiveCountry;
import CurrencyCalculator.country.SendCountry;

import java.util.Map;

public class ParseInfo {
    private static ReceiveCountry receiveCountries;
    private static SendCountry sendCountries;
    private static double sendMoneyRate;
    private static double receiveMoneyRate;

    //크로스 환율만 계산하기
    public static double crossRate(CountryInformation countryInformation, Map<String, Double> countries) {
        parseInfo(countryInformation, countries);
        return receiveMoneyRate / sendMoneyRate;
    }

    //환율 계산 후 송금할 돈 더하기
    //보낼 금액을 getSendMoney()에서 10000보다 많거나 0보다 작거나 같으면 에러 발생.
    public static double inputMoneyRate(CountryInformation countryInformation, Map<String, Double> countries) {
//        parseInfo(countryInformation, countries);
        return crossRate(countryInformation, countries) * countryInformation.getSendMoney();
    }

    //환율 계산 할 때 정보 넣기
    private static void parseInfo(CountryInformation information, Map<String, Double> countries) {
        inputCountriesInformation(information);
        inputMoneyRate(countries);
    }

    //나라 지정하기
    private static void inputCountriesInformation(CountryInformation information) {
        receiveCountries = information.getReceive();
        sendCountries = information.getSend();
    }

    //송금나라와 수취나라의 환율정보 넣어주기.
    private static void inputMoneyRate(Map<String, Double> countries) {
        sendMoneyRate = sendCountries.moneyInfo(countries);
        receiveMoneyRate = receiveCountries.moneyInfo(countries);
    }
}
