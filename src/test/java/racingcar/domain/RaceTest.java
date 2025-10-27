package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;
import racingcar.domain.movementcondition.ForwordMovementCondition;
import racingcar.domain.movementcondition.MovementCondition;
import racingcar.dto.CarResult;
import racingcar.dto.RaceHistory;
import racingcar.numbergenerator.FixedNumberGenerator;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.tuple;
import static org.junit.jupiter.api.Assertions.assertAll;

class RaceTest {

    private MovementCondition movementCondition;

    @BeforeEach
    void setUp() {
        movementCondition = new ForwordMovementCondition();
    }

    @Test
    void test() {
        // given
        Car winner = createCar(7, "a");
        Car loser = createCar(3, "b");

        Cars cars = new Cars(List.of(winner, loser));
        Round round = new Round(1);
        Race race = new Race(cars, round);
        // when
        RaceHistory raceHistory = race.start();
        // then
        assertAll(
                () -> assertThat(raceHistory.history()).hasSize(1),
                () -> assertThat(raceHistory.history().getLast().roundResult())
                        .extracting(CarResult::name, CarResult::position)
                        .containsExactlyInAnyOrder(
                                tuple("a", 1),
                                tuple("b", 0)
                        )
        );
    }

    private Car createCar(int number, String name) {
        FixedNumberGenerator numberGenerator = new FixedNumberGenerator(number);
        return new Car(numberGenerator, movementCondition, name);
    }
}
