package racingcar.domain;

import racingcar.exception.ExceptionMessage;

import java.util.Optional;

public record Round(
        int value
) {
    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 25;

    public Round {
        validate(value);
    }

    private void validate(int value) {
        if (isOutOfRange(value)) {
            throw new IllegalArgumentException(ExceptionMessage.ROUND_OUT_OF_RANGE.getMessage());
        }
    }

    private boolean isOutOfRange(int value) {
        return value < MIN_RANGE || value > MAX_RANGE;
    }

    public Optional<Round> decrease() {
        if (isFinalRound()) {
            return Optional.empty();
        }
        return Optional.of(new Round(value - 1));
    }

    private boolean isFinalRound() {
        return value == MIN_RANGE;
    }
}
