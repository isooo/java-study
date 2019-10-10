package racingcar.domain;

import org.junit.jupiter.api.*;

import java.util.*;

import static org.assertj.core.api.Assertions.*;

class RacingGameTest {
    @DisplayName("5회의 race 후 List<RacingCars> 사이즈 테스트")
    @Test
    void raceTest() {
        // given
        final RacingGame racingGame = new RacingGame("a,b,c", 5);

        // when
        final List<RacingCars> racingCarsByRound = racingGame.race(new RandomMovingPolicy());

        // then
        assertThat(racingCarsByRound.size()).isEqualTo(5);
    }

    @DisplayName("3대의 RacingCar가 동일한 position일 때 우승자 테스트")
    @Test
    void winnerTestWhenAllSamePosition() {
        // given
        final RacingGame racingGame = new RacingGame(
                new RacingCars(
                        Arrays.asList(
                                new RacingCar(1, "a"),
                                new RacingCar(2, "b"),
                                new RacingCar(3, "c")
                        )
                ),
                1
        );

        // when
        final List<RacingCars> racingCarsByRound = racingGame.race(() -> true);
        final RacingCars racingCars = racingCarsByRound.get(racingCarsByRound.size() - 1);
        final List<String> winners = racingCars.getWinners();

        // then
        assertThat(winners.toArray()).isEqualTo(new String[]{"a", "b", "c"});
    }

    @DisplayName("3대의 RacingCar의 position이 모두 0일 때 우승자 테스트")
    @Test
    void winnerTestWhenAllZeroPosition() {
        // given
        final RacingGame racingGame = new RacingGame(
                new RacingCars(
                        Arrays.asList(
                                new RacingCar(1, "a"),
                                new RacingCar(2, "b"),
                                new RacingCar(3, "c")
                        )
                ),
                1
        );

        // when
        final List<RacingCars> racingCarsByRound = racingGame.race(() -> false);
        final RacingCars racingCars = racingCarsByRound.get(racingCarsByRound.size() - 1);
        final List<String> winners = racingCars.getWinners();

        // then
        assertThat(winners.toArray()).isEqualTo(new String[]{"a", "b", "c"});
    }
}