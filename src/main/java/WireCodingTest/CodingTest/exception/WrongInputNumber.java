package WireCodingTest.CodingTest.exception;

public class WrongInputNumber extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public WrongInputNumber() {
        super();
    }

    public WrongInputNumber(String message) {
        super(message);
    }

    public String getMessage(String s) {
        return s;
    }
}
