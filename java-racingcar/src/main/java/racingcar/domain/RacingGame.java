package racingcar.domain;

import java.util.*;

public class RacingGame {
    private final int totalRound;

    public RacingGame(final int totalRound) {
        this.totalRound = totalRound;
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
        return racingCars.move();
    }
}
