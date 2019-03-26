package WireCodingTest.CodingTest;

import WireCodingTest.CodingTest.country.ReceiveCountry;
import WireCodingTest.CodingTest.country.SendCountry;
import WireCodingTest.CodingTest.domain.Information;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class InformationTest {

    private Information information;

    @Before
    public void setUp() throws Exception {
        this.information = new Information();
    }

    @Test
    public void receiveCountry() {
       this.information.setReceive("한국");
       assertThat(this.information.getReceive()).isEqualTo(ReceiveCountry.한국);
    }

    @Test
    public void sendCountry() {
        this.information.setSend("미국");
        assertThat(this.information.getSend()).isEqualTo(SendCountry.미국);
    }

}
