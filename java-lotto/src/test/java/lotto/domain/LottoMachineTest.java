package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LottoMachineTest {
    @DisplayName("1 ~ 45 사이 랜덤한 6개의 번호 생성하기")
    @Test
    void getRandom6Numbers() {
        // given
        final List<Integer> numbers = LottoMachine.getNumbers();

        // when
        final boolean result = numbers.stream()
                .allMatch(number -> 1 <= number && number <= 45);

        // then
        assertTrue(result);
        assertThat(numbers.size()).isSameAs(6);
    }
}