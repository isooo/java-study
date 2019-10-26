package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    Lotto() {
        this.numbers = LottoMachine.getNumbers();
    }

    Lotto(final List<Integer> numbers) {
        this.numbers = new ArrayList<>(numbers);
    }

    private List<Integer> sort(final List<Integer> numbers) {
        final List<Integer> temp = new ArrayList<>(numbers);
        Collections.sort(temp);
        return temp;
    }

    int getSize() {
        return numbers.size();
    }

    private List<Integer> getNumberList() {
        return new ArrayList<>(numbers);
    }

    MatchedLotto checkWinningRate(final Lotto winningNumbers) {
        final List<Integer> machedNumbers = winningNumbers.getNumberList()
                .stream()
                .filter(n -> numbers.contains(n))
                .collect(Collectors.toList());
        return new MatchedLotto(machedNumbers);
    }
}
