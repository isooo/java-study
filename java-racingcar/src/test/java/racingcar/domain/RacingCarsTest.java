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

    @DisplayName("3대의 RacingCar 전부 1회 움직였을 때 position 테스트")
    @Test
    void allMoveTest() {
        // given
        final RacingCars racingCars = new RacingCars(new ArrayList<>(
                Arrays.asList(
                        new RacingCar(1, "a"),
                        new RacingCar(2, "b"),
                        new RacingCar(3, "c")
                )
        ));

        // when
        final RacingCars racingCarsAfterMove = racingCars.move(() -> true);
        final List<Integer> positions = racingCarsAfterMove.getRacingCarList().stream()
                .map(racingCar -> racingCar.getPosition())
                .collect(Collectors.toList());

        // then
        final boolean result = positions.stream()
                .allMatch(position -> position == 1);
        assertThat(result).isEqualTo(true);
    }

    @DisplayName("가장 큰 포지션이 3일 때 max position 구하기")
    @Test
    void getMaxPositionTest() {
        // given
        final RacingCars racingCars = new RacingCars(new ArrayList<>(
                Arrays.asList(
                        new RacingCar(1, "a", 3),
                        new RacingCar(2, "b", 3),
                        new RacingCar(3, "c", 2)
                )
        ));

        // when
        final int maxPosition = racingCars.getMaxPosition();

        // then
        assertThat(maxPosition).isEqualTo(3);
    }

    @DisplayName("3대의 RacingCar 모두 움직이지 않았을 때 우승자 테스트")
    @Test
    void winnerTestWhenAllRacingCarsSamePosition() {
        // given
        final RacingCars racingCars = new RacingCars("a,b,c");

        // when
        final List<String> winners = racingCars.move(() -> false).getWinners();

        // then
        assertThat(winners.toArray()).isEqualTo(new String[]{"a", "b", "c"});
    }

    @DisplayName("3대의 RacingCar 중 2대만 움직였을 때 우승자 테스트")
    @Test
    void winnerPositionTest() {
        // given
        final RacingCars racingCars = new RacingCars(new ArrayList<>(
                Arrays.asList(
                        new RacingCar(1, "a", 3),
                        new RacingCar(2, "b", 3),
                        new RacingCar(3, "c", 1)
                )
        ));

        // when
        final List<String> winners = racingCars.getWinners();

        // then
        assertThat(winners.toArray()).isEqualTo(new String[]{"a", "b"});
    }
}