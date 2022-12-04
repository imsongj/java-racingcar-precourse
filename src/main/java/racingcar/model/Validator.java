package racingcar.model;

import java.util.List;
import java.util.stream.Stream;

public class Validator {
    public static void validateNames(List<String> names, int minLength, int maxLength) {
        for (String name : names) {
            if (name.length() < minLength || name.length() > maxLength) {
                throw new IllegalArgumentException();
            }
        }
    }
}
