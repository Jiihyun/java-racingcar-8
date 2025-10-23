package racingcar.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.exception.ExceptionMessage;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RoundTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 25})
    void 시도_횟수를_등록한다(int valueOfRound) {
        // when
        Round round = new Round(valueOfRound);
        // then
        assertThat(round.getValue()).isEqualTo(valueOfRound);

    }

    @ParameterizedTest
    @ValueSource(ints = {0, 26})
    void 시도_횟수_범위_초과시_예외가_발생한다(int round) {
        // when & then
        assertThatThrownBy(() -> new Round(round))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.ROUND_OUT_OF_RANGE.getMessage());
    }
}
