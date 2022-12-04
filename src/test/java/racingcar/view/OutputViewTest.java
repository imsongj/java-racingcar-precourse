package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.model.CarInformation;

public class OutputViewTest {
    @ParameterizedTest
    @MethodSource("provideParametersForResult")
    @DisplayName("결과를 출력한다.")
    void convertResultToString(CarInformation carInformation, String result) {
        assertThat(new OutputView().convertCarInformationToString(carInformation))
                .isEqualTo(result);
    }

    private static Stream<Arguments> provideParametersForResult() {
        return Stream.of(
                Arguments.of(new CarInformation("jim", 3), "jim : ---"),
                Arguments.of(new CarInformation("bob", 5), "bob : -----")
        );
    }

    @ParameterizedTest
    @MethodSource("provideParametersForWinner")
    @DisplayName("우승자를 출력한다.")
    void convertResultToString(List<String> winners, String result) {
        assertThat(new OutputView().convertWinnersToString(winners))
                .isEqualTo(result);
    }

    private static Stream<Arguments> provideParametersForWinner() {
        return Stream.of(
                Arguments.of(Arrays.asList("jim", "bob"), "jim, bob"),
                Arguments.of(Arrays.asList("bob"), "bob")
        );
    }
}
