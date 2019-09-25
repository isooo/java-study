package racingcar.domain;

import java.util.*;
import java.util.stream.*;

public class RacingWinner {
    public static List<String> get(final List<Result> resultList) {
        final Result result = resultList.get(resultList.size() - 1);
        return getWinnerNames(result.getCars());
    }

    private static List<String> getWinnerNames(final Cars cars) {
        final int highScore = getHighScore(cars);
        return cars.getCarList().stream()
                .filter(car -> car.getPosition() >= highScore)
                .map(car -> car.getName())
                .collect(Collectors.toList());
    }

    private static int getHighScore(final Cars cars) {
        int highScore = 0;
        for (Car car : cars.getCarList()) {
            if (car.getPosition() > highScore) {
                highScore = car.getPosition();
            }
        }
        return highScore;
    }
}
