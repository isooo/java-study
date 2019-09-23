package racingcar.ui;

import java.util.*;

public class InputView {
    private final static Scanner INPUT_SCANNER = new Scanner(System.in);
    private final static String CAR_COUNT = "자동차는 몇 대 인가요? : ";
    private final static String TRACK_COUNT = "시도할 횟수는 몇 회 인가요? : ";

    public static String getCarCount() {
        System.out.print(CAR_COUNT);
        return readLine();
    }

    public static String getTrackCount() {
        System.out.print(TRACK_COUNT);
        return readLine();
    }

    private static String readLine() {
        return INPUT_SCANNER.nextLine();
    }
}
