package WireCodingTest.CodingTest.domain;

//import WireCodingTest.CodingTest.SendMoney;

import WireCodingTest.CodingTest.ExceptionControllerAdvice;
import WireCodingTest.CodingTest.country.ReceiveCountry;
import WireCodingTest.CodingTest.country.SendCountry;

public class CountryInformation {
    private SendCountry send;
    private ReceiveCountry receive;
    private String sendMoney;

    public SendCountry getSend() {
        return send;
    }

    public void setSend(String send) {
        this.send = SendCountry.valueOf(send);
    }

    public ReceiveCountry getReceive() {
        return receive;
    }

    public void setReceive(String receive) {
        this.receive = ReceiveCountry.valueOf(receive);
    }

    public double getSendMoney() {
        double money = Double.parseDouble(sendMoney);
        if (money <= 0 || money > 10000) {
            throw new ExceptionControllerAdvice("송금액이 바르지 않습니다.");
        }
        return money;
    }

    public void setSendMoney(String sendMoney) {
        this.sendMoney = sendMoney;
    }
}
