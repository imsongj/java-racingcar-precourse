package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RacingCarGame {
    private final List<Car> cars;
    private int attempts;

    public RacingCarGame() {
        cars = new ArrayList<>();
        attempts = 0;
    }

    public void initializeCars(List<String> names) {
        for (String name : names) {
            cars.add(new Car(name));
        }
    }

    private void incrementAttempts() {
        attempts++;
    }

    public void moveCars() {
        for (Car car : cars) {
            car.move(generateRandomNumber());
        }
        incrementAttempts();
    }

    public Result getResult() {
        List<CarInformation> result = new ArrayList<>();
        for (Car car : cars) {
            result.add(car.getCarInformation());
        }
        return new Result(result);
    }

    public boolean doesAttemptEqualTo(int attempts) {
        return this.attempts == attempts;
    }
    public int generateRandomNumber() {
        return Randoms.pickNumberInRange(GameStatistic.MIN_RANDOM_NUMBER, GameStatistic.MAX_RANDOM_NUMBER);
    }
}
