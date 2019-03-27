package WireCodingTest.CodingTest.service;

import WireCodingTest.CodingTest.domain.CountryInformation;
import WireCodingTest.CodingTest.domain.DataOfCurrency;
import WireCodingTest.CodingTest.domain.ParseInfo;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReceiveService {

    private Map<String, Double> countries = new HashMap<String, Double>();
    private List<String> countriesList = Arrays.asList("USDKRW", "USDJPY", "USDPHP", "USDAUD");
    private DecimalFormat df = new DecimalFormat("#,##0.00");
    private double sendMoney = 0;
    public String inputInfo(CountryInformation countryInformation, ResponseEntity<DataOfCurrency> response) {
        Map<String, Double> wholeQuotesInformation = response.getBody().getQuotes();
        for (String country : countriesList) {
            countries.put(country, wholeQuotesInformation.get(country));
        }
        countries.put("USD", 1.00);

        this.sendMoney = ParseInfo.calculateCurrency(countryInformation, countries);

        return df.format(sendMoney);
    }
}
