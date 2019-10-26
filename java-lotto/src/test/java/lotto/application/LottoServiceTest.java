package lotto.application;

import lotto.domain.Lotto;
import lotto.domain.Lottoes;
import lotto.domain.MachedLottoes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoServiceTest {
    private LottoService lottoService;

    @BeforeEach
    void setUp() {
        lottoService = new LottoService();
    }

    @DisplayName("숫자 입력 시, 해당 숫자만큼의 로또 발급하기")
    @Test
    void lottoCount() {
        // given
        // when
        final Lottoes lottoes = lottoService.getLottoes(3);

        // then
        assertThat(lottoes.getCount()).isSameAs(3);
    }

    @DisplayName("발급된 로또 내 숫자 6자리 확인")
    @Test
    void lottoNumberTest() {
        // given
        // when
        final Lottoes lottoes = lottoService.getLottoes(2);

        // then
        assertThat(lottoes.getLotto(0)).isNotEqualTo(lottoes.getLotto(1));
    }

    @DisplayName("발급된 로또와 당첨 번호 입력 시, 당첨 결과 테스트")
    @Test
    void winningLottoesTest() {
        // given
        final Lottoes lottoes = new Lottoes(
                Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new Lotto(Arrays.asList(15, 13, 11, 9, 7, 6)),
                new Lotto(Arrays.asList(20, 19, 18, 17, 16, 15))
        ));
        final List<Integer> winningNumbers = Arrays.asList(3, 4, 5, 6, 7, 8);

        // when
        final WinningLottoes winningLottoes = lottoService.matchingWinningNumbers(winningNumbers, lottoes);

        // then
        assertThat(winningLottoes.get()).containsExactly(4, 2, 0);
    }
}