package racingcar.domain;

import racingcar.domain.car.Car;

import java.util.List;

public class Referee {

    public Winners judge(Cars cars) {
        List<Car> winners = getResult(cars);
        return new Winners(winners.stream()
                .map(Car::getName)
                .toList());
    }

    private static List<Car> getResult(Cars cars) {
        int maxPosition = cars.getMaxPosition();
        return cars.findAllLocatedAt(maxPosition);
    }
}
