package racingcar.ui;

import racingcar.application.*;

public class RacingCarController {
    public static void run() {
        final String carsNames = InputView.askNamesOfCars();
        final int totalTrack = InputView.askTrackCount();
        final RacingCarService service = new RacingCarService();
        final RacingResult racingResult = service.race(carsNames, totalTrack);
        ResultView.view(racingResult);
    }
}
