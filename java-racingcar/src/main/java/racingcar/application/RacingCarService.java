package racingcar.application;

import racingcar.domain.*;
import racingcar.ui.*;

public class RacingCarService {
    public Cars start(final String car, final String count) {
        final int numberOfCars = Integer.parseInt(car);
        final int totalTrack = Integer.parseInt(count);
        final RacingGame racingGame = new RacingGame(numberOfCars, totalTrack);
        return racingGame.start();
    }
}
