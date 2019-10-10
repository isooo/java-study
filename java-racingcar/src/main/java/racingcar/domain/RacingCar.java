package racingcar.domain;

public class RacingCar {
    private final int id;
    private final String name;
    private final int position;

    RacingCar(final int id, final String name, final int position) {
        this.id = id;
        this.name = name;
        this.position = position;
    }

    RacingCar(final int id, final String name) {
        this(id, name, 0);
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public RacingCar move(final boolean isPossible) {
        if (isPossible) {
            return new RacingCar(id, name, position + 1);
        }
        return new RacingCar(id, name, position);
    }

    boolean isWinnerPosition(final int winnerPosition) {
        return position == winnerPosition;
    }
}
