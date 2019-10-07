package racingcar.domain;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

import java.util.*;
import java.util.stream.*;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class RacingCarsTest {
    @DisplayName("자동차 이름 목록으로 RacingCars 생성 성공 테스트")
    @ParameterizedTest
    @CsvSource(value = {"isooo:1", "a,b,c,d,e:5"}, delimiter = ':')
    void createCarsByNames(final String names, final String expected) {
        // given
        // when
        final RacingCars racingCars = new RacingCars(names);

        // then
        assertThat(racingCars.getRacingCarList().size())
                .isEqualTo(Integer.parseInt(expected));
    }

    @DisplayName("3대의 RacingCar 중 1대만 움직임 테스트")
    @Test
    void moveTest() {
        // given
        final RacingCars racingCars = new RacingCars("a,b,c");
        final MovingPolicy movingPolicy = mock(MovingPolicy.class);
        when(movingPolicy.isPossible())
                .thenReturn(true)
                .thenReturn(false)
                .thenReturn(false);

        // when
        final RacingCars racingCarsAfterMove = racingCars.move(movingPolicy);
        final List<Integer> positionList = racingCarsAfterMove.getRacingCarList().stream()
                .map(racingCar -> racingCar.getPosition())
                .collect(Collectors.toList());

        // then
        assertThat(positionList.toArray()).isEqualTo(new int[]{1,0,0});
    }

    @DisplayName("3대의 RacingCar 중 2대만 움직임 후 우승자 테스트")
    @Test
    void winnerTest() {
        // given
        final RacingCars racingCars = new RacingCars("a,b,c");
        final MovingPolicy movingPolicy = mock(MovingPolicy.class);
        when(movingPolicy.isPossible())
                .thenReturn(false)
                .thenReturn(true)
                .thenReturn(true);

        // when
        final List<String> winners = racingCars.move(movingPolicy).getWinners();

        // then
        assertThat(winners.toArray()).isEqualTo(new String[]{"b", "c"});
    }
}