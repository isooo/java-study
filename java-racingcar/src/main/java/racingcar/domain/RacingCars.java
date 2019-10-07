package racingcar.domain;

import racingcar.utils.*;

import java.util.*;
import java.util.concurrent.*;
import java.util.stream.*;

public class RacingCars {
    private static final int RANDOM_BOUND = 10;
    private static final int NUMBER_CONDITION_TO_MOVE = 4;

    private final List<RacingCar> racingCarList;

    public RacingCars(final String carsNames) {
        this.racingCarList = createCars(carsNames);
    }

    private RacingCars(final List<RacingCar> racingCarList) {
        this.racingCarList = new ArrayList<>(racingCarList);
    }

    private List<RacingCar> createCars(final String carsNames) {
        final String[] namesArray = StringUtils.separate(carsNames);
        return IntStream.rangeClosed(1, namesArray.length)
                .mapToObj(i -> new RacingCar(i, namesArray[i - 1]))
                .collect(Collectors.toList());
    }

    RacingCars move() {
        final List<RacingCar> racingCarList = this.racingCarList.stream()
                .map(racingCar -> racingCar.move(isMove()))
                .collect(Collectors.toList());
        return new RacingCars(racingCarList);
    }

    private static boolean isMove() {
        return new Random().nextInt(RANDOM_BOUND) >= NUMBER_CONDITION_TO_MOVE;
    }

    public List<RacingCar> getRacingCarList() {
        return racingCarList;
    }

    public List<String> getWinners() {
        final int theBiggestPosition = getTheBiggestPosition();
        return racingCarList.stream()
                .filter(racingCar -> racingCar.getPosition() >= theBiggestPosition)
                .map(car -> car.getName())
                .collect(Collectors.toList());
    }

    private int getTheBiggestPosition() {
        int theBiggestPosition = 0;
        for (RacingCar racingCar : racingCarList) {
            int temp = racingCar.getPosition();
            if (temp > theBiggestPosition) {
                theBiggestPosition = temp;
            }
        }
        return theBiggestPosition;
    }
}
