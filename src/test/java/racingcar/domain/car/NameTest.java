package racingcar.domain.car;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.exception.ExceptionMessage;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NameTest {

    @ParameterizedTest
    @ValueSource(strings = {"apple", "자동차", "고"})
    void 자동차_이름을_등록한다(String name) {
        // when
        Name result = new Name(name);
        // then
        assertThat(result.getValue()).isEqualTo(name);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "   ", "\t", "\n"})
    void 자동차_이름이_빈_문자열이면_예외가_발생한다(String name) {
        // when & then
        assertThatThrownBy(() -> new Name(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.EMPTY_CAR_NAME.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"banana", "가나다라마바"})
    void 자동차_이름의_길이가_범위_초과시_예외가_발생한다(String name) {
        // when & then
        assertThatThrownBy(() -> new Name(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.CAR_NAME_OUT_OF_RANGE.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"사과1", "사 과", "사+과", "a1", "jii_"})
    void 잘못된_형식의_자동차_이름이면_예외가_발생한다(String name) {
        // when & then
        assertThatThrownBy(() -> new Name(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.CAR_NAME_WRONG_FORMAT.getMessage());
    }
}
