package racingcar.domain;

public class RacingCar {
    private final int id;
    private final String name;
    private int position;

    RacingCar(final int id, final String name) {
        this.id = id;
        this.name = name;
        this.position = 0;
    }
}
