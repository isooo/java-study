package racingcar.domain;

import java.util.*;

public class Car {
    private static final int RANDOM_BOUND = 10;
    private static final int NUMBER_CONDITION_TO_MOVE = 4;

    private Long id;
    private int position;

    public Car(final Long id) {
        this.id = id;
        this.position = 0;
    }

    public Long getId() {
        return id;
    }

    public int getPosition() {
        return position;
    }

    public int move() {
        if (isMove()) {
            this.position++;
        }
        return this.position;
    }

    private boolean isMove() {
        return new Random().nextInt(RANDOM_BOUND) >= NUMBER_CONDITION_TO_MOVE;
    }
}
