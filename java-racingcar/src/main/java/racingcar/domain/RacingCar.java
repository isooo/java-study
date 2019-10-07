package racingcar.domain;

public class RacingCar {
    private final int id;
    private final String name;
    private int position;

    private RacingCar(final int id, final String name, final int position) {
        this.id = id;
        this.name = name;
        this.position = position;
    }

    RacingCar(final int id, final String name) {
        this(id, name, 0);
    }

    String getName() {
        return name;
    }

    int getPosition() {
        return position;
    }

    public RacingCar move(final boolean move) {
        if (move) {
            this.position++;
        }
        return new RacingCar(id, name, position);
    }
}
