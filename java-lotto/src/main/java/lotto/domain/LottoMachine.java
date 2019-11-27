package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoMachine {
    private static final List<LottoNumber> LOTTO_NUMBERS;

    static {
        LOTTO_NUMBERS = IntStream.rangeClosed(LottoNumber.MIN_NUMBER, LottoNumber.MAX_NUMBER)
                .mapToObj(value -> LottoNumber.get(value))
                .collect(Collectors.toList());
    }

    public static LottoNumbers getNumbers() {
        Collections.shuffle(LOTTO_NUMBERS);
        final List<LottoNumber> selectedNumbers = LOTTO_NUMBERS.subList(0, LottoNumbers.TOTAL_LOTTO_COUNT);
        Collections.sort(selectedNumbers);
        return new LottoNumbers(selectedNumbers);
    }
}
