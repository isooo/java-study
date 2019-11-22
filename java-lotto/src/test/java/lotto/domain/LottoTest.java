package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {
    @DisplayName("로또 생성")
    @Test
    void create() {
        // given
        // when
        // then
        final Lotto lotto = Lotto.create();
    }

    @DisplayName("당첨 번호와 비교하여 통계 계산하기")
    @Test
    void calculateWinningStatisticsTest() {
        // given
        final LottoNumber LOTTO_1 = LottoNumber.get(1);
        final LottoNumber LOTTO_2 = LottoNumber.get(2);
        final LottoNumber LOTTO_3 = LottoNumber.get(3);
        final LottoNumber LOTTO_4 = LottoNumber.get(4);
        final LottoNumber LOTTO_5 = LottoNumber.get(5);
        final LottoNumber LOTTO_6 = LottoNumber.get(6);
        final LottoNumber LOTTO_7 = LottoNumber.get(7);
        final Lotto lotto = new Lotto(new LottoNumbers(Arrays.asList(LOTTO_1, LOTTO_2, LOTTO_3, LOTTO_4, LOTTO_5, LOTTO_6)));
        final LottoNumbers winningLottoNumbers = new LottoNumbers(Arrays.asList(LOTTO_2, LOTTO_3, LOTTO_4, LOTTO_5, LOTTO_6, LOTTO_7));

        // when
        final LottoPrize rank  = lotto.calculateWinningStatistics(winningLottoNumbers);

        // then
        assertThat(rank).isSameAs(LottoPrize.SECOND);
    }
}
