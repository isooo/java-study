package racingcar.ui;

import java.util.*;

public class InputView {
    private final static Scanner INPUT_SCANNER = new Scanner(System.in);
    private final static String ASK_NAMES_OF_CARS = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분) : ";
    private final static String ASK_TRACK_COUNT = "시도할 횟수는 몇 회 인가요? : ";

    public static String askNamesOfCars() {
        System.out.print(ASK_NAMES_OF_CARS);
        return readLine();
    }

    public static String askTrackCount() {
        System.out.print(ASK_TRACK_COUNT);
        return readLine();
    }

    private static String readLine() {
        return INPUT_SCANNER.nextLine();
    }
}
