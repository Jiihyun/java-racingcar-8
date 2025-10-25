package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.domain.car.Car;
import racingcar.exception.ExceptionMessage;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

class CarsTest {

    private MovementCondition movementCondition;

    @BeforeEach
    void setUp() {
        movementCondition = new ForwordMovementCondition();
    }

    @ParameterizedTest
    @MethodSource("provideCars")
    void 자동차_등록_범위_초과시_예외가_발생한다(List<Car> cars) {
        // when & then
        assertThatThrownBy(() -> new Cars(cars))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.CARS_OUT_OF_RANGE.getMessage());
    }

    private static Stream<Arguments> provideCars() {
        Car car1 = createCar("a");
        Car car2 = createCar("b");
        Car car3 = createCar("c");
        Car car4 = createCar("d");
        Car car5 = createCar("e");
        Car car6 = createCar("f");
        Car car7 = createCar("g");
        Car car8 = createCar("h");
        Car car9 = createCar("i");
        Car car10 = createCar("j");
        Car car11 = createCar("k");

        return Stream.of(
                Arguments.of(List.of(car1)),
                Arguments.of(List.of(car1, car2, car3, car4, car5, car6, car7, car8, car9, car10, car11))
        );
    }

    private static Car createCar(String name) {
        FixedNumberGenerator numberGenerator = new FixedNumberGenerator(5);
        return new Car(numberGenerator, new ForwordMovementCondition(), name);
    }

    @Test
    void 이름이_동일한_자동차가_중복될시_예외가_발생한다() {
        // given
        String name = "nana";
        Car car1 = createCar(name);
        Car car2 = createCar(name);
        List<Car> cars = List.of(car1, car2);
        // when & then
        assertThatThrownBy(() -> new Cars(cars))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.DUPLICATED_CAR.getMessage());
    }

    @Test
    void 자동차들을_이동시킬_수_있다() {
        // given
        Cars cars = new Cars(List.of(createCar(1, "a"), createCar(6, "b")));
        // when
        RoundResult roundResult = cars.move();
        // then
        assertAll(
                () -> assertThat(roundResult.roundResult().getFirst().position()).isZero(),
                () -> assertThat(roundResult.roundResult().getLast().position()).isEqualTo(1)
        );
    }

    @Test
    void 가장_빠른_자동차를_구할_수_있다() {
        // given
        Car expectedCar = createCar(6, "b");
        Car car = createCar(1, "a");
        Cars cars = new Cars(List.of(car, expectedCar));
        cars.move();
        // when
        Car fastestCar = cars.getFastestCar();
        // then
        assertThat(fastestCar).isEqualTo(expectedCar);
    }

    @Test
    void 동일한_위치에_있는_자동차들을_구할_수_있다() {
        // given
        Car standardCar = createCar("기준");
        Car carA = createCar("a");
        Car carB = createCar("b");
        Cars cars = new Cars(List.of(carA, carB));
        // when
        List<Car> tiedCars = cars.findAllTiedWith(standardCar);
        // then
        assertAll(
                () -> assertThat(tiedCars).hasSize(2),
                () -> assertThat(tiedCars.getFirst()).isEqualTo(carA),
                () -> assertThat(tiedCars.getLast()).isEqualTo(carB)
        );
    }

    private Car createCar(int number, String name) {
        FixedNumberGenerator numberGenerator = new FixedNumberGenerator(number);
        return new Car(numberGenerator, movementCondition, name);
    }
}
