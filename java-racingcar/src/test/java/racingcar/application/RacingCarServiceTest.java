package racingcar.application;

import org.junit.jupiter.api.*;
import racingcar.domain.*;

import java.util.*;

import static org.assertj.core.api.Assertions.*;

class RacingCarServiceTest {
    @DisplayName("racingCar가 3대, 5회 라운드일 때 결과값")
    @Test
    void threeRacingCarFiveRounds() {
        // given
        final RacingCarService racingCarService = new RacingCarService();

        // when
        final List<RacingCars> racingCarsByRound = racingCarService.race("a,b,c", 5);

        // then
        assertThat(racingCarsByRound.size()).isEqualTo(5);
    }
}