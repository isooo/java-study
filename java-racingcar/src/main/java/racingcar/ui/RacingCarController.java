package racingcar.ui;

import racingcar.application.*;
import racingcar.domain.*;

public class RacingCarController {
    public static void run() {
        final String car = InputView.getCarCount();
        final String track = InputView.getTrackCount();
        RacingCarService service = new RacingCarService();
        final Cars cars = service.start(car, track);
        ResultView.view(cars);
    }
}
