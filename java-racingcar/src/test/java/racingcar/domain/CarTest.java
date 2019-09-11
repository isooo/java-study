package racingcar.domain;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.*;

class CarTest {

    @Test
    void 자동차_생성시_Id_부여_테스트() {
        // given
        // when
        final Car car = new Car();

        // then
        assertThat(car.getId()).isEqualTo(1);
    }

    @Test
    void 자동차_move_테스트_1회() {
        // given
        final Car car = new Car();

        // when
        car.move();

        // then
        assertThat(car.getPosition()).isIn(0, 1);
    }

    @Test
    void 자동차_move_테스트_5회() {
        // given
        final Car car = new Car();

        // when
        for (int i = 0; i < 5; i++) {
            car.move();
        }

        // then
        assertThat(car.getPosition()).isLessThanOrEqualTo(5);
    }
}