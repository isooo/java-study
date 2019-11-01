package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    Lotto() {
        this.numbers = LottoMachine.getNumbers();
    }

    public Lotto(final List<Integer> numbers) {
        this.numbers = new ArrayList<>(numbers);
    }

    int getSize() {
        return numbers.size();
    }

    private List<Integer> getNumberList() {
        return new ArrayList<>(numbers);
    }

    MatchedLotto getMatchedLotto(final Lotto winningNumbers) {
        final List<Integer> machedNumbers = winningNumbers.getNumberList()
                .stream()
                .filter(n -> numbers.contains(n))
                .collect(Collectors.toList());
        return new MatchedLotto(machedNumbers);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
