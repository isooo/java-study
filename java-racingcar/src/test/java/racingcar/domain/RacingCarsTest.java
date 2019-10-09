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
        final RacingCars racingCars = new RacingCars(Arrays.asList(
                new RacingCar(1, "a", () -> true),
                new RacingCar(2, "b", () -> true),
                new RacingCar(3, "c", () -> true)
        ));

        // when
        final RacingCars racingCarsAfterMove = racingCars.move();
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
    void winnerTest1() {
        // given
        final RacingCars racingCars = new RacingCars(Arrays.asList(
                new RacingCar(1, "a", () -> false),
                new RacingCar(2, "b", () -> false),
                new RacingCar(3, "c", () -> false)
        ));

        // when
        final List<String> winners = racingCars.move().getWinners();

        // then
        assertThat(winners.toArray()).isEqualTo(new String[]{"a", "b", "c"});
    }

    @DisplayName("3대의 RacingCar 중 2대만 움직였을 때 우승자 테스트")
    @Test
    void winnerPositionTest() {
        // given
        final RacingCars racingCars = new RacingCars(Arrays.asList(
                new RacingCar(1, "a", () -> true),
                new RacingCar(2, "b", () -> true),
                new RacingCar(3, "c", () -> false)
        ));

        // when
        final List<String> winners = racingCars.move().getWinners();

        // then
        assertThat(winners.toArray()).isEqualTo(new String[]{"a", "b"});
    }
}