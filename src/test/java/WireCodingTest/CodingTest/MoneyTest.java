package WireCodingTest.CodingTest;

import WireCodingTest.CodingTest.domain.DataOfCurrency;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.*;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class MoneyTest {

    RestTemplate restTemplate = new RestTemplate();

    private String endpoint = "live";
    private String access_key = "c1bc6519e38a10b07baed0373c279c94";
    private Map<String, Double> quotes = new HashMap<String, Double>();
    private List<String> list = Arrays.asList("USDKRW", "USDJPY", "USDPHP");

    @Test
    public void name() throws Exception {
        ResponseEntity<DataOfCurrency> forEntity = restTemplate.getForEntity("http://apilayer.net/api/" + endpoint + "?access_key=" + access_key, DataOfCurrency.class);
        System.out.println(forEntity.getBody());
        Map<String, Double> map = forEntity.getBody().getQuotes();

        for (String s : list) {
            quotes.put(s, map.get(s));
        }
        System.out.println(quotes);
    }

}
