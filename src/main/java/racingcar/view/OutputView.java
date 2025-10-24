package racingcar.view;

import racingcar.domain.MovementResult;

import java.util.List;

public class OutputView {

    private static final String RESULT_FORMAT = "%s : %s\n";
    private static final String DASH = "-";

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
}
