package racingcar.application;

import racingcar.domain.*;

import java.util.*;

public class RacingCarService {
    public List<RacingCars> race(final String carsNames, final int totalRound) {
        final RacingCars racingCars = new RacingCars(carsNames);
        final RacingGame racingGame = new RacingGame(totalRound, new MovingPolicy(10, 4));
        return racingGame.race(racingCars);
    }
}
