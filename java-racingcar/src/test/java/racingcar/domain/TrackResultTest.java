package racingcar.domain;

import org.junit.jupiter.api.*;

import java.util.*;
import java.util.stream.*;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

class TrackResultTest {

    @DisplayName("동일한 position일 때, 우승자 이름 테스트")
    @Test
    void jointWinnerNameTest() {
        // given
        final Cars cars = mock(Cars.class);
        final TrackResult trackResult = new TrackResult(1, cars);

        // when
        when(cars.getCarList())
                .thenReturn(
                        Arrays.asList(
                                new Car(1, "a"),
                                new Car(2, "b"),
                                new Car(3, "c")
                        )
                );
        final List<String> winnerNames = trackResult.getWinnerNames();

        // then
        assertThat(winnerNames).isEqualTo(Arrays.asList("a", "b", "c"));
    }

    @DisplayName("우승자 3명 테스트")
    @Test
    void threeWinners() {
        // given
        final Cars cars = new Cars("a,b,c,d,e");
        IntStream.rangeClosed(1, 3)
                .mapToObj(i -> cars.getCarList().get(i))
                .forEach(car -> car.move(true));

        final TrackResult trackResult = new TrackResult(2, cars);

        // when
        final List<String> winnerNames = trackResult.getWinnerNames();

        // then
        assertThat(winnerNames).isEqualTo(Arrays.asList("b", "c", "d"));
    }
}