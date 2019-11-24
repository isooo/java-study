package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class LottoStoreTest {
    @DisplayName("주어진 액수 만큼 로또 구매하기")
    @ParameterizedTest
    @CsvSource(value = {"500:0", "1000:1", "1500:1", "13500:13"}, delimiter = ':')
    void purchaseLottos(final String value, final int count) {
        // given
        // when
        final Lottos lottos = LottoStore.purchase(value);

        // then
        assertThat(lottos.size()).isSameAs(count);
    }
}