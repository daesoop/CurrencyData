package WireCodingTest.CodingTest;

import WireCodingTest.CodingTest.domain.CountryInformation;
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

    @Test(expected = ExceptionControllerAdvice.class)
    public void wrongNumber() {
        this.countryInformation.setSendMoney("10001");
        this.countryInformation.getSendMoney();
    }

    @Test(expected = NumberFormatException.class)
    public void notNumber() {
        this.countryInformation.setSendMoney("test");
        this.countryInformation.getSendMoney();
    }
}
