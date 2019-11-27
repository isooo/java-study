package racingcar.application;

import org.junit.jupiter.api.*;
import racingcar.domain.*;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarServiceTest {
    @DisplayName("race 후 RacingCars 사이즈 테스트")
    @Test
    void racingCarsListSize() {
        // given
        final RacingCarService racingCarService = new RacingCarService();

        // when
        final RacingResult racingResult = racingCarService.race(names, Integer.parseInt(totalRound));

        // then
        assertThat(racingResult.getRacingCarsByRound().size()).isEqualTo(Integer.parseInt(expected));
    }
}
