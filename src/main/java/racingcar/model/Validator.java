package racingcar.model;

import java.util.List;
import java.util.regex.Pattern;

public class Validator {
    private static final String PATTERN = "^[0-9]*$";

    public static void validateNames(List<String> names, int minLength, int maxLength) {
        for (String name : names) {
            if (name.length() < minLength || name.length() > maxLength) {
                throw new IllegalArgumentException();
            }
        }
    }

    public static void validateAttempts(String input) {
        validateNumeric(input);
        validateInteger(input);
        validateRange(input);
    }

    public static void validateNumeric(String input) {
        if (input == null || !Pattern.matches(PATTERN, input)) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateRange(String input) {
        if (Integer.parseInt(input) < GameStatistic.MIN_ATTEMPTS) {
            throw new IllegalArgumentException();
        }
    }
}
