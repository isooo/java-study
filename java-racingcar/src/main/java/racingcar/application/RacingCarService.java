package racingcar.application;

import racingcar.domain.*;
import racingcar.utils.*;

import java.util.*;

public class RacingCarService {
    public List<Result> race(final String carsNames, final int totalTrack) {
        final Cars cars = new Cars(carsNames);
        final RacingGame racingGame = new RacingGame(totalTrack);
        return racingGame.race(cars);
    }
}
