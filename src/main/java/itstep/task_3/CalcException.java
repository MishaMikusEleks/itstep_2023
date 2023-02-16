package itstep.task_3;

public class CalcException extends Exception {
    public CalcException(String message) {
        super(message);
        System.err.println(message);
    }
}
