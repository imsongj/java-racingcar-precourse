package racingcar.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

public class ValidatorTest {
    @ParameterizedTest
    @MethodSource("provideParametersForNames")
    @DisplayName("잘못된 이름을 입력하면 예외를 발생시킨다.")
    void throwExceptionForInvalidName(List<String> names) {
        assertThatThrownBy(() -> Validator.validateNames(names,
                CarStatistic.MIN_NAME_LENGTH.getValue(), CarStatistic.MAX_NAME_LENGTH.getValue()))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> provideParametersForNames() {
        return Stream.of(
                Arguments.of(Arrays.asList("jim", "andrew", "bob")),
                Arguments.of(Arrays.asList("jim", "", "bob"))
        );
    }

    @ParameterizedTest
    @CsvSource({
            "abc",
            "12vv",
            "+42",
            "10000000000"
    })
    @DisplayName("잘못된 시도 회수를 입력하면 예외를 발생시킨다.")
    void throwExceptionForInvalidAttempts(String input) {
        assertThatThrownBy(() -> Validator.validateAttempts(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
