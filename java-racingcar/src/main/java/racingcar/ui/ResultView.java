package racingcar.ui;

import racingcar.domain.*;

public class ResultView {
    private StringBuilder sb;

    public ResultView() {
        this.sb = new StringBuilder();
    }

    public void record(final Cars cars) {
        for (int i = 0; i < cars.getCount(); i++) {
            final Car car = cars.getCarList().get(i);
            for (int j = 0; j < car.getPosition(); j++) {
                this.sb.append("-");
            }
            this.sb.append("\n");
        }
        this.sb.append("\n");
    }

    public void getResult() {
        System.out.println(this.sb.toString());
    }
}
