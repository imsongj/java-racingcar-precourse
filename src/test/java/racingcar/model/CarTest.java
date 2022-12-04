package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class CarTest {
    @ParameterizedTest
    @MethodSource("provideParametersForCar")
    @DisplayName("자동차를 이동하거나 멈춘다.")
    void throwExceptionForInvalidName(int number, int position) {
        Car car = new Car("");
        car.move(number);
        assertThat(car.getCarInformation().getPosition()).isEqualTo(position);
    }

    private static Stream<Arguments> provideParametersForCar() {
        return Stream.of(
                Arguments.of(6, 1),
                Arguments.of(3, 0)
        );
    }
}
