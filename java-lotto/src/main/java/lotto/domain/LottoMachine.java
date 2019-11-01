package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class LottoMachine {
    private static final List<Integer> NUMBERS = new ArrayList<>();
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int MIN_COUNT = 1;
    private static final int MAX_COUNT = 6;


    static {
        IntStream.rangeClosed(MIN_NUMBER, MAX_NUMBER)
                .forEach(i -> NUMBERS.add(i));
    }

    private LottoMachine() {
    }

    public static synchronized List<Integer> getNumbers() {
        Collections.shuffle(NUMBERS);
        final List<Integer> selectedNumbers = new ArrayList<>();
        IntStream.rangeClosed(MIN_COUNT, MAX_COUNT)
                .forEach(i -> selectedNumbers.add(NUMBERS.get(i)));
        Collections.sort(selectedNumbers);
        return selectedNumbers;
    }
}
