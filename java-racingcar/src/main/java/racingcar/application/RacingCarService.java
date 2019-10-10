package racingcar.application;

import racingcar.domain.*;

import java.util.*;

public class RacingCarService {
    public List<RacingCars> race(final String carsNames, final int totalRound) {
        final RacingGame racingGame = new RacingGame(carsNames, totalRound);
        return racingGame.race(new RandomMovingPolicy());
    }
}
