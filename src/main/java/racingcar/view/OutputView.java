package racingcar.view;

import racingcar.domain.MovementResult;
import racingcar.domain.Winners;

import java.util.List;

public class OutputView {

    private static final String RESULT_FORMAT = "%s : %s\n";
    private static final String DASH = "-";
    private static final String WINNER_MESSAGE = "최종 우승자 : ";
    private static final String WINNER_DELIMITER = ", ";

    public void printResultMessage() {
        System.out.println("실행 결과");
    }

    public void printResult(List<MovementResult> result) {
        for (MovementResult movementResult : result) {
            System.out.printf(RESULT_FORMAT, movementResult.name(),
                    DASH.repeat(movementResult.position()));
        }
        System.out.println();
    }

    public void printWinner(Winners winners) {
        System.out.println(WINNER_MESSAGE + String.join(WINNER_DELIMITER, winners.winners()));
    }
}
