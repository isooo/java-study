package racingcar.domain;

import org.junit.jupiter.api.*;

import java.util.*;

import static org.assertj.core.api.Assertions.*;

class RacingGameTest {
    @DisplayName("5회의 race 후 List<RacingCars> 사이즈 테스트")
    @Test
    void raceTest() {
        // given
        final RacingCars racingCars = new RacingCars("a,b,c");
        final RacingGame racingGame = new RacingGame(5, new RandomMovingPolicy());

        // when
        final List<RacingCars> racingCarsByRound = racingGame.race(racingCars);

        // then
        assertThat(racingCarsByRound.size()).isEqualTo(5);
    }

    @DisplayName("3대의 RacingCar가 동일한 position일 때 우승자 테스트")
    @Test
    void name() {
        // given
        final RacingGame racingGame = new RacingGame(1, () -> true);

        // when
        final List<RacingCars> racingCarsByRound = racingGame.race(new RacingCars("a,b,c"));
        final RacingCars racingCars = racingCarsByRound.get(racingCarsByRound.size() - 1);
        final List<String> winners = racingCars.getWinners();

        // then
        assertThat(winners.toArray()).isEqualTo(new String[]{"a", "b", "c"});
    }
}