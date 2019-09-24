package racingcar.domain;

public class Result {
    private final int track;
    private final Cars cars;

    public Result(final int track, final Cars cars) {
        this.track = track;
        this.cars = cars.copy();
    }

    public int getTrack() {
        return track;
    }

    public Cars getCars() {
        return cars;
    }
}
