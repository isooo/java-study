package racingcar.domain;

import org.junit.jupiter.api.*;

import java.util.*;
import java.util.stream.*;

import static org.assertj.core.api.Assertions.*;

class CarsTest {

    @Test
    void 자동차_1대_등록_테스트() {
        // given
        final Cars cars = new Cars();

        // when
        final Cars registeredCars = cars.registerCars(1);

        // then
        assertThat(registeredCars.getCount())
                .isEqualTo(1);
    }

    @Test
    void 자동차_5대_등록_테스트() {
        // given
        final Cars cars = new Cars();

        // when
        final Cars registeredCars = cars.registerCars(5);
        final List<Long> idList = registeredCars.getCarList()
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
        final Cars cars = new Cars();

        // when
        final Cars registeredCars = cars.registerCars(1);
        registeredCars.race();

        // then
        assertThat(registeredCars.getCarList().get(0).getPosition())
                .isLessThanOrEqualTo(1);
    }
}