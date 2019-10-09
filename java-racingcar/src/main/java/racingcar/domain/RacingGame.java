package racingcar.domain;

import java.util.*;

public class RacingGame {
    private final int totalRound;
    private final MovingPolicy movingPolicy;

    public RacingGame(final int totalRound, final MovingPolicy movingPolicy) {
        this.totalRound = totalRound;
        this.movingPolicy = movingPolicy;
    }

    public List<RacingCars> race(final RacingCars racingCars) {
        final List<RacingCars> racingCarsList = new ArrayList<>();
        RacingCars temp = racingCars;
        for (int i = 0; i < totalRound; i++) {
            temp = raceByRounds(temp);
            racingCarsList.add(temp);
        }
        return racingCarsList;
    }

    private RacingCars raceByRounds(final RacingCars racingCars) {
        return racingCars.move(movingPolicy);
    }
}
