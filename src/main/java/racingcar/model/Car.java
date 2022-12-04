package racingcar.model;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void move(int number) {
        if (number >= GameStatistic.MOVE_BASE) {
            position++;
        }
    }

    public CarInformation getCarInformation() {
        return new CarInformation(name, position);
    }
}
