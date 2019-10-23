package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class LottoMachine {
    private static final List<Integer> NUMBERS = new ArrayList<>();

    static {
        IntStream.rangeClosed(1, 45)
                .forEach(i -> NUMBERS.add(i));
    }

    private LottoMachine() {
    }

    public static synchronized List<Integer> getNumbers() {
        Collections.shuffle(NUMBERS);
        final List<Integer> selectedNumbers = new ArrayList<>();
        IntStream.rangeClosed(1, 6)
                .forEach(i -> selectedNumbers.add(NUMBERS.get(i)));
        Collections.sort(selectedNumbers);
        return selectedNumbers;
    }
}
