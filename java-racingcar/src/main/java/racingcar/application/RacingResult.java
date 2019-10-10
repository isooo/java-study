package racingcar.application;

import racingcar.domain.*;

import java.util.*;

public class RacingResult {
    private final List<RacingCars> racingCarsByRound;
    private final List<String> winners;

    RacingResult(final List<RacingCars> racingCarsByRound, final List<String> winners) {
        this.racingCarsByRound = new ArrayList<>(racingCarsByRound);
        this.winners = new ArrayList<>(winners);
    }

    public List<RacingCars> getRacingCarsByRound() {
        return new ArrayList<>(racingCarsByRound);
    }

    public List<String> getWinners() {
        return new ArrayList<>(winners);
    }
}
