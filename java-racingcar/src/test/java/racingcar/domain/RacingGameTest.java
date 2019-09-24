package racingcar.domain;

import com.sun.tools.javac.util.*;
import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.*;

class RacingGameTest {
    @DisplayName("자동차 1대 1회 레이싱 테스트")
    @Test
    void oneCarRacedOnce() {
        // given
        final RacingGame racingGame = new RacingGame(1);
        final Cars cars = new Cars(List.of(new Car(1, "isooo")));

        // when
        racingGame.race(cars);

        // then
        assertThat(cars.getCarList().get(0).getPosition())
                .isLessThanOrEqualTo(1);
    }

    @DisplayName("자동차 5대 3회 레이싱 테스트")
    @Test
    void fiveCarsRacedThreeTimes() {
        // given
        final RacingGame racingGame = new RacingGame(3);
        final Cars cars = new Cars(
                List.of(
                        new Car(1, "a"),
                        new Car(2, "b"),
                        new Car(3, "c"),
                        new Car(4, "d"),
                        new Car(5, "e")));

        // when
        racingGame.race(cars);
        final boolean result = cars.getCarList().stream()
                .map(car -> car.getPosition())
                .allMatch(p -> p <= 3);

        // then
        assertThat(result).isTrue();
    }
}
