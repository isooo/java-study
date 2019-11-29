package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {
    @DisplayName("로또 당첨 테스트")
    @Test
    void roiTest() {
        // given
        final LottoNumbers lottoNumbers = new LottoNumbers(1, 2, 3, 4, 5, 6);
        final Lotto lotto1 = new Lotto(lottoNumbers);
        final Lotto lotto2 = new Lotto(new LottoNumbers(2, 3, 4, 5, 6, 7));

        final Lottos lottos = new Lottos(Arrays.asList(lotto1, lotto2));

        // when
        final LottosResult lottosResult = lottos.calculateWinningStatistics(lottoNumbers, LottoNumber.get(10));

        // then
        assertThat(lottosResult.getRoi()).isEqualTo(1000075);
    }
}
