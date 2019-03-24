package WireCodingTest.CodingTest;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class DataOfCurrency {

    private String success;
    private String terms;
    private String privacy;
    private String timestamp;
    private String source;
    private Map<String, String> quotes;

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getTerms() {
        return terms;
    }

    public void setTerms(String terms) {
        this.terms = terms;
    }

    public String getPrivacy() {
        return privacy;
    }

    public void setPrivacy(String privacy) {
        this.privacy = privacy;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Map<String, String> getQuotes() {
        return quotes;
    }

    public void setQuotes(Map<String, String> quotes) {
        this.quotes = quotes;
    }

    @Override
    public String toString() {
        return "DataOfCurrency{" +
                "success='" + success + '\'' +
                ", terms='" + terms + '\'' +
                ", privacy='" + privacy + '\'' +
                ", timestamp='" + timestamp + '\'' +
                ", source='" + source + '\'' +
                ", quotes=" + quotes +
                '}';
    }
}

// {success=true, terms=https://currencylayer.com/terms, privacy=https://currencylayer.com/privacy, timestamp=1553323325, source=USD, quotes={USDAED=3.673042, USDAFN=75.465041, USDALL=110.250403, USDAMD=485.860403, USDANG=1.834704, USDAOA=317.256504, USDARS=41.756041, USDAUD=1.41205, USDAWG=1.801, USDAZN=1.705041, USDBAM=1.73105, USDBBD=1.99665, USDBDT=83.917041, USDBGN=1.731104, USDBHD=0.37725, USDBIF=1831.5, USDBMD=1, USDBND=1.35065, USDBOB=6.90395, USDBRL=3.907504, USDBSD=0.99975, USDBTC=2.5E-4, USDBTN=69.170161, USDBWP=10.702041, USDBYN=2.112104, USDBYR=19600, USDBZD=2.01465, USDCAD=1.344655, USDCDF=1634.000362, USDCHF=0.993185, USDCLF=0.025048, USDCLP=678.903912, USDCNY=6.718104, USDCOP=3088.5, USDCRC=599.570395, USDCUC=1, USDCUP=26.5, USDCVE=97.303897, USDCZK=22.790394, USDDJF=177.720394, USDDKK=6.603504, USDDOP=50.670393, USDDZD=119.030393, USDEGP=17.24604, USDERN=15.000358, USDETB=28.603876, USDEUR=0.883355, USDFJD=2.12504, USDFKP=0.760045, USDGBP=0.756945, USDGEL=2.680391, USDGGP=0.756659, USDGHS=5.103858, USDGIP=0.760045, USDGMD=49.703853, USDGNF=9230.000355, USDGTQ=7.67885, USDGYD=208.65504, USDHKD=7.84762, USDHNL=24.530389, USDHRK=6.57945, USDHTG=83.90304, USDHUF=280.280388, USDIDR=14307.5, USDILS=3.621704, USDIMP=0.756659, USDINR=69.170387, USDIQD=1190, USDIRR=42105.000352, USDISK=119.550386, USDJEP=0.756659, USDJMD=125.110386, USDJOD=0.70904, USDJPY=109.92504, USDKES=100.730504, USDKGS=69.741904, USDKHR=3997.000351, USDKMF=435.875039, USDKPW=900.082329, USDKRW=1135.550384, USDKWD=0.30325, USDKYD=0.83324, USDKZT=378.410383, USDLAK=8585.000349, USDLBP=1507.503779, USDLKR=178.060382, USDLRD=162.503775, USDLSL=14.380382, USDLTL=2.95274, USDLVL=0.60489, USDLYD=1.385039, USDMAD=9.621604, USDMDL=17.268039, USDMGA=3545.000347, USDMKD=54.165039, USDMMK=1522.603753, USDMNT=2616.515069, USDMOP=8.082804, USDMRO=357.000346, USDMUR=34.560379, USDMVR=15.503741, USDMWK=724.000345, USDMXN=19.093039, USDMYR=4.064504, USDMZN=63.375039, USDNAD=14.380377, USDNGN=359.000344, USDNIO=32.850377, USDNOK=8.52041, USDNPR=110.210376, USDNZD=1.453904, USDOMR=0.385305, USDPAB=0.99985, USDPEN=3.297504, USDPGK=3.377504, USDPHP=52.670504, USDPKR=139.650375, USDPLN=3.803704, USDPYG=6147.050374, USDQAR=3.641104, USDRON=4.206504, USDRSD=104.410373, USDRUB=64.60369, USDRWF=895, USDSAR=3.750373, USDSBD=8.088204, USDSCR=13.735504, USDSDG=47.608504, USDSEK=9.284904, USDSGD=1.35261, USDSHP=1.320904, USDSLL=8900.000339, USDSOS=581.000338, USDSRD=7.458038, USDSTD=21050.59961, USDSVC=8.749204, USDSYP=515.000338, USDSZL=14.26037, USDTHB=31.736504, USDTJS=9.44035, USDTMT=3.5, USDTND=3.006038, USDTOP=2.25715, USDTRY=5.763038, USDTTD=6.79105, USDTWD=30.883038, USDTZS=2343.303635, USDUAH=26.899038, USDUGX=3702.650367, USDUSD=1, USDUYU=33.370367, USDUZS=8385.000335, USDVEF=9.987504, USDVND=23199.5, USDVUV=112.001821, USDWST=2.613006, USDXAF=580.580365, USDXAG=0.064792, USDXAU=7.61E-4, USDXCD=2.70265, USDXDR=0.71855, USDXOF=583.000332, USDXPF=106.000332, USDYER=250.350364, USDZAR=14.492504, USDZMK=9001.203593, USDZMW=12.006037, USDZWL=322.355011}}