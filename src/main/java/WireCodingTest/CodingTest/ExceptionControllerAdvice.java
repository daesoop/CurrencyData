package WireCodingTest.CodingTest;

public class ExceptionControllerAdvice extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public ExceptionControllerAdvice() {
        super();
    }

    public ExceptionControllerAdvice(String message) {
        super(message);
    }

    public String getMessage(String s) {
        return s;
    }
}
