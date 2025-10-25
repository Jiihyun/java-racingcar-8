package racingcar.domain.car;

import racingcar.exception.ExceptionMessage;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public record Name(String value) {

    private static final int MIN_LENGTH = 1;
    private static final int MAX_LENGTH = 5;
    private static final Pattern FORMAT_PATTERN = Pattern.compile("^[a-zA-Z가-힣]+$");

    public Name {
        validate(value);
    }

    private void validate(String value) {
        validateLength(value);
        validateFormat(value);
    }

    private void validateLength(String value) {
        if (value.isBlank()) {
            throw new IllegalArgumentException(ExceptionMessage.EMPTY_CAR_NAME.getMessage());
        }
        if (isOutOfRange(value.length())) {
            throw new IllegalArgumentException(ExceptionMessage.CAR_NAME_OUT_OF_RANGE.getMessage());
        }
    }

    private boolean isOutOfRange(int length) {
        return length < MIN_LENGTH || length > MAX_LENGTH;
    }

    private void validateFormat(String value) {
        Matcher matcher = FORMAT_PATTERN.matcher(value);
        if (!matcher.matches()) {
            throw new IllegalArgumentException(ExceptionMessage.CAR_NAME_WRONG_FORMAT.getMessage());
        }
    }
}
