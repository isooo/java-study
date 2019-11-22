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
        final long expected = (LottoPrize.FIRST.getPrizeMoney() + (LottoPrize.FOURTH.getPrizeMoney() * 2)) / 4000;

        // when
        final LottosResult lottosResult = LottosResult.of(
                Arrays.asList(LottoPrize.FOURTH, LottoPrize.FIRST, LottoPrize.ZERO, LottoPrize.FOURTH)
        );

        // then

//        System.out.println(lottosResult.get());
        System.out.println(expected);
        assertThat(lottosResult.getRoi()).isEqualTo(expected);
    }
}
