package racingcar.infra;

import racingcar.domain.*;

import java.util.*;

public class MovingPolicyMoreThanFour implements MovingPolicy {
    @Override
    public boolean isPossible() {
        return new Random().nextInt(9) >= 4;
    }
}
