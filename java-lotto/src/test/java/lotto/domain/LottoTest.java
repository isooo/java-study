package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {

    @DisplayName("로또 생성 테스트")
    @Test
    void createLotto() {
        // given
        // when
        final Lotto lotto = new Lotto();

        // then
        assertThat(lotto.getSize()).isSameAs(6);
    }

    @DisplayName("당첨 번호와 일치하는 숫자 테스트")
    @Test
    void winningRateTest() {
        // given
        final Lotto lotto = new Lotto(Arrays.asList(6, 5, 4, 3, 2, 1));
        final Lotto winningNumbers = new Lotto(Arrays.asList(5, 6, 7, 8, 9, 10));

        // when
        final MatchingNumbers matchingNumbers = lotto.checkWinningRate(winningNumbers);

        // then
        assertThat(matchingNumbers.getNumbers()).containsExactly(5, 6);
    }
}