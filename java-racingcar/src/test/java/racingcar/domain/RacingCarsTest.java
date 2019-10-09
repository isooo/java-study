package racingcar.domain;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

import java.util.*;
import java.util.stream.*;

import static org.assertj.core.api.Assertions.*;

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

    @DisplayName("3대의 RacingCar 전부 움직였을 때 position 테스트")
    @Test
    void moveTest() {
        // given
        final RacingCars racingCars = new RacingCars("a,b,c");

        // when
        final RacingCars racingCarsAfterMove = racingCars.move(() -> true);
        final List<Integer> positionList = racingCarsAfterMove.getRacingCarList().stream()
                .map(racingCar -> racingCar.getPosition())
                .collect(Collectors.toList());

        // then
        final boolean result = positionList.stream()
                .allMatch(position -> position == 1);
        assertThat(result).isEqualTo(true);
    }

    @DisplayName("3대의 RacingCar 모두 움직이지 않았을 때 우승자 테스트")
    @Test
    void winnerTest() {
        // given
        final RacingCars racingCars = new RacingCars("a,b,c");

        // when
        final List<String> winners = racingCars.move(() -> false).getWinners();

        // then
        assertThat(winners.toArray()).isEqualTo(new String[]{"a", "b", "c"});
    }

    @DisplayName("우승자 위치 출력 테스트")
    @Test
    void winnerPosition() {
        // given
        RacingCars racingCars = new RacingCars("a,b");

        // when
        IntStream.rangeClosed(1, 4)
                .forEach(i -> racingCars.move(() -> true));

        // then
        assertThat(racingCars.getMaxPosition()).isEqualTo(4);
    }
}