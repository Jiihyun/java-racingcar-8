package racingcar;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class ParserTest {

    @Test
    void 구분자를_기준으로_문자열을_분리한다() {
        // given
        String expression = "a,b,c";
        // when
        List<String> parsedExpression = Parser.parseByDelimiter(expression);
        // then
        assertAll(
                () -> assertThat(parsedExpression).hasSize(3),
                () -> assertThat(parsedExpression.getFirst()).isEqualTo("a"),
                () -> assertThat(parsedExpression.getLast()).isEqualTo("c")
        );
    }

}
