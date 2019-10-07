package racingcar.domain;

import java.util.*;
import java.util.stream.*;

public class RacingGame {
    private final int totalRound;

    public RacingGame(final int totalRound) {
        this.totalRound = totalRound;
    }

    public List<RacingCars> race(final RacingCars racingCars) {
        return IntStream.rangeClosed(1, this.totalRound)
                .mapToObj(i -> raceByRounds(racingCars))
                .collect(Collectors.toList());
    }

    private RacingCars raceByRounds(final RacingCars racingCars) {
        return racingCars.move();
    }
}
