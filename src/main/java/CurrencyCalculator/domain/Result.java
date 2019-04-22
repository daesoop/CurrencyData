package CurrencyCalculator.domain;

public class Result {
    private boolean valid;

    private String errorMessage;

    private String value;


    private Result(boolean valid, String errorMessage) {
        this.valid = valid;
        this.errorMessage = errorMessage;
    }

    private Result(boolean valid, String errorMessage, String value) {
        this.valid = valid;
        this.errorMessage = errorMessage;
        this.value = value;
    }

    public static Result ok() {
        return new Result(true, null);
    }

    public static Result ok(String value) {
        return new Result(true, null, value);
    }

    public static Result fail(String errorMessage) {
        return new Result(false, errorMessage);
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}