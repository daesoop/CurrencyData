package WireCodingTest.CodingTest;

import WireCodingTest.CodingTest.country.ReceiveCountry;
import WireCodingTest.CodingTest.domain.CountryInformation;
import WireCodingTest.CodingTest.domain.ParseInfo;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;


import static org.assertj.core.api.Assertions.assertThat;


public class ParseInfoTest {

    private Map<String, Double> qutoes;
    private CountryInformation countryInformation = new CountryInformation();

    @Before
    public void setUp() throws Exception {
        qutoes = new HashMap<>();
        qutoes.put("USD", 1.00);
        qutoes.put("USDKRW", 1135.34);
        countryInformation.setSend("미국");
        countryInformation.setReceive("한국");
        countryInformation.setSendMoney("100");
    }

    @Test
    public void crossRateTest() {
        double rate = ReceiveCountry.한국.moneyInfo(qutoes);
        assertThat(ParseInfo.crossRate(countryInformation, qutoes)).isEqualTo(rate);
    }

    @Test
    public void inputCountriesInformation() {
        double money = ParseInfo.crossRate(countryInformation, qutoes) * countryInformation.getSendMoney();
        assertThat(ParseInfo.inputMoneyRate(countryInformation, qutoes)).isEqualTo(money);
    }
}
