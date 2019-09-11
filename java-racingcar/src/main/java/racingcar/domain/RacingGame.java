package racingcar.domain;

import racingcar.ui.*;

public class RacingGame {
    private Cars cars;
    private int totalTrack;

    public RacingGame(final int numberOfCars, final int totalTrack) {
        this.cars = registerCars(numberOfCars);
        this.totalTrack = totalTrack;
    }

    public Cars getCars() {
        return cars;
    }

    private Cars registerCars(final int numberOfCars) {
        final Cars cars = new Cars();
        return cars.registerCars(numberOfCars);
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