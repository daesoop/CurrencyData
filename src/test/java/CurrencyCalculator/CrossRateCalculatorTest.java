package CurrencyCalculator;

import org.junit.Before;
import org.junit.Test;

import java.text.DecimalFormat;

import static org.assertj.core.api.Assertions.assertThat;

public class CrossRateCalculatorTest {

    private double sendMoneyRate;
    private double receiveMoneyRate;
    private double sendMoney;

    @Before
    public void setUp() throws Exception {
        this.sendMoneyRate = Double.parseDouble(String.format("%.2f", 1.344567133));
        System.out.println(sendMoneyRate);
        this.receiveMoneyRate = Double.parseDouble(String.format("%.2f",1135.00));
        System.out.println(receiveMoneyRate);
        this.sendMoney = 1000;
    }

    @Test
    public void crossRate() {
        double rate =  Double.parseDouble(String.format("%.2f" ,847.0149253731342));
        DecimalFormat df = new DecimalFormat("#,##0.00");
        System.out.println(df.format(rate ));
        assertThat(Double.parseDouble(String.format("%.2f",receiveMoneyRate/sendMoneyRate))).isEqualTo(rate);
    }
}
