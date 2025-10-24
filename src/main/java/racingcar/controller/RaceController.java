package racingcar.controller;

import racingcar.Parser;
import racingcar.domain.Cars;
import racingcar.domain.ForwordMovementCondition;
import racingcar.domain.MovementResult;
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

        outputView.printResultMessage();
        while (round.isLeft()) {
            List<MovementResult> result = cars.move(new RandomMovementStrategy(new ForwordMovementCondition()));
            round.finish();
            outputView.printResult(result);
        }

        Referee referee = new Referee();
        Winners winners = referee.judge(cars);
        outputView.printWinner(winners);
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
}
