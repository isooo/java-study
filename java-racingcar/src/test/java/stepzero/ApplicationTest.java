package stepzero;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class ApplicationTest {
    @Test
    void 요구사항_1() {
        // given
        final String target = "1,2";

        // when
        final String[] split = target.split(",");

        // then
        assertThat(split).contains("1");
        assertThat(split).containsExactly("1", "2");
    }

    @Test
    void 요구사항_2() {
        // given
        final String target = "(1,2)";

        // when
        final String result = target.substring(1, target.length() - 1);

        // then
        assertThat(result).contains("1,2");
    }

    @Test
    void 요구사항_3() {
        // given
        final String target = "abc";

        // when
        // then
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() ->
                    target.charAt(target.length()))
                .withMessageMatching("String index out of range: 3");
    }
}