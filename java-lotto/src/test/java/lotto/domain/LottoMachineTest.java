package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoMachineTest {
    @DisplayName("로또용 LottoNumbers 리턴")
    @Test
    void getTest() {
        // given
        final LottoNumbers numbers = LottoMachine.getNumbers();

        // when
        final int size = numbers.get().size();

        // then
        assertThat(size).isSameAs(6);
    }
}