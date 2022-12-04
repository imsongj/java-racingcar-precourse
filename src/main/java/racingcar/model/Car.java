package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void move() {

    }

    public int generateRandomNumber() {
        return Randoms.pickNumberInRange(CarStatistic.MIN_RANDOM_NUMBER, CarStatistic.MAX_RANDOM_NUMBER);
    }
}
