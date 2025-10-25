package racingcar;

import racingcar.controller.RaceController;
import racingcar.domain.ForwordMovementCondition;
import racingcar.domain.MovementCondition;
import racingcar.domain.NumberGenerator;
import racingcar.domain.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        NumberGenerator numberGenerator = new RandomNumberGenerator();
        MovementCondition movementCondition = new ForwordMovementCondition();
        RaceController raceController = new RaceController(inputView, outputView, numberGenerator, movementCondition);
        raceController.run();
    }
}
