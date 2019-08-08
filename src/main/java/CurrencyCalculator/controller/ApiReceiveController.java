package CurrencyCalculator.controller;

import CurrencyCalculator.exception.WrongInputNumber;
import CurrencyCalculator.domain.CountryInformation;
import CurrencyCalculator.domain.DataOfCurrency;
import CurrencyCalculator.domain.Result;
import CurrencyCalculator.service.ReceiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ApiReceiveController {
    private String resultValue;

    //currencylayer.com의 access key 와 엔드포인트 담은 url
    @Value("${currencyLayer.api.uri}")
    private String currencyLayerURI;

    @Autowired
    private ReceiveService receiveService;

    private RestTemplate restTemplate = new RestTemplate();

    //송금국가와 수취국가 환율정보 갖고 온 후 송금금액 출력
    @PostMapping("/calculateMoney")
    public Result calculateMoney(@RequestBody CountryInformation countryInformation) {
        ResponseEntity<DataOfCurrency> response = restTemplate.getForEntity(currencyLayerURI, DataOfCurrency.class);
        try {
            resultValue = receiveService.sendMoneyInfo(countryInformation, response);
        } catch (WrongInputNumber e) {
            return Result.fail("송금액이 잘못 되었습니다.");
        } catch (NumberFormatException e) {
            return Result.fail("숫자를 넣어주세요");
        }
        return Result.ok("수취금액은 : " + resultValue + " " +countryInformation.getReceive().getMoneyType() + "입니다.");
    }

    //송금국가 및 수취국가 변경시 환율정보 새로 가져오기
    @PostMapping("Rate")
    public String crossRate(@RequestBody CountryInformation crossRateInfo) {
        ResponseEntity<DataOfCurrency> response = restTemplate.getForEntity(currencyLayerURI, DataOfCurrency.class);
        return "환율 : " + receiveService.currencyInfo(crossRateInfo, response) + " " +crossRateInfo.getReceive().getMoneyType() ;
    }

}
