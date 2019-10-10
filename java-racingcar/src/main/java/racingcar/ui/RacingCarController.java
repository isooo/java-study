package racingcar.ui;

import racingcar.application.*;
import racingcar.domain.*;

import java.util.*;

public class RacingCarController {
    public static void run(final RacingCarService racingCarService) {
        final String carsNames = InputView.askNames();
        final int totalRound = InputView.askRound();
        final List<RacingCars> racingCarsList = racingCarService.race(carsNames, totalRound);
        ResultView.view(racingCarsList);
    }
}
