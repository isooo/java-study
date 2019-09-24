package racingcar.domain;

import com.sun.tools.javac.util.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

import static org.assertj.core.api.Assertions.*;

class CarsTest {
    @DisplayName("자동차 이름 목록으로 Cars 생성 테스트")
    @ParameterizedTest
    @CsvSource(value = {"isooo:1", "a,b,c,d,e:5"}, delimiter = ':')
    void registerCarsByNames(final String names, final String expected) {
        // given
        // when
        final Cars cars = new Cars(names);

        // then
        assertThat(cars.getCarList().size())
                .isEqualTo(Integer.parseInt(expected));
    }

    @DisplayName("Cars 깊은 복사 테스트")
    @Test
    void deepCopyCars() {
        // given
        final Cars cars = new Cars(List.of(new Car(1, "a"), new Car(2, "b")));

        // when
        final Cars copiedCars = cars.copy();

        // then
        assertThat(cars.hashCode() != copiedCars.hashCode())
                .isTrue();
    }
}