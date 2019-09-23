package racingcar.domain;

import java.util.*;
import java.util.stream.*;

public class Cars {
    private List<Car> cars;

    public Cars(final int numberOfCars) {
        this.cars = registerCars(numberOfCars);
    }

    public List<Car> getCarList() {
        return new ArrayList<>(cars);
    }

    private List<Car> registerCars(final int numberOfCars) {
        return LongStream.rangeClosed(1, numberOfCars)
                .mapToObj(i -> new Car(i))
                .collect(Collectors.toList());
    }
}
