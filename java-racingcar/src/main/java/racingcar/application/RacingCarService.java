package racingcar.application;

import racingcar.domain.*;

public class RacingCarService {
    private static final int RANDOM_BOUND = 10;
    private static final int NUMBER_CONDITION_TO_MOVE = 4;

    public RacingResult race(final String carsNames, final int totalTrack) {
        final Cars cars = new Cars(carsNames);
        final RacingGame racingGame = new RacingGame(totalTrack, new MovingPolicy(RANDOM_BOUND, NUMBER_CONDITION_TO_MOVE));
        return racingGame.race(cars);
    }
}
