package racingcar.domain;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.*;

class RacingGameTest {

    @Test
    void 자동차_등록_테스트() {
        // given
        final RacingGame racingGame = new RacingGame(3);

        // when
        final Cars cars = racingGame.registerCars(5);

        // then
        assertThat(cars.getCarList().size())
                .isEqualTo(5);
    }

    @Test
    void 자동차_1대_1회_경주_테스트() {
        // given
        final RacingGame racingGame = new RacingGame(1);
        final Cars cars = racingGame.registerCars(1);

        // when
        racingGame.race(cars);

        // then
        assertThat(cars.getCarList().get(0).getPosition())
                .isLessThanOrEqualTo(1);
    }

    @Test
    void 자동차_5대_3회_경주_테스트() {
        // given
        final RacingGame racingGame = new RacingGame(3);
        final Cars cars = racingGame.registerCars(5);

        // when
        racingGame.race(cars);
        final boolean result = cars.getCarList().stream()
                .map(car -> car.getPosition())
                .allMatch(p -> p <= 3);

        // then
        assertThat(result).isTrue();
    }
}
