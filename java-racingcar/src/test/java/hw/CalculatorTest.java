package hw;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

import static org.assertj.core.api.Assertions.*;

class CalculatorTest {
    private Calculator calculator;

    @BeforeEach
    void init() {
        calculator = new Calculator();
    }

    @ParameterizedTest
    @ValueSource(strings = {"1 + 2 * 3", "10 - 6 / 2", "9 + 1"})
    void 계산_성공_테스트(String s) {
        // given
        // when
        final int result = calculator.execute(s);

        // then
        assertThat(result).isIn(9, 2, 10);
    }

    @ParameterizedTest
    @NullAndEmptySource
    void 공백_또는_빈문자열_입력시_예외처리_테스트(String s) {
        // given
        // when
        // then
        assertThatIllegalArgumentException().isThrownBy(
                () -> calculator.execute(s)
        );
    }
}