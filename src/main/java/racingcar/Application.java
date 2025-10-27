package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.movementcondition.ForwordMovementCondition;
import racingcar.domain.movementcondition.MovementCondition;
import racingcar.numbergenerator.NumberGenerator;
import racingcar.numbergenerator.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        try {
            InputView inputView = new InputView();
            OutputView outputView = new OutputView();
            NumberGenerator numberGenerator = new RandomNumberGenerator();
            MovementCondition movementCondition = new ForwordMovementCondition();
            RacingGame racingGame = new RacingGame(inputView, outputView, numberGenerator, movementCondition);
            racingGame.run();
        } finally {
            Console.close();
        }
    }
}
