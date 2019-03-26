package WireCodingTest.CodingTest;
import WireCodingTest.CodingTest.country.SendCountry;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class SendCountryTest {

    private Map<String, Double> quotes = new HashMap<>();

    @Before
    public void setUp() throws Exception {
        quotes.put("USD", 1.00);
        quotes.put("USDAUD", 1.43);
    }

    @Test
    public void moneyInfo() {
        assertThat(SendCountry.미국.moneyInfo(quotes)).isEqualTo(quotes.get("USD"));
    }
}

