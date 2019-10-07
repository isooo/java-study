package racingcar.domain;

import org.junit.jupiter.api.*;

import java.util.stream.*;

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
        racingCar.move(true);

        // then
        assertThat(racingCar.getPosition()).isEqualTo(1);
    }

    @DisplayName("레이싱 카 1회 move 실패 시 position 테스트")
    @Test
    void racingCarMoveNone() {
        // given
        // when
        racingCar.move(false);

        // then
        assertThat(racingCar.getPosition()).isEqualTo(0);
    }

    @DisplayName("레이싱 카 5회 move 중 3회 성공 시 position 테스트")
    @Test
    void racingCarMoveThree() {
        // given
        // when
        IntStream.rangeClosed(1, 5)
                .forEach(i ->
                        {
                            if (i < 4) {
                                racingCar.move(true);
                            } else {
                                racingCar.move(false);
                            }
                        }
                );

        // then
        assertThat(racingCar.getPosition()).isEqualTo(3);
    }
}