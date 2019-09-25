package racingcar.ui;

import racingcar.domain.*;

import java.util.*;
import java.util.stream.*;

public class ResultView {
    private static final String POSITION_DISPLAY = "-";
    private static final String NAME_SEPARATION_DISPLAY = " : ";

    public static void view(final List<Result> resultList) {
        printResult(resultList);
        System.out.println();
        printWinners(resultList);
    }

    private static void printResult(final List<Result> resultList) {
        System.out.println("\n실행 결과");
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
        System.out.print(car.getName() + NAME_SEPARATION_DISPLAY);
        for (int i = 0; i < car.getPosition(); i++) {
            System.out.print(POSITION_DISPLAY);
        }
        System.out.println();
    }

    private static void printWinners(final List<Result> resultList) {
        final List<String> winnerNames = RacingWinner.get(resultList);
        printNames(winnerNames);
    }

    private static void printNames(final List<String> winnerNames) {
        final String names = winnerNames.stream()
                .collect(Collectors.joining(", "));
        System.out.println(String.format("%s가 최종 우승했습니다.", names));
    }
}