package racingcar.domain;

import racingcar.exception.ExceptionMessage;

public class Round {

    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 25;

    private int value;

    public Round(int value) {
        validate(value);
        this.value = value;
    }

    private void validate(int value) {
        if (isOutOfRange(value)) {
            throw new IllegalArgumentException(ExceptionMessage.ROUND_OUT_OF_RANGE.getMessage());
        }
    }

    private boolean isOutOfRange(int value) {
        return value < MIN_RANGE || value > MAX_RANGE;
    }

    public void finish() {
        if (isLeft()) {
            value -= 1;
        }
        throw new IllegalArgumentException(ExceptionMessage.ROUND_OUT_OF_RANGE.getMessage());
    }

    private boolean isLeft() {
        return value >= MIN_RANGE;
    }

    public int getValue() {
        return value;
    }
}
