package racingcar.domain;

public class ForwordMovementCondition implements MovementCondition {

    private static final int THRESHOLD = 4;

    @Override
    public boolean isSatisfiedBy(int number) {
        return number >= THRESHOLD;
    }
}
