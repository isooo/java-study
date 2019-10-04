package racingcar.domain;

import java.util.*;

public class RacingWinner {
    private final List<String> winnerNames;

    RacingWinner(final List<String> winnerNames) {
        this.winnerNames = Collections.unmodifiableList(winnerNames);
    }

    public List<String> getWinnerNames() {
        return Collections.unmodifiableList(winnerNames);
    }
}
