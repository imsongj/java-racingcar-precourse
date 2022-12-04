package racingcar.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import racingcar.model.CarStatistic;
import racingcar.model.Validator;
import racingcar.view.ErrorMessage;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
    public static final String DELIMITER = ",";
    InputView inputView;
    OutputView outputView;

    public GameController() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void start() {
        getNames();
    }

    public void initializeCarGame() {

    }

    public List<String> getNames() {
        List<String> names;
        do {
            String input = inputView.readCarNames();
            names = Stream.of(input.split(DELIMITER))
                    .map(String::trim)
                    .collect(Collectors.toList());
        } while (isInvalidName(names)) ;
        return names;
    }

    public boolean isInvalidName(List<String> names) {
        try {
            Validator.validateNames(names,
                    CarStatistic.MIN_NAME_LENGTH.getValue(), CarStatistic.MAX_NAME_LENGTH.getValue());
            return false;
        } catch (IllegalArgumentException exception) {
            exception.printStackTrace();
            outputView.printMessage(ErrorMessage.INVALID_NAMES);
            return true;
        }
    }
}
