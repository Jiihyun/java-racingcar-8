package racingcar.domain.car;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.CarResult;
import racingcar.domain.movementcondition.ForwordMovementCondition;
import racingcar.domain.movementcondition.MovementCondition;
import racingcar.numbergenerator.FixedNumberGenerator;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    private MovementCondition movementCondition;

    @BeforeEach
    void setUp() {
        movementCondition = new ForwordMovementCondition();
    }

    @Test
    void 이동_조건을_만족하면_자동차를_움직일_수_있다() {
        // given
        Car car = createCar(4, "a");
        // when
        CarResult result = car.move();
        // then
        assertThat(result.position()).isEqualTo(1);
    }

    @Test
    void 이동_조건을_만족하지_못하면_자동차를_움직일_수_없다() {
        // given
        Car car = createCar(3, "a");
        // when
        CarResult result = car.move();
        // then
        assertThat(result.position()).isZero();
    }

    @Test
    void 두_자동차_위치가_같은지_구분할_수_있다() {
        // given
        Car car1 = createCar(5, "a");
        Car car2 = createCar(6, "b");
        // when
        boolean hasSamePosition = car1.hasSamePositionWith(car2);
        // then
        assertThat(hasSamePosition).isTrue();
    }

    @Test
    void 두_자동차_위치가_다른지_구분할_수_있다() {
        // given
        Car car1 = createCar(7, "a");
        Car car2 = createCar(7, "b");
        car1.move();
        // when
        boolean hasSamePosition = car1.hasSamePositionWith(car2);
        // then
        assertThat(hasSamePosition).isFalse();
    }

    @Test
    void 자동차가_다른_자동차보다_앞에_있는지_확인할_수_있다() {
        // given
        Car car1 = createCar(8, "a");
        Car car2 = createCar(2, "b");
        car1.move();
        // when
        boolean isAheadOf = car1.isAheadOf(car2);
        // then
        assertThat(isAheadOf).isTrue();
    }

    @Test
    void 자동차_이름이_서로_같으면_동일한_자동차로_판단한다() {
        // given
        Car car1 = createCar(1, "a");
        Car car2 = createCar(1, "a");
        // when & then
        assertThat(car1).isEqualTo(car2);
    }

    private Car createCar(int number, String name) {
        FixedNumberGenerator numberGenerator = new FixedNumberGenerator(number);
        return new Car(numberGenerator, movementCondition, name);
    }
}
