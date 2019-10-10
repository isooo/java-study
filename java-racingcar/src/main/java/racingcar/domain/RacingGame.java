package racingcar.domain;

import java.util.*;

public class RacingGame {
    private final int totalRound;

    public RacingGame(final int totalRound) {
        this.totalRound = totalRound;
    }

    public List<RacingCars> race(final RacingCars racingCars) {
        final List<RacingCars> racingCarsByRound = new ArrayList<>();
        RacingCars temp = racingCars;
        for (int i = 0; i < totalRound; i++) {
            temp = raceByRounds(temp);
            racingCarsByRound.add(temp);
        }
        return racingCarsByRound;
    }

    private RacingCars raceByRounds(final RacingCars racingCars) {
        return racingCars.move();
    }
}
