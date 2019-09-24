package racingcar.domain;

import java.util.*;
import java.util.stream.*;

public class RacingGame {
    private static final int RANDOM_BOUND = 10;
    private static final int NUMBER_CONDITION_TO_MOVE = 4;

    private int totalTrack;

    public RacingGame(int totalTrack) {
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

    // 이 기능은 Cars에 위치하는게 더 낫지 않을까
    private void raceByTrack(final Cars cars) {
        cars.getCarList().stream()
                .forEach(car -> car.move(isMove()));
    }

    private boolean isMove() {
        return new Random().nextInt(RANDOM_BOUND) >= NUMBER_CONDITION_TO_MOVE;
    }
}