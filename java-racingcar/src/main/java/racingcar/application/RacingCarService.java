package racingcar.application;

import racingcar.domain.*;

import java.util.*;

public class RacingCarService {
    public List<Result> race(final String carsNames, final String count) {
        final Cars cars = new Cars(carsNames);
        final int totalTrack = Integer.parseInt(count);
        final RacingGame racingGame = new RacingGame(totalTrack);
        return racingGame.race(cars);
    }
}
