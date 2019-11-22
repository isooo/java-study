package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {
    @DisplayName("로또 당첨 테스트")
    @Test
    void name() {
        // given
        final LottoNumber LOTTO_1 = LottoNumber.get(1);
        final LottoNumber LOTTO_2 = LottoNumber.get(2);
        final LottoNumber LOTTO_3 = LottoNumber.get(3);
        final LottoNumber LOTTO_4 = LottoNumber.get(4);
        final LottoNumber LOTTO_5 = LottoNumber.get(5);
        final LottoNumber LOTTO_6 = LottoNumber.get(6);
        final LottoNumber LOTTO_7 = LottoNumber.get(7);
        final LottoNumbers lottoNumbers = new LottoNumbers(Arrays.asList(LOTTO_1, LOTTO_2, LOTTO_3, LOTTO_4, LOTTO_5, LOTTO_6));
        final Lotto lotto1 = new Lotto(lottoNumbers);
        final Lotto lotto2 = new Lotto(new LottoNumbers(Arrays.asList(LOTTO_2, LOTTO_3, LOTTO_4, LOTTO_5, LOTTO_6, LOTTO_7)));

        final Lottos lottos = new Lottos(Arrays.asList(lotto1, lotto2));

        // when
        final LottosResult lottosResult = lottos.calculateWinningStatistics(lottoNumbers);

        // then
        assertThat(lottosResult.getRoi()).isEqualTo(1000075);
    }
}
