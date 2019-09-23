package racingcar.domain;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.*;

class CarTest {

    @Test
    void 자동차_생성시_Id_부여_테스트() {
        // given
        // when
        final Car car = new Car(1L);

        // then
        assertThat(car.getId()).isEqualTo(1);
    }

    @Test
    void 자동차_0회_move_테스트() {
        // given
        final Car car = new Car(1L);

        // when
        car.move(false);

        // then
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    void 자동차_1회_move_테스트() {
        // given
        final Car car = new Car(1L);

        // when
        car.move(true);

        // then
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void 자동차_5회_move_테스트() {
        // given
        final Car car = new Car(1L);

        // when
        for (int i = 0; i < 5; i++) {
            car.move(true);
        }

        // then
        assertThat(car.getPosition()).isEqualTo(5);
    }
}