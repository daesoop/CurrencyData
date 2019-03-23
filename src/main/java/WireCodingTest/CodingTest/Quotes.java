package WireCodingTest.CodingTest;

import java.util.Map;

public class Quotes {
    private Map<String, String> currency;

    public Map<String, String> getCurrency() {
        return currency;
    }

    public void setCurrency(Map<String, String> currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "Quotes{" +
                "currency=" + currency +
                '}';
    }
}
