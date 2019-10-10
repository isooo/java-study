package racingcar.domain;

import java.util.*;

public class RandomMovingPolicy implements MovingPolicy {
    private static final int RANDOM_BOUND = 10;
    private static final int NUMBER_CONDITION_TO_MOVE = 4;

    @Override
    public boolean isPossible() {
        return new Random().nextInt(RANDOM_BOUND) >= NUMBER_CONDITION_TO_MOVE;
    }
}
