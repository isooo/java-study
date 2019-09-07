package racingcar.ui;

import racingcar.application.*;

public class RacingCarController {
    public static void run() {
        final String car = InputView.getCarCount();
        final String track = InputView.getTrackCount();
        RacingCarService service = new RacingCarService();
        final StringBuilder sb = service.play(car, track);
        ResultView.getView(sb);
    }
}
