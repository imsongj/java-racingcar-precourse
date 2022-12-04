package racingcar.model;

public enum CarStatistic {
    MIN_NAME_LENGTH(1),
    MAX_NAME_LENGTH(5),
    MOVE_BASE(4);

    private final int value;

    private CarStatistic(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
