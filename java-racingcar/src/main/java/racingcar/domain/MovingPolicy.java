package racingcar.domain;

import java.util.*;

public class MovingPolicy {
    private final int randomBound;
    private final int numberConditionToMove;

    public MovingPolicy(final int randomBound, final int numberConditionToMove) {
        this.randomBound = randomBound;
        this.numberConditionToMove = numberConditionToMove;
    }

    public boolean isPossible() {
        return new Random().nextInt(randomBound) >= numberConditionToMove;
    }
}
