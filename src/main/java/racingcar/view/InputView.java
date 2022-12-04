package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
public class InputView {
    OutputView outputView;
    public InputView() {
        outputView = new OutputView();
    }

    public String readCarNames() {
        outputView.printMessage(GameMessage.ASK_NAMES);
        return Console.readLine();
    }

    public String readAttempts() {
        outputView.printMessage(GameMessage.ASK_ATTEMPTS);
        return Console.readLine();
    }
}
