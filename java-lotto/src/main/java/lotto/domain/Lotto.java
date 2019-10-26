package lotto.domain;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    Lotto() {
        this.numbers = LottoMachine.getNumbers();
    }

    int getSize() {
        return numbers.size();
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
