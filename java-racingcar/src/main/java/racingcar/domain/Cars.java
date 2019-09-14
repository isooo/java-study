package racingcar.domain;

import java.util.*;
import java.util.stream.*;

public class Cars {
    private List<Car> cars;

    public Cars() {
        this.cars = new ArrayList<>();
    }

    private Cars(final List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCarList() {
        return cars;
    }

    public Cars registerCars(final int numberOfCars) {
        final List<Car> carList = IntStream.rangeClosed(1, numberOfCars)
                .mapToObj(i -> new Car())
                .collect(Collectors.toList());
        return new Cars(Collections.unmodifiableList(carList));
    }

    public int getCount() {
        return this.cars.size();
    }

    public void race() {
        for (int i = 0; i < getCount(); i++) {
            this.cars.get(i)
                    .move();
        }
    }
}
