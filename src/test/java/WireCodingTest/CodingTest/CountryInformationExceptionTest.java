package WireCodingTest.CodingTest;

import WireCodingTest.CodingTest.country.ReceiveCountry;
import WireCodingTest.CodingTest.country.SendCountry;
import WireCodingTest.CodingTest.domain.CountryInformation;
import WireCodingTest.CodingTest.exception.WrongInputNumber;
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
        assertThat(this.countryInformation.getReceive()).isEqualTo(ReceiveCountry.한국);
    }

    @Test
    public void sendCountry() {
        this.countryInformation.setSend("미국");
        assertThat(this.countryInformation.getSend()).isEqualTo(SendCountry.미국);
    }

}
