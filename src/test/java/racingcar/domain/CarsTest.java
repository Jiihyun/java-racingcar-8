package racingcar.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.domain.car.Car;
import racingcar.domain.car.Name;
import racingcar.exception.ExceptionMessage;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarsTest {

    @ParameterizedTest
    @MethodSource("provideCars")
    void 자동차_등록_범위_초과시_예외가_발생한다(List<Car> cars) {
        // when & then
        assertThatThrownBy(() -> new Cars(cars))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.CARS_OUT_OF_RANGE.getMessage());
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

    private static Car createCar(String valueOfName) {
        Name name = new Name(valueOfName);
        return new Car(name, 0);
    }
}
