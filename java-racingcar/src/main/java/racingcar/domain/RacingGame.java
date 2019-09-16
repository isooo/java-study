package racingcar.domain;

public class RacingGame {
    private Cars cars;
    private int totalTrack;

    public RacingGame(final int numberOfCars, final int totalTrack) {
        this.cars = new Cars(numberOfCars);
        this.totalTrack = totalTrack;
    }

    public Cars getCars() {
        return cars;
    }

    public Cars start() {
        for (int i = 0; i < totalTrack; i++) {
            cars.race();
        }
        return cars;
    }
}