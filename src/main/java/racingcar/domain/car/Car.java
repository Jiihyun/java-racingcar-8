package racingcar.domain.car;

import java.util.Objects;

public class Car {

    private final Name name;
    private final int position;

    public Car(Name name, int position) {
        this.name = name;
        this.position = position;
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
