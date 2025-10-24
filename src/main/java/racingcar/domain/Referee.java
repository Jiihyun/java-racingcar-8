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

    private List<Car> getResult(Cars cars) {
        Car fastestCar = cars.getFastestCar();
        return cars.findAllTiedWith(fastestCar);
    }
}
