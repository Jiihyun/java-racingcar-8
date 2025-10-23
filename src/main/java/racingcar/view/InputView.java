package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.exception.ExceptionMessage;

public class InputView {

    private static final String CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ROUND_MESSAGE = "시도할 횟수는 몇 회인가요?";

    public String readCarNames() {
        System.out.println(CAR_NAMES_MESSAGE);
        return readLine();
    }

    public int readRound() {
        System.out.println(ROUND_MESSAGE);
        try {
            return Integer.parseInt(readLine());
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_NUMBER.getMessage());
        }
    }

    private String readLine() {
        return Console.readLine().strip();
    }
}
