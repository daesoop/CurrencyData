package CurrencyCalculator.controller;

import CurrencyCalculator.country.SendCountry;
import CurrencyCalculator.country.ReceiveCountry;
import CurrencyCalculator.domain.DataOfCurrency;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import java.text.DecimalFormat;
import java.util.Map;

@Controller
public class MainContorller {

    private RestTemplate restTemplate = new RestTemplate();

    //currencylayer.com의 access key 와 엔드포인트 담은 url
    @Value("${currencyLayer.api.uri}")
    private String currencyLayerURI;

    @GetMapping("/")
    public String home(Model model) {
        ResponseEntity<DataOfCurrency> forEntity = restTemplate.getForEntity(currencyLayerURI, DataOfCurrency.class);
        Map<String, Double> currencyInformation = forEntity.getBody().getQuotes();
        DecimalFormat df = new DecimalFormat("#,##0.00");
        model.addAttribute("crossRate", df.format(currencyInformation.get("USDKRW")));
        model.addAttribute("sendCountries", SendCountry.getCountry());
        model.addAttribute("receiveCountries", ReceiveCountry.getCountry());
        return "index";
    }

    @GetMapping("/lasttest")
    public String lasttest() {
        return "lastTest";
    }

    @GetMapping("/testing")
    public String test() {
        return "vueTest";
    }

    @GetMapping("/testDrag")
    public String testdrag() { return "test"; }

    @GetMapping("/testtest")
    public String testtest() {
        return "testtest";
    }

    @GetMapping("/testsoop")
    public String testsoop() {
        return "testsoop";
    }

}
