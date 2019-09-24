package racingcar.domain;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

import static org.assertj.core.api.Assertions.*;

class CarTest {
    private Car car;

    @BeforeEach
    void init() {
        car = new Car(1, "isooo");
    }

    @DisplayName("자동차 이름으로 Car 생성 테스트")
    @ParameterizedTest
    @CsvSource({"10, isooo", "11, anony"})
    void createCarByName(final String id, final String name) {
        // given
        // when
        final Car createdCar = new Car(Integer.parseInt(id), name);

        // then
        assertThat(createdCar.getName())
                .isEqualTo(name);
    }

    @DisplayName("자동차 0회 move 테스트")
    @Test
    void zeroMove() {
        // given
        // when
        car.move(false);

        // then
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @DisplayName("자동차 1회 move 테스트")
    @Test
    void oneMove() {
        // given
        // when
        car.move(true);

        // then
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @DisplayName("자동차 5회 move 테스트")
    @Test
    void fiveMoves() {
        // given
        // when
        for (int i = 0; i < 5; i++) {
            car.move(true);
        }

        // then
        assertThat(car.getPosition()).isEqualTo(5);
    }
}