package racingcar.domain;

import org.junit.jupiter.api.*;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class RacingGameTest {

    @DisplayName("5회의 race 테스트")
    @Test
    void raceTest() {
        // given
        final MovingPolicy movingPolicy = mock(MovingPolicy.class);
        final RacingCars racingCars = mock(RacingCars.class);
        final RacingGame racingGame = new RacingGame(5, movingPolicy);

        // when
        final List<RacingCars> racingCarsList = racingGame.race(racingCars);

        // then
        assertThat(racingCarsList.size()).isEqualTo(5);
    }
}