package racingcar.domain;

import org.junit.jupiter.api.*;

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