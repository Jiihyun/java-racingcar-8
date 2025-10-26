package racingcar.util;

import racingcar.exception.ExceptionMessage;

import java.util.Arrays;
import java.util.List;

public final class Parser {

    private Parser() {
    }

    public static List<String> parseByDelimiter(String expression, String delimiter) {
        return Arrays.stream(expression.split(delimiter))
                .toList();
    }

    public static int parseToInt(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_NUMBER.getMessage());
        }
    }
}
