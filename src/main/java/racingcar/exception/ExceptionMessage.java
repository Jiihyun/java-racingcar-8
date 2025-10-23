package racingcar.exception;

public enum ExceptionMessage {

    NOT_NUMBER("숫자만 입력 가능합니다.");

    private static final String EXCEPTION_PREFIX = "[ERROR] ";

    private final String message;

    ExceptionMessage(String message) {
        this.message = EXCEPTION_PREFIX + message;
    }

    public String getMessage() {
        return message;
    }
}
