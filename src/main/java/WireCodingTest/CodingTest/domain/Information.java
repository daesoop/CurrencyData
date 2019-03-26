package WireCodingTest.CodingTest.domain;

import WireCodingTest.CodingTest.country.ReceiveCountry;
import WireCodingTest.CodingTest.country.SendCountry;

public class Information {
    private SendCountry send;
    private ReceiveCountry receive;
    private int sendMoney;

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

    public int getSendMoney() {
        return sendMoney;
    }

    public void setSendMoney(int sendMoney) {
        this.sendMoney = sendMoney;
    }
}
