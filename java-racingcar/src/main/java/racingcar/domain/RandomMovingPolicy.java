package racingcar.domain;

import racingcar.utils.*;

public class RandomMovingPolicy implements MovingPolicy {
    private static final int RANDOM_BOUND = 10;
    private static final int NUMBER_CONDITION_TO_MOVE = 4;

    @Override
    public boolean isPossible() {
        return RandomUtils.randomRange(RANDOM_BOUND) >= NUMBER_CONDITION_TO_MOVE;
    }
}
