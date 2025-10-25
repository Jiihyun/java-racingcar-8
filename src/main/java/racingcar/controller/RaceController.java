package racingcar.controller;

import racingcar.Parser;
import racingcar.domain.Cars;
import racingcar.domain.MovementCondition;
import racingcar.domain.NumberGenerator;
import racingcar.domain.Race;
import racingcar.domain.RaceHistory;
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

    private final NumberGenerator numberGenerator;
    private final MovementCondition movementCondition;

    public RaceController(InputView inputView, OutputView outputView,
                          NumberGenerator numberGenerator, MovementCondition movementCondition) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.numberGenerator = numberGenerator;
        this.movementCondition = movementCondition;
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
                .map(name -> new Car(numberGenerator, movementCondition, name))
                .toList();
        return new Cars(cars);
    }

    private Round setTotalRound() {
        int round = inputView.readRound();
        return new Round(round);
    }

    private void startRace(Round round, Cars cars) {
        Race race = new Race(cars, round);
        RaceHistory raceHistory = race.start();
        outputView.printResult(raceHistory.history());
    }

    private void judge(Cars cars) {
        Referee referee = new Referee();
        Winners winners = referee.judge(cars);
        outputView.printWinner(winners);
    }
}
