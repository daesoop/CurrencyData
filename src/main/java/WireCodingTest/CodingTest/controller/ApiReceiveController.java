package WireCodingTest.CodingTest.controller;

import WireCodingTest.CodingTest.domain.DataOfCurrency;
import WireCodingTest.CodingTest.domain.Information;
import WireCodingTest.CodingTest.domain.ParseInfo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ApiReceiveController {
    private String endpoint = "live";
    private String access_key = "c1bc6519e38a10b07baed0373c279c94";
    private Map<String, Double> quotes = new HashMap<String, Double>();
    private List<String> list = Arrays.asList("USDKRW", "USDJPY", "USDPHP", "USDAUD");

    private RestTemplate restTemplate = new RestTemplate();

    @PostMapping("/init")
    public String init(@RequestBody Information information) {
        ResponseEntity<DataOfCurrency> forEntity = restTemplate.getForEntity("http://apilayer.net/api/" + endpoint + "?access_key=" + access_key, DataOfCurrency.class);
        System.out.println(forEntity.getBody());

        Map<String, Double> wholeQuotesInformation = forEntity.getBody().getQuotes();
        for (String s : list) {
            quotes.put(s, wholeQuotesInformation.get(s));
        }
        quotes.put("USD", 1.00);
        System.out.println(quotes);
        System.out.println("파이날 : " + ParseInfo.calculateCurrency(information, quotes));

        double sendMoney = ParseInfo.calculateCurrency(information, quotes);
        DecimalFormat df = new DecimalFormat("#,##0.00");
        return df.format(sendMoney);
    }
}
