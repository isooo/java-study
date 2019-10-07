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
        final List<RacingCars> racingCarsList = racingCarService.race("a,b,c", 5);

        // then
        assertThat(racingCarsList.size()).isEqualTo(5);
    }
}