package racingcar.domain;

import java.util.*;
import java.util.stream.*;

public class RacingGame {
    private static final int RANDOM_BOUND = 10;
    private static final int NUMBER_CONDITION_TO_MOVE = 4;

    private int totalTrack;

    public RacingGame(final int totalTrack) {
        this.totalTrack = totalTrack;
    }

    public List<Result> race(final Cars cars) {
        return IntStream.rangeClosed(1, totalTrack)
                .mapToObj(track -> race(track, cars))
                .collect(Collectors.toList());
    }

    private Result race(final int track, final Cars cars) {
        raceByTrack(cars);
        return new Result(track, cars);
    }

    // Cars에서 getCarList를 하는 동작이 빈번한 것 같은데 이 부분을 어떻게 보완할 수 있을 까
    private void raceByTrack(final Cars cars) {
        cars.getCarList().stream()
                .forEach(car -> car.move(isMove()));
    }

    private boolean isMove() {
        return new Random().nextInt(RANDOM_BOUND) >= NUMBER_CONDITION_TO_MOVE;
    }
}