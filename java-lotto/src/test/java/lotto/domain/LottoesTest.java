package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LottoesTest {

    @DisplayName("숫자 입력시, 해당하는 만큼의 로또 생성 테스트")
    @Test
    void createLottoesAsNumber() {
        // given
        // when
        final Lottoes lottoes = new Lottoes(10);

        // then
        assertThat(lottoes.getCount()).isSameAs(10);
    }

    @DisplayName("구입한 로또 별 당첨 결과 리스트 생성 테스트")
    @Test
    void winLottoesResult() {
        // given
        final Lottoes lottoes = new Lottoes(Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new Lotto(Arrays.asList(12, 11, 10, 9, 8, 7))
        ));

        // when
        final MatchedLottoes matchedLottoes = lottoes.checkWinningRate(new Lotto(Arrays.asList(3, 4, 5, 6, 7, 8)));

        // then
        assertThat(matchedLottoes.getWinningRates()).containsExactly(4, 2);
    }

    @DisplayName("구입한 로또가 모두 꽝일 때 결과 리스트 생성 테스트")
    @Test
    void notWinLottoesResult() {
        // given
        final Lottoes lottoes = new Lottoes(Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new Lotto(Arrays.asList(20, 19, 18, 17, 16, 15))
        ));

        // when
        final MatchedLottoes matchedLottoes = lottoes.checkWinningRate(new Lotto(Arrays.asList(30, 31, 32, 33, 34, 45)));

        // then
        assertThat(matchedLottoes.getWinningRates()).containsExactly(0, 0);
    }
}