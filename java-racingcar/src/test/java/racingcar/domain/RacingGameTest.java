package racingcar.domain;

import org.junit.jupiter.api.*;
import racingcar.application.*;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

class RacingGameTest {
    private MovingPolicy movingPolicy;

    @BeforeEach
    void init() {
        this.movingPolicy = mock(MovingPolicy.class);
    }

    @DisplayName("자동차 1대 1회 레이싱 시, 1회 움직임 테스트")
    @Test
    void oneCarRacedOnce() {
        // given
        final RacingGame racingGame = new RacingGame(1, movingPolicy);
        final Cars cars = new Cars("a");

        // when
        when(movingPolicy.isPossible()).thenReturn(true);
        racingGame.race(cars);

        // then
        assertThat(cars.getCarList().get(0).getPosition())
                .isEqualTo(1);
    }

    @DisplayName("자동차 5대 3회 레이싱 시, 5대 모두 3회 움직임 테스트")
    @Test
    void fiveCarsRacedThreeTimes() {
        // given
        final RacingGame racingGame = new RacingGame(3, movingPolicy);
        final Cars cars = new Cars("a,b,c,d,e");

        // when
        when(movingPolicy.isPossible()).thenReturn(true);
        racingGame.race(cars);
        final boolean result = cars.getCarList().stream()
                .map(car -> car.getPosition())
                .allMatch(p -> p == 3);

        // then
        assertThat(result).isTrue();
    }

    @DisplayName("자동차 3대 모두 2회씩 움직인 후 우승자 이름 테스트")
    @Test
    void threeCarsRacedTwoTimesAndReturnWinner() {
        // given
        final RacingGame racingGame = new RacingGame(2, movingPolicy);
        final Cars cars = new Cars("a,b,c");

        // when
        when(movingPolicy.isPossible()).thenReturn(true);
        final RacingResult raceResult = racingGame.race(cars);

        // then
        assertThat(raceResult.getRacingWinner().getWinnerNames().size()).isEqualTo(3);
    }
}
