package WireCodingTest.CodingTest.domain;

import java.util.Map;

//currencylayer.com 에서 가져오는 환율정보들
public class DataOfCurrency {

    private String success;
    private String terms;
    private String privacy;
    private String timestamp;
    private String source;
    private Map<String, Double> quotes;

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

    public Map<String, Double> getQuotes() {
        return quotes;
    }

    public void setQuotes(Map<String, Double> quotes) {
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
