package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class LottoPrizeTest {
    @DisplayName("당첨된 숫자 개수에 따른 prize 테스트")
    @ParameterizedTest
    @CsvSource(value = {"6:FIRST", "3:FOURTH", "2:ZERO", "0:ZERO"}, delimiter = ':')
    void ofTest(final int hitCount, final String name) {
        // given
        // when
        final LottoPrize lottoPrize = LottoPrize.of(hitCount);

        // then
        assertThat(lottoPrize).isSameAs(LottoPrize.valueOf(name));
    }
}
