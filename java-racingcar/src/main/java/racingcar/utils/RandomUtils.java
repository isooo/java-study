package racingcar.utils;

import java.util.*;

public class RandomUtils {
    public static int randomRange(final int bound) {
        return new Random().nextInt(bound);
    }
}
