package racingcar.controller;

import racingcar.Parser;
import racingcar.domain.Cars;
import racingcar.domain.ForwordMovementCondition;
import racingcar.domain.Race;
import racingcar.domain.RaceHistory;
import racingcar.domain.RandomMovementStrategy;
import racingcar.domain.Referee;
import racingcar.domain.Round;
import racingcar.domain.Winners;
import racingcar.domain.car.Car;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RaceController {

    private final InputView inputView;
    private final OutputView outputView;

    public RaceController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        Cars cars = registerCars();
        Round round = setTotalRound();
        startRace(round, cars);
        judge(cars);
    }

    private Cars registerCars() {
        String carNames = inputView.readCarNames();
        List<String> names = Parser.parseByDelimiter(carNames);
        List<Car> cars = names.stream()
                .map(Car::new)
                .toList();
        return new Cars(cars);
    }

    private Round setTotalRound() {
        int round = inputView.readRound();
        return new Round(round);
    }

    private void startRace(Round round, Cars cars) {
        RandomMovementStrategy movementStrategy = new RandomMovementStrategy(new ForwordMovementCondition());
        Race race = new Race(cars, round, movementStrategy);
        RaceHistory raceHistory = race.start();
        outputView.printResult(raceHistory.history());
    }

    private void judge(Cars cars) {
        Referee referee = new Referee();
        Winners winners = referee.judge(cars);
        outputView.printWinner(winners);
    }
}
