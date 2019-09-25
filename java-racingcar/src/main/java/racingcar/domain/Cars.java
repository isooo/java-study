package racingcar.domain;

import racingcar.utils.*;

import java.util.*;
import java.util.stream.*;

public class Cars {
    private final List<Car> cars;

    public Cars(final String carsNames) {
        this.cars = register(carsNames);
    }

    public Cars(final List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCarList() {
        return Collections.unmodifiableList(this.cars);
    }

    private List<Car> register(final String carsNames) {
        if (StringUtils.isEmpty(carsNames)) {
            throw new IllegalArgumentException("자동차 이름이 입력되지 않았습니다.");
        }
        final String[] SeparatedCarsNames = CarUtils.separate(carsNames);
        final int numberOfCars = SeparatedCarsNames.length;

        return IntStream.rangeClosed(1, numberOfCars)
                .mapToObj(i -> new Car(i, SeparatedCarsNames[i - 1]))
                .collect(Collectors.toList());
    }

    public Cars copy() {
        final List<Car> capturedCars = cars.stream()
                .map(car -> car.copy())
                .collect(Collectors.toList());
        return new Cars(capturedCars);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cars cars1 = (Cars) o;
        return Objects.equals(cars, cars1.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars);
    }
}
