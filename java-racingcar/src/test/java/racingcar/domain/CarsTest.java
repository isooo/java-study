package racingcar.domain;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

import static org.assertj.core.api.Assertions.*;

class CarsTest {
    @DisplayName("자동차 이름 목록으로 Cars 생성 성공 테스트")
    @ParameterizedTest
    @CsvSource(value = {"isooo:1", "a,b,c,d,e:5"}, delimiter = ':')
    void createCarsByNames(final String names, final String expected) {
        // given
        // when
        final Cars cars = new Cars(names);

        // then
        assertThat(cars.getCarList().size())
                .isEqualTo(Integer.parseInt(expected));
    }
}