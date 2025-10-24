package racingcar.domain;

public class RandomMovementStrategy implements MovementStrategy {

    private final ForwordMovementCondition movementCondition;

    public RandomMovementStrategy(ForwordMovementCondition movementCondition) {
        this.movementCondition = movementCondition;
    }

    @Override
    public boolean canMove() {
        int number = RandomNumberGenerator.pickNumber();
        return movementCondition.isSatisfiedBy(number);
    }
}
