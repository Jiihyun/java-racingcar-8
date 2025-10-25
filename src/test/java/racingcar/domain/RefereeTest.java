package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;
import racingcar.domain.movementcondition.ForwordMovementCondition;
import racingcar.domain.movementcondition.MovementCondition;
import racingcar.numbergenerator.FixedNumberGenerator;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RefereeTest {

    private MovementCondition movementCondition;

    @BeforeEach
    void setUp() {
        movementCondition = new ForwordMovementCondition();
    }

    @Test
    void 우승자를_판단할_수_있다() {
        // given
        Referee referee = new Referee();

        Car winner1 = createCar(7, "a");
        Car loser = createCar(3, "b");
        Car winner2 = createCar(4, "c");

        Cars cars = new Cars(List.of(winner1, loser, winner2));
        cars.move();
        // when
        Winners winners = referee.judge(cars);
        // then
        assertThat(winners.winners())
                .hasSize(2)
                .containsExactlyInAnyOrder(winner1.getName(), winner2.getName());
    }

    private Car createCar(int number, String name) {
        FixedNumberGenerator numberGenerator = new FixedNumberGenerator(number);
        return new Car(numberGenerator, movementCondition, name);
    }
}
