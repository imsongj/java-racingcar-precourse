package racingcar.view;

import java.util.List;
import java.util.StringJoiner;
import racingcar.model.CarInformation;

public class OutputView {
    private static final String RESULT_FORMAT = "%s : %s";
    private static final String POSITION_SYMBOL = "-";
    private static final String DELIMITER = ", ";
    private static final String WINNER_FORMAT = "최종 우승자 : %s";

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printResult(List<CarInformation> result) {
        for (CarInformation carInformation : result) {
            System.out.println(convertCarInformationToString(carInformation));
        }
        printEmptyLine();
    }

    public void printWinners(List<String> winners) {
        System.out.println(convertWinnersToString(winners));
    }

    public String convertWinnersToString(List<String> winners) {
        StringJoiner stringJoiner = new StringJoiner(DELIMITER);
        for (String winner : winners) {
            stringJoiner.add(winner);
        }
        return String.format(WINNER_FORMAT, stringJoiner);
    }

    public String convertCarInformationToString(CarInformation carInformation) {
        return String.format(RESULT_FORMAT, carInformation.getName(),
                convertPositionToString(carInformation.getPosition()));
    }

    public String convertPositionToString(int position) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int count = 0; count < position; count++) {
            stringBuilder.append(POSITION_SYMBOL);
        }
        return stringBuilder.toString();
    }

    public void printEmptyLine() {
        System.out.println();
    }
}
