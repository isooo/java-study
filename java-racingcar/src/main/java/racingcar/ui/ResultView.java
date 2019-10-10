package racingcar.ui;

import racingcar.domain.*;

import java.util.*;
import java.util.stream.*;

public class ResultView {
    private static final String POSITION_DISPLAY = "-";
    private static final String NAME_SEPARATION_DISPLAY = " : ";

    public static void view(final List<RacingCars> racingCarsByRound) {
        System.out.println("\n실행 결과");
        printResult(racingCarsByRound);
        printWinners(racingCarsByRound.get(racingCarsByRound.size() - 1));
    }

    private static void printResult(final List<RacingCars> racingCarsByRound) {
        racingCarsByRound.stream()
                .forEach(racingCars -> printRoundResult(racingCars));
    }

    private static void printRoundResult(final RacingCars racingCars) {
        racingCars.getRacingCarList().stream()
                .forEach(racingCar -> printRacingCar(racingCar));
        System.out.println();
    }

    private static void printRacingCar(final RacingCar racingCar) {
        System.out.print(racingCar.getName() + NAME_SEPARATION_DISPLAY);
        for (int i = 0; i < racingCar.getPosition(); i++) {
            System.out.print(POSITION_DISPLAY);
        }
        System.out.println();
    }

    private static void printWinners(final RacingCars racingCars) {
        final String names = racingCars.getWinners().stream()
                .collect(Collectors.joining(", "));
        System.out.println(String.format("%s가 최종 우승했습니다.", names));
    }
}
