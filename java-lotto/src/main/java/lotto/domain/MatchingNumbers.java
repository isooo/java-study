package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class MatchingNumbers {
    private final List<Integer> numbers;

    public MatchingNumbers(final List<Integer> numbers) {
        this.numbers = new ArrayList<>(numbers);
    }

    List<Integer> getNumbers() {
        return new ArrayList<>(numbers);
    }
}
