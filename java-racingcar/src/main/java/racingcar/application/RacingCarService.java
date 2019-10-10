package racingcar.application;

import racingcar.domain.*;

import java.util.*;

public class RacingCarService {
    public RacingResult race(final String carsNames, final int totalRound) {
        final RacingGame racingGame = new RacingGame(carsNames, totalRound);
        final List<RacingCars> racingCarsByRound = racingGame.race(new RandomMovingPolicy());
        final List<String> winners = racingCarsByRound.get(racingCarsByRound.size() - 1).getWinners();
        return new RacingResult(racingCarsByRound, winners);
    }
}
