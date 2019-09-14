package racingcar.domain;

import racingcar.ui.*;

public class RacingGame {
    private Cars cars;
    private int totalTrack;

    public RacingGame(final int numberOfCars, final int totalTrack) {
        this.cars = Cars.registerCars(numberOfCars);
        this.totalTrack = totalTrack;
    }

    public Cars getCars() {
        return cars;
    }

    public ResultView start() {
        final ResultView resultView = new ResultView();
        for (int i = 0; i < totalTrack; i++) {
            cars.race();
            resultView.record(cars);
        }
        return resultView;
    }
}