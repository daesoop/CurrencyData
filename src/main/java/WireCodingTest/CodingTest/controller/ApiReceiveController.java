package WireCodingTest.CodingTest.controller;

import WireCodingTest.CodingTest.ExceptionControllerAdvice;
import WireCodingTest.CodingTest.domain.CountryInformation;
import WireCodingTest.CodingTest.domain.DataOfCurrency;
import WireCodingTest.CodingTest.domain.Result;
import WireCodingTest.CodingTest.service.ReceiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ApiReceiveController {
    private String endpoint = "live";
    private String access_key = "c1bc6519e38a10b07baed0373c279c94";
    private String resultValue;
    @Autowired
    private ReceiveService receiveService;

    private RestTemplate restTemplate = new RestTemplate();

    @PostMapping("/init")
    public Result init(@RequestBody CountryInformation countryInformation) {
        ResponseEntity<DataOfCurrency> response = restTemplate.getForEntity("http://apilayer.net/api/" + endpoint + "?access_key=" + access_key, DataOfCurrency.class);
        try {
            resultValue = receiveService.inputInfo(countryInformation, response);
        } catch (ExceptionControllerAdvice e) {
            return Result.fail("송금액이 바르지 않습니다.");
        } catch (NumberFormatException e) {
            return Result.fail("숫자를 넣어주세요");
        }
        return Result.ok("수취금액은 : " + resultValue + " " +countryInformation.getReceive().getMoneyType() + "입니다.");
    }
}
