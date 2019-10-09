package racingcar.domain;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.*;

class RacingCarTest {
    private RacingCar racingCar;

    @BeforeEach
    void init() {
        this.racingCar = new RacingCar(1, "isooo");
    }

    @DisplayName("레이싱 카 생성 테스트")
    @Test
    void createRacingCar() {
        // given
        // when
        // then
        assertThat(racingCar.getName()).isEqualTo("isooo");
        assertThat(racingCar.getPosition()).isEqualTo(0);
    }

    @DisplayName("레이싱 카 1회 move 성공 시 position 테스트")
    @Test
    void racingCarMoveOnce() {
        // given
        // when
        final RacingCar racingCarAfterMove = this.racingCar.move(true);

        // then
        assertThat(racingCarAfterMove.getPosition()).isEqualTo(1);
    }

    @DisplayName("레이싱 카 1회 move 실패 시 position 테스트")
    @Test
    void racingCarMoveNone() {
        // given
        // when
        final RacingCar racingCarAfterMove = racingCar.move(false);

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