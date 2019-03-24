package WireCodingTest.CodingTest.controller;

import WireCodingTest.CodingTest.ParseInfo;
import WireCodingTest.CodingTest.domain.DataOfCurrency;
import WireCodingTest.CodingTest.domain.Information;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ApiReceiveController {
    private String endpoint = "live";
    private String access_key = "c1bc6519e38a10b07baed0373c279c94";
    private Map<String, String> quotes = new HashMap<String, String>();
    private List<String> list = Arrays.asList("USDKRW", "USDJPY", "USDPHP", "USDAUD", "USD");

    RestTemplate restTemplate = new RestTemplate();

    @PostMapping("/init")
    public Map<String, String> init(@RequestBody Information information) {
        ResponseEntity<DataOfCurrency> forEntity = restTemplate.getForEntity("http://apilayer.net/api/" + endpoint + "?access_key=" + access_key, DataOfCurrency.class);
        System.out.println(forEntity.getBody());
        Map<String, String> wholeQuotesInformation = forEntity.getBody().getQuotes();
        for (String s : list) {
            quotes.put(s, wholeQuotesInformation.get(s));
        }
        System.out.println("send : " + information.getSend());
        System.out.println("receive : " + information.getReceive());
        System.out.println("sendMoney : " + information.getSendMoney());
        ParseInfo.calculateCurrency(information, quotes);
        System.out.println(quotes);
        return quotes;
    }
}
