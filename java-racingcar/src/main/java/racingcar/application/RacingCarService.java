package racingcar.application;

import racingcar.domain.RacingCars;
import racingcar.domain.*;

public class RacingCarService {
    public RacingResult race(final String carsNames, final int totalRound) {
        final RacingCars racingCars = new RacingCars(carsNames);
        final RacingGame racingGame = new RacingGame(totalRound);
        racingGame.race(racingCars);
//        final RacingCars racingCarsAfterRacing =
//        return new RacingResult(racingCarsAfterRacing);
    }
}
