package racingcar.ui;

import racingcar.application.*;
import racingcar.domain.*;

import java.util.*;

public class RacingCarController {
    public static void run() {
        final String carsNames = InputView.askNamesOfCars();
        final int totalTrack = InputView.askTrackCount();
        final RacingCarService service = new RacingCarService();
        final List<Result> resultList = service.race(carsNames, totalTrack);
        ResultView.view(resultList);
    }
}
