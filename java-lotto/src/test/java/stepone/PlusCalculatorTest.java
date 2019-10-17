package stepone;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

import java.util.*;
import java.util.stream.*;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class PlusCalculatorTest {

    @DisplayName("빈 문자열 또는 null 값 입력 시, 0 반환")
    @ParameterizedTest
    @NullAndEmptySource
    public void emptyOrNullThanReturnZero(final String input) {
        // given
        // when
        final int result = PlusCalculator.execute(input);

        // then
        assertThat(result).isEqualTo(0);
    }

    @DisplayName("숫자 하나 입력 시, 해당 숫자 반환")
    @Test
    void returnEqualToInput() {
        // given
        // when
        final List<Integer> results = IntStream.rangeClosed(0, 10)
                .mapToObj(i -> PlusCalculator.execute(String.valueOf(i)))
                .collect(Collectors.toList());

        final boolean result = IntStream.rangeClosed(0, 10)
                .allMatch(i -> results.get(i).equals(i));

        // then
        assertThat(result).isTrue();
    }

    @DisplayName("기본 구분자 사용 시, 합 반환")
    @ParameterizedTest
    @CsvSource(value = {"1,2|3", "2:3|5", "1,2:3|6"}, delimiter = '|')
    void sumReturnWhenUseDefaultDelimiter(final String value, final String expected) {
        // given
        final String input = value;

        // when
        final int result = PlusCalculator.execute(input);

        // then
        assertThat(result).isEqualTo(Integer.parseInt(expected));
    }

    @DisplayName("커스텀 구분자 사용 시, 합 반환")
    @ParameterizedTest
    @CsvSource(value = {"//;\\n1;2;3|6", "//%\\n1%2%4|7", "//]\\n8|8", "//$\\n8$9|17"}, delimiter = '|')
    void sumReturnWhenUseCustomDelimiter(final String value, final String expected) {
        // given
        // when
        final int result = PlusCalculator.execute(value);

        // then
        assertThat(result).isSameAs(Integer.parseInt(expected));
    }

    @DisplayName("음수 입력 시, RuntimeException 발생")
    @Test
    void runtimeExceptionWhenNegativeInput() {
        assertThrows(RuntimeException.class, () -> PlusCalculator.execute("1:-2:3"));
    }
}
