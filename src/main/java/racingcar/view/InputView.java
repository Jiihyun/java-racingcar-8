package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.exception.ExceptionMessage;
import racingcar.util.Parser;

import java.util.List;

public class InputView {

    private static final String CAR_NAME_DELIMITER = ",";

    public List<String> readCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = readLine();
        return Parser.parseByDelimiter(input, CAR_NAME_DELIMITER);
    }

    public int readRound() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String input = readLine();
        return Parser.parseToInt(input);
    }

    private String readLine() {
        String input = Console.readLine().strip();
        validateInput(input);
        return input;
    }

    private void validateInput(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(ExceptionMessage.BLANK_INPUT.getMessage());
        }
    }
}
