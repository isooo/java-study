package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
}