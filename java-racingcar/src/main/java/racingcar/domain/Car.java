package racingcar.domain;

import java.util.*;
import java.util.concurrent.atomic.*;

public class Car {
    private static AtomicLong AUTOINCREMENT_ID = new AtomicLong(1);
    private static final int RANDOM_BOUND = 10;
    private static final int NUMBER_CONDITION_TO_MOVE = 4;

    private Long id;
    private int position;

    public Car() {
        this.id = AUTOINCREMENT_ID.getAndIncrement();
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
