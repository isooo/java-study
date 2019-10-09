package racingcar.domain;

@FunctionalInterface
public interface MovingPolicy {
    boolean isPossible();
}
