package racingcar;

import java.util.Arrays;
import java.util.List;

public class Parser {

    private Parser() {
    }

    private static final String DELIMITER = ",";

    public static List<String> parseByDelimiter(String expression) {
        return Arrays.stream(expression.split(DELIMITER))
                .toList();
    }
}
