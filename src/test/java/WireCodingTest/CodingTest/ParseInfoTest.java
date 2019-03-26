package WireCodingTest.CodingTest;

import WireCodingTest.CodingTest.country.SendCountry;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class ParseInfoTest {

    private Map<String, Double> qutoes;

    @Before
    public void setUp() throws Exception {
        qutoes = new HashMap<>();
        qutoes.put("USD", 1.00);
        qutoes.put("USDAUD", 1.43);
    }

    @Test
    public void inputSendMoney() {
        System.out.println("안나오나 ?  "+SendCountry.호주.moneyInfo(qutoes));
        double money = SendCountry.호주.moneyInfo(qutoes);
        assertThat(money).isEqualTo(1.43);

    }
}
