package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
}