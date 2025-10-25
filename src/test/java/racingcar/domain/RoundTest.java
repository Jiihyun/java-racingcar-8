package racingcar.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.exception.ExceptionMessage;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RoundTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 25})
    void 시도_횟수를_등록한다(int valueOfRound) {
        // when
        Round round = new Round(valueOfRound);
        // then
        assertThat(round.value()).isEqualTo(valueOfRound);

    }

    @ParameterizedTest
    @ValueSource(ints = {0, 26})
    void 시도_횟수_범위_초과시_예외가_발생한다(int round) {
        // when & then
        assertThatThrownBy(() -> new Round(round))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.ROUND_OUT_OF_RANGE.getMessage());
    }

    @Test
    void 라운드를_감소할_수_있다() {
        // given
        Round round = new Round(2);
        // when
        Optional<Round> decreasedRound = round.decrease();
        // then
        assertThat(decreasedRound).get().extracting(Round::value).isEqualTo(1);
    }

    @Test
    void 라운드가_종료되면_빈_값을_반환한다() {
        // given
        Round round = new Round(1);
        // when
        Optional<Round> decreasedRound = round.decrease();
        // then
        assertThat(decreasedRound).isEmpty();
    }
}
