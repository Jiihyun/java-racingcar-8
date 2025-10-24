package racingcar.domain.car;

import racingcar.domain.MovementResult;
import racingcar.domain.MovementStrategy;

import java.util.Objects;

public class Car {

    private final Name name;
    private int position;

    public Car(String name) {
        this.name = new Name(name);
        this.position = 0;
    }

    public MovementResult move(MovementStrategy movementStrategy) {
        if (movementStrategy.canMove()) {
            this.position += 1;
        }
        return new MovementResult(name.getValue(), position);
    }

    public boolean hasSamePositionWith(int position) {
        return this.position == position;
    }

    public String getName() {
        return name.getValue();
    }

    public int getPosition() {
        return position;
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
