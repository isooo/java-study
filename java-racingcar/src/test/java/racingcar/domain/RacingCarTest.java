package racingcar.domain;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.*;

class RacingCarTest {
    @DisplayName("레이싱 카 생성 테스트")
    @Test
    void createRacingCar() {
        // given
        // when
        final RacingCar racingCar = new RacingCar(1, "test");

        // then
        assertThat(racingCar.getName()).isEqualTo("test");
        assertThat(racingCar.getPosition()).isEqualTo(0);
    }

    @DisplayName("레이싱 카 1회 move 성공 시 position 테스트")
    @Test
    void racingCarMoveOnce() {
        // given
        final RacingCar racingCar = new RacingCar(1, "test");

        // when
        final RacingCar racingCarAfterMove = racingCar.move(() -> true);

        // then
        assertThat(racingCarAfterMove.getPosition()).isEqualTo(1);
    }

    @DisplayName("레이싱 카 1회 move 실패 시 position 테스트")
    @Test
    void racingCarMoveNone() {
        // given
        final RacingCar racingCar = new RacingCar(1, "test");

        // when
        final RacingCar racingCarAfterMove = racingCar.move(() -> false);

        // then
        assertThat(racingCarAfterMove.getPosition()).isEqualTo(0);
    }

    @DisplayName("레이싱 카 move 3회 성공 시 position 테스트")
    @Test
    void racingCarMoveThree() {
        // given
        // when
        final RacingCar racingCarAfterMove = new RacingCar(2, "test2", 3);

        // then
        assertThat(racingCarAfterMove.getPosition()).isEqualTo(3);
    }
}