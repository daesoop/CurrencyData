package CurrencyCalculator.domain;

import CurrencyCalculator.country.ReceiveCountry;
import CurrencyCalculator.country.SendCountry;
import CurrencyCalculator.exception.WrongInputNumber;

public class CountryInformation {
    private SendCountry send;
    private ReceiveCountry receive;
    private String sendMoney;

    public SendCountry getSend() {
        return send;
    }

    //송금나라 이넘 이름과 비교해서 지정하기
    public void setSend(String send) {
        this.send = SendCountry.valueOf(send);
    }

    public ReceiveCountry getReceive() {
        return receive;
    }

    //수취나라 이넘 이름과 비교해서 지정하기.
    public void setReceive(String receive) {
        this.receive = ReceiveCountry.valueOf(receive);
    }

    //보낼 금액이 10000보다 많거나 0보다 작거나 같으면 에러 발생.
    public double getSendMoney() {
        double money = Double.parseDouble(sendMoney);
        if (money <= 0 || money > 10000) {
            throw new WrongInputNumber("송금액이 바르지 않습니다.");
        }
        return money;
    }

    public void setSendMoney(String sendMoney) {
        this.sendMoney = sendMoney;
    }

    @Override
    public String toString() {
        return "CountryInformation{" +
                "send=" + send +
                ", receive=" + receive +
                ", inputMoneyRate='" + sendMoney + '\'' +
                '}';
    }
}
