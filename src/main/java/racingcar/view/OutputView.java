package racingcar.view;

import racingcar.dto.CarResult;
import racingcar.dto.RoundResult;
import racingcar.dto.Winners;

import java.util.List;

public class OutputView {

    private static final String RESULT_FORMAT = "%s : %s" + System.lineSeparator();
    private static final String DASH = "-";
    private static final String WINNER_DELIMITER = ", ";

    public void printResult(List<RoundResult> history) {
        printResultMessage();
        history.forEach(this::printEachRound);
    }

    private void printResultMessage() {
        System.out.println(System.lineSeparator() + "실행 결과");
    }

    private void printEachRound(RoundResult roundResult) {
        for (CarResult carResult : roundResult.roundResult()) {
            System.out.printf(RESULT_FORMAT,
                    carResult.name(), DASH.repeat(carResult.position()));
        }
        System.out.println();
    }

    public void printWinner(Winners winners) {
        System.out.println("최종 우승자 : " + String.join(WINNER_DELIMITER, winners.winners()));
    }
}
