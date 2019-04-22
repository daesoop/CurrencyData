package CurrencyCalculator;

import CurrencyCalculator.country.ReceiveCountry;
import CurrencyCalculator.country.SendCountry;
import CurrencyCalculator.domain.CountryInformation;
import CurrencyCalculator.exception.WrongInputNumber;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CountryInformationExceptionTest {

    private CountryInformation countryInformation;

    @Before
    public void setUp() throws Exception {
        this.countryInformation = new CountryInformation();
    }

    @Test
    public void correctMoney() {
        this.countryInformation.setSendMoney("1000");
        assertThat(this.countryInformation.getSendMoney()).isEqualTo(1000);
    }

    @Test(expected = WrongInputNumber.class)
    public void wrongNumber() {
        this.countryInformation.setSendMoney("10001");
        this.countryInformation.getSendMoney();
    }

    @Test(expected = NumberFormatException.class)
    public void notNumber() {
        this.countryInformation.setSendMoney("test");
        this.countryInformation.getSendMoney();
    }


    @Test
    public void receiveCountry() {
        this.countryInformation.setReceive("한국");
        Assertions.assertThat(this.countryInformation.getReceive()).isEqualTo(ReceiveCountry.한국);
    }

    @Test
    public void sendCountry() {
        this.countryInformation.setSend("미국");
        Assertions.assertThat(this.countryInformation.getSend()).isEqualTo(SendCountry.미국);
    }

}
