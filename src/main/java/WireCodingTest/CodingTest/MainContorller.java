package WireCodingTest.CodingTest;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Controller
public class MainContorller {

    private String endpoint = "live";
    private String access_key = "c1bc6519e38a10b07baed0373c279c94";

    private RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/")
    public String home(Model model) {
        ResponseEntity<DataOfCurrency> forEntity = restTemplate.getForEntity("http://apilayer.net/api/" + endpoint + "?access_key=" + access_key, DataOfCurrency.class);
        Map<String, String> currencyInformation = forEntity.getBody().getQuotes();
        model.addAttribute("koreaWon", currencyInformation.get("USDKRW"));
        return "index";
    }

}
