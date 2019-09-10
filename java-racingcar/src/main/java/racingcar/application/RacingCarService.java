package racingcar.application;

import racingcar.domain.*;
import racingcar.ui.*;

public class RacingCarService {
    public ResultView start(final String car, final String count) {
        final int numberOfCars = Integer.parseInt(car);
        final int totalTrack = Integer.parseInt(count);
        final Cars cars = new Cars();
        cars.createCars(numberOfCars);
        return race(cars, totalTrack);
    }

    private ResultView race(final Cars cars, final int totalTrack) {
        final ResultView resultView = new ResultView();
        for (int i = 0; i < totalTrack; i++) {
            cars.race();
            resultView.record(cars);
        }
        return resultView;
    }
}
