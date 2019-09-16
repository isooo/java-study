package racingcar.ui;

import racingcar.domain.*;

public class ResultView {
    private static StringBuilder record(final Cars cars) {
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cars.getCount(); i++) {
            final Car car = cars.getCarList().get(i);
            for (int j = 0; j < car.getPosition(); j++) {
                sb.append("-");
            }
            sb.append("\n");
        }
        sb.append("\n");
        return sb;
    }

    public static void view(final Cars cars) {
        final StringBuilder sb = record(cars);
        System.out.println(sb.toString());
    }
}
