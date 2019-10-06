package racingcar.ui;

import racingcar.application.*;

public class RacingCarController {
    public static void run(final RacingCarService racingCarService) {
        final String carsNames = InputView.askNames();
        final int totalRound = InputView.askRound();
        racingCarService.race(carsNames, totalRound);
//        ResultView.view(racingResult);
    }
}
