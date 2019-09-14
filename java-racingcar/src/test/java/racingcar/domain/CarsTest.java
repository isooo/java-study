package racingcar.domain;

import org.junit.jupiter.api.*;

import java.util.*;
import java.util.stream.*;

import static org.assertj.core.api.Assertions.*;

class CarsTest {

    @Test
    void 자동차_1대_등록_테스트() {
        // given
        // when
        final Cars cars = new Cars(1);

        // then
        assertThat(cars.getCount())
                .isEqualTo(1);
    }

    @Test
    void 자동차_5대_등록_테스트() {
        // given
        // when
        final Cars cars = new Cars(5);
        final List<Long> idList = cars.getCarList()
                .stream()
                .map(car -> car.getId())
                .collect(Collectors.toList());

        // then
        assertThat(idList)
                .isEqualTo(Arrays.asList(1L, 2L, 3L, 4L, 5L));
    }

    @Test
    void 자동차_1대_1회_레이싱_테스트() {
        // given

        // when
        final Cars cars = new Cars(1);
        cars.race();

        // then
        assertThat(cars.getCarList().get(0).getPosition())
                .isLessThanOrEqualTo(1);
    }
}