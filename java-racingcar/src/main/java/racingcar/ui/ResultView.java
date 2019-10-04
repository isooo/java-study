package racingcar.ui;

import racingcar.application.*;
import racingcar.domain.*;

import java.util.*;
import java.util.stream.*;

public class ResultView {
    private static final String POSITION_DISPLAY = "-";
    private static final String NAME_SEPARATION_DISPLAY = " : ";

    public static void view(final RacingResult racingResult) {
        printStateOfRacing(racingResult.getTrackResults().getTrackResultList());
        System.out.println();
        printWinners(racingResult.getRacingWinner().getWinnerNames());
    }

    private static void printStateOfRacing(final List<TrackResult> trackResultList) {
        System.out.println("\n실행 결과");
        trackResultList.stream()
                .forEach(result -> {
                            System.out.println(result.getTrack());
                            printStateOfRacing(result);
                            System.out.println();
                        }
                );
    }

    private static void printStateOfRacing(final TrackResult trackResult) {
        trackResult.getCars().getCarList()
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

    private static void printWinners(final List<String> winnerNames) {
        final String names = winnerNames.stream()
                .collect(Collectors.joining(", "));
        System.out.println(String.format("%s가 최종 우승했습니다.", names));
    }
}