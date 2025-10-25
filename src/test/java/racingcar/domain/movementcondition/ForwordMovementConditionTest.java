package racingcar.domain.movementcondition;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class ForwordMovementConditionTest {

    @ParameterizedTest
    @CsvSource(value = {
            "4, TRUE",
            "3, FALSE"
    })
    void 전진_조건을_만족하는지_판단할_수_있다(int number, boolean expectedResult) {
        // given
        ForwordMovementCondition movementCondition = new ForwordMovementCondition();
        // when
        boolean result = movementCondition.isSatisfiedBy(number);
        // then
        assertThat(result).isEqualTo(expectedResult);
    }
}
