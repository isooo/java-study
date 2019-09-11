package racingcar.domain;

import java.util.*;

public class Car {
    private static Long ID = 1L;

    private Long id;
    private int position;

    public Car() {
        this.id = ID++;
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
        return new Random().nextInt(10) >= 4;
    }
}
