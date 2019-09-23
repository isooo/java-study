package racingcar.ui;

import racingcar.application.*;
import racingcar.domain.*;

import java.util.*;

public class RacingCarController {
    public static void run() {
        final String car = InputView.getCarCount();
        final String track = InputView.getTrackCount();
        final RacingCarService service = new RacingCarService();
        final List<Result> resultList = service.race(car, track);
        ResultView.view(resultList);
    }
}
