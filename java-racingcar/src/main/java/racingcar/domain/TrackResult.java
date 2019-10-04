package racingcar.domain;

import java.util.*;
import java.util.stream.*;

public class TrackResult {
    private final int track;
    private final Cars cars;

    public TrackResult(final int track, final Cars cars) {
        this.track = track;
        this.cars = cars;
    }

    public int getTrack() {
        return track;
    }

    public Cars getCars() {
        return cars;
    }

    public List<String> getWinnerNames() {
        final int highScore = getHighScore();
        return cars.getCarList().stream()
                .filter(car -> car.getPosition() >= highScore)
                .map(car -> car.getName())
                .collect(Collectors.toList());
    }

    private int getHighScore() {
        int highScore = 0;
        for (Car car : cars.getCarList()) {
            if (car.getPosition() > highScore) {
                highScore = car.getPosition();
            }
        }
        return highScore;
    }
}
