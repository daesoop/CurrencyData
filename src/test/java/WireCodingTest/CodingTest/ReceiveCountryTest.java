package WireCodingTest.CodingTest;

import WireCodingTest.CodingTest.country.ReceiveCountry;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class ReceiveCountryTest {

    private Map<String, Double> quotes = new HashMap<>();

    @Before
    public void setUp() throws Exception {
        quotes.put("USDKRW", 1135.00);
        quotes.put("USDJPY", 110.128054);
        quotes.put("USDPHP", 52.491494);

    }

    @Test
    public void moneyInfo() {
        assertThat(ReceiveCountry.한국.moneyInfo(quotes)).isEqualTo(quotes.get("USDKRW"));
    }
}
