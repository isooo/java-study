package racingcar.domain;

import org.junit.jupiter.api.*;

import java.util.*;

import static org.assertj.core.api.Assertions.*;

class RacingGameTest {
    @DisplayName("5회의 race 후 List<RacingCars> 사이즈 테스트")
    @Test
    void raceTest() {
        // given
        final RacingCars racingCars = new RacingCars("a, b, c");
        final RacingGame racingGame = new RacingGame(5);

        // when
        final List<RacingCars> racingCarsList = racingGame.race(racingCars);

        // then
        assertThat(racingCarsList.size()).isEqualTo(5);
    }
}