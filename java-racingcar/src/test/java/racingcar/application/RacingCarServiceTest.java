package racingcar.application;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;
import racingcar.domain.*;

import java.util.*;

import static org.assertj.core.api.Assertions.*;

class RacingCarServiceTest {
    @DisplayName("RacingGame의 race가 정상 동작했을 때 결과 사이즈")
    @ParameterizedTest
    @CsvSource(value = {"a:1:1", "a:2:2", "a,b,c:5:5"}, delimiter = ':')
    void oneRacingCarTwoRounds(final String names, final String totalRound, final String expected) {
        // given
        final RacingCarService racingCarService = new RacingCarService();

        // when
        final RacingResult racingResult = racingCarService.race(names, Integer.parseInt(totalRound));

        // then
        assertThat(racingResult.getRacingCarsByRound().size()).isEqualTo(Integer.parseInt(expected));
    }
}
