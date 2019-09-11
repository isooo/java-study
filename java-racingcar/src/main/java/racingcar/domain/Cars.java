package racingcar.domain;

import java.util.*;

public class Cars {
    private List<Car> cars;

    public Cars() {
        this.cars = new ArrayList<>();
    }

    public Cars(final List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCarList() {
        return cars;
    }

    public Cars registerCars(final int numberOfCars) {
        for (int i = 0; i < numberOfCars; i++) {
            this.cars.add(new Car());
        }
        return new Cars(Collections.unmodifiableList(this.cars));
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
