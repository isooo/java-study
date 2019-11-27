package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoNumberTest {
    @DisplayName("LottoNumber 정렬하기")
    @Test
    void compareTest () {
        // given
        // when
        final LottoNumber lottoNumber1 = LottoNumber.get(10);
        final LottoNumber lottoNumber2 = LottoNumber.get(20);

        // then
        assertThat(lottoNumber1).isLessThan(lottoNumber2);

    }

    @DisplayName("validate 테스트")
    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    void validateTest(final int value) {
        // given
        // when
        // then
        assertThatIllegalArgumentException().isThrownBy(
                () -> LottoNumber.get(value)
        );
    }
}