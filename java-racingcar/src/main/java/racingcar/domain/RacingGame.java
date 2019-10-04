package racingcar.domain;

import racingcar.application.*;

import java.util.*;
import java.util.stream.*;

public class RacingGame {
    private MovingPolicy movingPolicy;
    private int totalTrack;

    public RacingGame(final int totalTrack, final MovingPolicy movingPolicy) {
        this.totalTrack = totalTrack;
        this.movingPolicy = movingPolicy;
    }

    public RacingResult race(final Cars cars) {
        final List<TrackResult> trackResultList = IntStream.rangeClosed(1, totalTrack)
                .mapToObj(track -> race(track, cars))
                .collect(Collectors.toList());
        final TrackResults trackResults = new TrackResults(trackResultList);
        final RacingWinner racingWinner = getWinner(trackResults);
        return new RacingResult(trackResults, racingWinner);
    }

    private TrackResult race(final int track, final Cars cars) {
        raceByTrack(cars);
        return new TrackResult(track, cars.copy());
    }

    private void raceByTrack(final Cars cars) {
        cars.getCarList().stream()
                .forEach(car -> car.move(movingPolicy.isPossible()));
    }

    private RacingWinner getWinner(final TrackResults trackResults) {
        return trackResults.getWinnerNames();
    }
}