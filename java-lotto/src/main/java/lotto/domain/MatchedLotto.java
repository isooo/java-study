package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class MatchedLotto {
    private final List<Integer> numbers;

    public MatchedLotto(final List<Integer> numbers) {
        this.numbers = new ArrayList<>(numbers);
    }

    int getWinningRate() {
        return numbers.size();
    }

    List<Integer> getNumbers() {
        return new ArrayList<>(numbers);
    }
}
