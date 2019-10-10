package racingcar.domain;

import java.util.*;

public class RandomMovingPolicy implements MovingPolicy {
    @Override
    public boolean isPossible() {
        return new Random().nextInt(9) >= 4;
    }
}
