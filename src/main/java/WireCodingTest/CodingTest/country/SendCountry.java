package WireCodingTest.CodingTest.country;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public enum SendCountry {
    미국("USD", "미국"), 호주("USDAUD", "호주");

    private String moneyType;
    private String country;
    private double money;

    SendCountry(String moneyType, String country) {
        this.moneyType = moneyType;
        this.country = country;
    }

    public void setInfo(String moneyType, String country) {
        this.moneyType = moneyType;
        this.country = country;
    }

    public Double moneyInfo(Map<String, Double> quotes) {
        return quotes.get(this.moneyType);
    }


    public static List<String> getCountry() {
        List<String> countriesName = new ArrayList<>();
        for (SendCountry country : values()) {
            countriesName.add(country.country);
        }
        return countriesName;
    }

    public double getMoney() {
        return money;
    }

    public String getMoneyType() {
        return moneyType;
    }

}
