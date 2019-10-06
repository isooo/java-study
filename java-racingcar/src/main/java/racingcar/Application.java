package racingcar;

import racingcar.ui.*;
import racingcar.application.*;

public class Application {
    public static void main(String[] args) {
        RacingCarController.run(new RacingCarService());
    }
}
