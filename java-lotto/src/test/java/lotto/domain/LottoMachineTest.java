package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertFalse;

class LottoMachineTest {
    @DisplayName("랜덤한 6자리 번호 생성하기")
    @Test
    void getRandom6Numbers() {
        // given
        final List<Integer> numbers1 = LottoMachine.getNumbers();
        final List<Integer> numbers2 = LottoMachine.getNumbers();

        // when
        final boolean isSame = IntStream.rangeClosed(1, 6)
                .allMatch(i -> numbers1.get(i) == numbers2.get(i));

        // then
        assertFalse(isSame);
    }
}