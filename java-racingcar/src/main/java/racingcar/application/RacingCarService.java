package racingcar.application;

import racingcar.domain.*;
import racingcar.infra.*;

import java.util.*;

public class RacingCarService {
    public List<RacingCars> race(final String carsNames, final int totalRound) {
        final RacingCars racingCars = new RacingCars(carsNames);
        final RacingGame racingGame = new RacingGame(totalRound, new MovingPolicyMoreThanFour());
        return racingGame.race(racingCars);
    }
}
