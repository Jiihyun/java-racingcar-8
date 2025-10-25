package racingcar.domain.car;

import racingcar.domain.CarResult;
import racingcar.domain.MovementCondition;
import racingcar.domain.NumberGenerator;

import java.util.Objects;

public class Car {

    private static final int START_POSITION = 0;

    private final NumberGenerator numberGenerator;
    private final MovementCondition movementCondition;
    private final Name name;
    private int position;

    public Car(NumberGenerator numberGenerator, MovementCondition movementCondition, String name) {
        this.numberGenerator = numberGenerator;
        this.movementCondition = movementCondition;
        this.name = new Name(name);
        this.position = START_POSITION;
    }

    public CarResult move() {
        int number = numberGenerator.generate();
        if (movementCondition.isSatisfiedBy(number)) {
            this.position++;
        }
        return new CarResult(name.value(), position);
    }

    public boolean hasSamePositionWith(Car other) {
        return this.position == other.position;
    }

    public boolean isAheadOf(Car other) {
        return this.position > other.position;
    }

    public String getName() {
        return name.value();
    }

    @Override
    public final boolean equals(final Object o) {
        if (!(o instanceof final Car car)) {
            return false;
        }

        return Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
