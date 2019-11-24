package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
        final Lotto lotto = new Lotto(new LottoNumbers(1, 2, 3, 4, 5, 6));
        final LottoNumbers winningLottoNumbers = new LottoNumbers(2, 3, 4, 5, 6, 7);

        // when
        final LottoPrize rank = lotto.calculateWinningStatistics(winningLottoNumbers);

        // then
        assertThat(rank).isSameAs(LottoPrize.SECOND);
    }
}
