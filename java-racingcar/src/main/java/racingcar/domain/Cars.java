package racingcar.domain;

import java.util.*;

public class Cars {
    private List<Car> cars;

    public Cars() {
        this.cars = new ArrayList<>();
    }

    public List<Car> getCars() {
        return cars;
    }

    public void createCars(final int numberOfCars) {
        for (int i = 0; i < numberOfCars; i++) {
            this.cars.add(new Car());
        }
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
