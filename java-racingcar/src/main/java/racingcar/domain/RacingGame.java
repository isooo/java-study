package racingcar.domain;

import java.util.*;

public class RacingGame {
    private final RacingCars racingCars;
    private final int totalRound;

    RacingGame(final RacingCars racingCars, final int totalRound) {
        this.racingCars = racingCars;
        this.totalRound = totalRound;
    }

    public RacingGame(final String carsNames, final int totalRound) {
        this(new RacingCars(carsNames), totalRound);
    }

    public List<RacingCars> race(final MovingPolicy movingPolicy) {
        final List<RacingCars> racingCarsByRound = new ArrayList<>();
        RacingCars temp = racingCars;
        for (int i = 0; i < totalRound; i++) {
            temp = raceByRounds(temp, movingPolicy);
            racingCarsByRound.add(temp);
        }
        return racingCarsByRound;
    }

    private RacingCars raceByRounds(final RacingCars racingCars, final MovingPolicy movingPolicy) {
        return racingCars.move(movingPolicy);
    }
}
