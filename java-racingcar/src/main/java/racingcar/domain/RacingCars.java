package racingcar.domain;

import java.util.*;
import java.util.stream.*;

public class RacingCars {
    private final List<RacingCar> racingCarList;

    public RacingCars(final String carsNames) {
        this.racingCarList = createCars(carsNames);
    }

    private List<RacingCar> createCars(final String carsNames) {
        final String[] namesArray = carsNames.split(",");
        return IntStream.rangeClosed(1, namesArray.length)
                .mapToObj(i -> new RacingCar(i, namesArray[i - 1]))
                .collect(Collectors.toList());
    }
}
