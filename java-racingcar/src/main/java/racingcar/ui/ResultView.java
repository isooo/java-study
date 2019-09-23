package racingcar.ui;

import racingcar.domain.*;

import java.util.*;

public class ResultView {
    private static final String POSITION_DISPLAY = "-";

    public static void view(final List<Result> resultList) {
        resultList.stream()
                .forEach(result -> {
                            System.out.println(result.getTrack());
                            printResult(result);
                            System.out.println();
                        }
                );
    }

    private static void printResult(final Result result) {
        result.getCars().getCarList()
                .stream()
                .forEach(car -> printCarPosition(car));
    }

    private static void printCarPosition(final Car car) {
        for (int i = 0; i < car.getPosition(); i++) {
            System.out.print(POSITION_DISPLAY);
        }
        System.out.println();
    }
}
