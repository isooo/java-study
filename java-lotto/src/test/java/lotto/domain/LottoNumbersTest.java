package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoNumbersTest {
    @DisplayName("중복되지 않는 6개의 LottoNumbers 테스트")
    @Test
    void create() {
        new LottoNumbers(1, 2, 3, 4, 5, 6);
    }

    @DisplayName("숫자 중복 포함 테스트")
    @Test
    void includeDuplicateNumbers() {
        // given
        // when
        // then
        assertThatIllegalArgumentException().isThrownBy(
                () -> new LottoNumbers(1, 2, 1, 2, 1, 2));
    }

    @DisplayName("LottoNumber를 6개 초과한 경우 테스트")
    @Test
    void exceededCountLimit() {
        // given
        // when
        // then
        assertThatIllegalArgumentException().isThrownBy(
                () -> new LottoNumbers(1, 2, 3, 4, 5, 6, 7));
    }

    @DisplayName("당첨된 번호 개수 구하기")
    @Test
    void calculateCountOfWinningNumbers() {
        // given
        final LottoNumbers lottoNumbers = new LottoNumbers(1, 2, 3, 4, 5, 6);
        final LottoNumbers winningLottoNumbers = new LottoNumbers(2, 3, 4, 5, 6, 7);

        // when
        final long result = lottoNumbers.calculateCountOfWinningNumbers(winningLottoNumbers);

        // then
        assertThat(result).isSameAs(5L);
    }
}
