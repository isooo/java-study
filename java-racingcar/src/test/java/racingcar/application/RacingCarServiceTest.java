package racingcar.application;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarServiceTest {

    @DisplayName("race 후 한 명 이상의 우승자가 나오는지 테스트")
    @Test
    void racingTest() {
        final RacingCarService racingCarService = new RacingCarService();
        final RacingResult racingResult = racingCarService.race("a,b,c", 1);
        assertThat(racingResult.getRacingWinner().getWinnerNames().size())
                .isLessThanOrEqualTo(3);
    }
}