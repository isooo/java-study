package racingcar.domain;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.*;

class RacingGameTest {

    @Test
    void 자동차_등록_테스트() {
        // given
        final RacingGame racingGame = new RacingGame(3, 5);

        // when
        final Cars cars = racingGame.getCars();

        // then
        assertThat(cars.getCount())
                .isEqualTo(3);
    }

    @Test
    void 자동차_경주_테스트() {
        // given
        final RacingGame racingGame = new RacingGame(3, 5);

        // when
        racingGame.start();
        final boolean result = racingGame.getCars().getCarList().stream()
                .map(car -> car.getPosition())
                .allMatch(p -> p <= 5);

        // then
        assertThat(result).isTrue();
    }
}