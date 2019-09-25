package racingcar.domain;

import org.junit.jupiter.api.*;

import java.util.*;
import java.util.stream.*;

import static org.assertj.core.api.Assertions.*;

class RacingWinnerTest {

    @DisplayName("우승자 1명")
    @Test
    void oneWinner() {
        // given
        final Car a = new Car(1, "a");
        final Car b = new Car(2, "b");

        a.move(false);
        b.move(true);

        final List<Result> resultList = new ArrayList<>();
        resultList.add(
                new Result(1, new Cars(Arrays.asList(a, b)))
        );

        // when
        final List<String> names = RacingWinner.get(resultList);

        // then
        assertThat(names.get(0)).isEqualTo("b");
    }

    @DisplayName("우승자 3명")
    @Test
    void threeWinners() {
        // given
        final List<Car> cars = IntStream.rangeClosed(1, 5)
                .mapToObj(i -> new Car(i, "test" + i))
                .collect(Collectors.toList());
        cars.stream()
                .filter(car -> car.getId() < 4)
                .forEach(car -> car.move(true));

        final List<Result> resultList = new ArrayList<>();
        resultList.add(
                new Result(1, new Cars(cars))
        );

        // when
        final List<String> names = RacingWinner.get(resultList);

        // then
        assertThat(names).isEqualTo(Arrays.asList("test1", "test2", "test3"));
    }
}