package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LottosResultTest {
    @DisplayName("LottoPrize 리스트로부터 LottosResult 생성하기")
    @Test
    void name() {
        // given
        final long expected = (LottoPrize.FIRST.getPrizeMoney() + (LottoPrize.FIFTH.getPrizeMoney() * 2)) / 4000;

        // when
        final LottosResult lottosResult = LottosResult.of(
                Arrays.asList(LottoPrize.FIFTH, LottoPrize.FIRST, LottoPrize.ZERO, LottoPrize.FIFTH)
        );

        // then

        assertThat(lottosResult.getRoi()).isEqualTo(expected);
    }
}
