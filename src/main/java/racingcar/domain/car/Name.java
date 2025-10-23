package racingcar.domain.car;

import racingcar.exception.ExceptionMessage;

public class Name {

    private static final int MIN_LENGTH = 1;
    private static final int MAX_LENGTH = 5;

    private final String value;

    public Name(String value) {
        validate(value);
        this.value = value;
    }

    private void validate(String value) {
        validateLength(value);
    }

    private void validateLength(String value) {
        if (isOutOfRange(value.length())) {
            throw new IllegalArgumentException(ExceptionMessage.CAR_NAME_OUT_OF_RANGE.getMessage());
        }
    }

    private boolean isOutOfRange(int length) {
        return length < MIN_LENGTH || length > MAX_LENGTH;
    }

    public String getValue() {
        return value;
    }
}
