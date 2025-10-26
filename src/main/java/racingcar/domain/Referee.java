package racingcar.domain;

import racingcar.domain.car.Car;

import java.util.List;

public class Referee {

    public Winners judge(Cars cars) {
        List<Car> winners = findFastestCars(cars);
        return new Winners(winners.stream()
                .map(Car::getName)
                .toList());
    }

    private List<Car> findFastestCars(Cars cars) {
        Car fastestCar = cars.getFastestCar();
        return cars.findAllTiedWith(fastestCar);
    }
}
