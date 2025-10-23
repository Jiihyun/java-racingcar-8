package racingcar.exception;

public enum ExceptionMessage {

    NOT_NUMBER("숫자만 입력 가능합니다."),
    EMPTY_CAR_NAME("자동차 이름은 빈문자열일 수 없습니다."),
    CAR_NAME_OUT_OF_RANGE("입력 가능한 자동차 이름 길이 범위를 초과하였습니다."),
    CAR_NAME_WRONG_FORMAT("잘못된 자동차 이름 형식입니다."),
    CARS_OUT_OF_RANGE("자동차 등록 범위를 초과하였습니다."),
    DUPLICATED_CAR("동일한 자동차가 이미 존재합니다."),
    ROUND_OUT_OF_RANGE("시도 횟수 등록 범위를 초과하였습니다."),
    ;

    private static final String EXCEPTION_PREFIX = "[ERROR] ";

    private final String message;

    ExceptionMessage(String message) {
        this.message = EXCEPTION_PREFIX + message;
    }

    public String getMessage() {
        return message;
    }
}
