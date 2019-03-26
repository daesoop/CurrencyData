package WireCodingTest.CodingTest.controller;

import WireCodingTest.CodingTest.country.ReceiveCountry;
import WireCodingTest.CodingTest.country.SendCountry;
import WireCodingTest.CodingTest.domain.DataOfCurrency;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import java.text.DecimalFormat;
import java.util.Map;

@Controller
public class MainContorller {

    private String endpoint = "live";
    private String access_key = "c1bc6519e38a10b07baed0373c279c94";

    private RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/")
    public String home(Model model) {
        ResponseEntity<DataOfCurrency> forEntity = restTemplate.getForEntity("http://apilayer.net/api/" + endpoint + "?access_key=" + access_key, DataOfCurrency.class);
        Map<String, Double> currencyInformation = forEntity.getBody().getQuotes();
        DecimalFormat df = new DecimalFormat("#,##0.00");
        model.addAttribute("koreaWon", df.format(currencyInformation.get("USDKRW")));
        model.addAttribute("sendCountries", SendCountry.getCountry());
        model.addAttribute("receiveCountries", ReceiveCountry.getCountry());
        return "index";
    }

}
