package racingcar.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import racingcar.model.GameStatistic;
import racingcar.model.RacingCarGame;
import racingcar.model.Validator;
import racingcar.view.ErrorMessage;
import racingcar.view.GameMessage;
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
        RacingCarGame racingCarGame = new RacingCarGame();
        racingCarGame.initializeCars(getNames());
        outputView.printMessage(GameMessage.RESULT_HEADER);
        processAttempts(racingCarGame, getAttempts());
        outputView.printWinners(racingCarGame.getWinner());
    }

    public void processAttempts(RacingCarGame racingCarGame, int attempts) {
        while (!racingCarGame.doesAttemptEqualTo(attempts)) {
            racingCarGame.moveCars();
            outputView.printResult(racingCarGame.getResult());
        }
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
                    GameStatistic.MIN_NAME_LENGTH, GameStatistic.MAX_NAME_LENGTH);
            return false;
        } catch (IllegalArgumentException exception) {
            exception.printStackTrace();
            outputView.printMessage(ErrorMessage.INVALID_NAMES);
            return true;
        }
    }

    public int getAttempts() {
        String input;
        do {
            input = inputView.readAttempts();
        } while (isInvalidAttempts(input)) ;
        return Integer.parseInt(input);
    }

    public boolean isInvalidAttempts(String input) {
        try {
            Validator.validateAttempts(input);
            return false;
        } catch (IllegalArgumentException exception) {
            exception.printStackTrace();
            outputView.printMessage(ErrorMessage.INVALID_ATTEMPTS);
            return true;
        }
    }
}
