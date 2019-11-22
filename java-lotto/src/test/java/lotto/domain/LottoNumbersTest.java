package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoNumbersTest {
    private static final LottoNumber LOTTO_1 = LottoNumber.get(1);
    private static final LottoNumber LOTTO_2 = LottoNumber.get(2);
    private static final LottoNumber LOTTO_3 = LottoNumber.get(3);
    private static final LottoNumber LOTTO_4 = LottoNumber.get(4);
    private static final LottoNumber LOTTO_5 = LottoNumber.get(5);
    private static final LottoNumber LOTTO_6 = LottoNumber.get(6);
    private static final LottoNumber LOTTO_45 = LottoNumber.get(45);

    @DisplayName("중복되지 않는 6개의 LottoNumbers 테스트")
    @Test
    void create() {
        new LottoNumbers(Arrays.asList(LOTTO_1, LOTTO_2, LOTTO_3, LOTTO_4, LOTTO_5, LOTTO_6));
    }

    @DisplayName("숫자 중복 포함 테스트")
    @Test
    void includeDuplicateNumbers() {
        // given
        // when
        // then
        assertThatIllegalArgumentException().isThrownBy(
                () -> new LottoNumbers(Arrays.asList(LOTTO_1, LOTTO_2, LOTTO_1, LOTTO_2, LOTTO_1, LOTTO_2))
        );
    }

    @DisplayName("LottoNumber를 6개 초과한 경우 테스트")
    @Test
    void exceededCountLimit() {
        // given
        // when
        // then
        assertThatIllegalArgumentException().isThrownBy(
                () -> new LottoNumbers(Arrays.asList(LOTTO_1, LOTTO_2, LOTTO_3, LOTTO_4, LOTTO_5, LOTTO_6, LOTTO_45))
        );
    }

    @DisplayName("당첨된 번호 개수 구하기")
    @Test
    void calculateCountOfWinningNumbers() {
        // given
        final LottoNumber LOTTO_1 = LottoNumber.get(1);
        final LottoNumber LOTTO_2 = LottoNumber.get(2);
        final LottoNumber LOTTO_3 = LottoNumber.get(3);
        final LottoNumber LOTTO_4 = LottoNumber.get(4);
        final LottoNumber LOTTO_5 = LottoNumber.get(5);
        final LottoNumber LOTTO_6 = LottoNumber.get(6);
        final LottoNumber LOTTO_7 = LottoNumber.get(7);
        final LottoNumbers lottoNumbers = new LottoNumbers(Arrays.asList(LOTTO_1, LOTTO_2, LOTTO_3, LOTTO_4, LOTTO_5, LOTTO_6));
        final LottoNumbers winningLottoNumbers = new LottoNumbers(Arrays.asList(LOTTO_2, LOTTO_3, LOTTO_4, LOTTO_5, LOTTO_6, LOTTO_7));

        // when
        final long result = lottoNumbers.calculateCountOfWinningNumbers(winningLottoNumbers);

        // then
        assertThat(result).isSameAs(5L);
    }
}
