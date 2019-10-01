package racingcar.domain;

import racingcar.utils.*;

import java.util.*;
import java.util.stream.*;

public class Cars {
    private final List<Car> cars;

    public Cars(final String carsNames) {
        this.cars = register(carsNames);
    }

    private Cars(final List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCarList() {
        return Collections.unmodifiableList(this.cars);
    }

    private List<Car> register(final String carsNames) {
        final String[] separatedCarNames = StringUtils.separate(carsNames);
        final int numberOfCars = separatedCarNames.length;

        return IntStream.rangeClosed(1, numberOfCars)
                .mapToObj(i -> new Car(i, separatedCarNames[i - 1]))
                .collect(Collectors.toList());
    }

    public Cars copy() {
        final List<Car> capturedCars = cars.stream()
                .map(car -> car.copy())
                .collect(Collectors.toList());
        return new Cars(capturedCars);
    }
}

