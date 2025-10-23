package racingcar.domain;

import racingcar.domain.car.Car;
import racingcar.exception.ExceptionMessage;

import java.util.List;

public class Cars {

    private static final int MIN_RANGE = 2;
    private static final int MAX_RANGE = 10;

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        validateRange(cars);
        this.cars = cars;
    }

    private void validateRange(List<Car> cars) {
        int size = cars.size();
        if (isOutOfRange(size)) {
            throw new IllegalArgumentException(ExceptionMessage.CARS_OUT_OF_RANGE.getMessage());
        }
    }

    private boolean isOutOfRange(int size) {
        return size < MIN_RANGE || size > MAX_RANGE;
    }
}
