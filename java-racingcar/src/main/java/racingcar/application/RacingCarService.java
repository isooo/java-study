package racingcar.application;

import racingcar.domain.*;

import java.util.*;

public class RacingCarService {
    public List<Result> race(final String car, final String count) {
        final int numberOfCars = Integer.parseInt(car);
        final int totalTrack = Integer.parseInt(count);
        final RacingGame racingGame = new RacingGame(totalTrack);
        final Cars cars = racingGame.registerCars(numberOfCars);
        return racingGame.race(cars);
    }
}
