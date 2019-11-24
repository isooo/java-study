package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

public class LottoNumbers {
    static final int TOTAL_LOTTO_COUNT = 6;

    private final Set<LottoNumber> values;

    public LottoNumbers(final List<LottoNumber> values) {
        this.values = validate(new LinkedHashSet<>(values));
    }

    LottoNumbers(int... values) {
        this(Arrays.stream(values)
                .mapToObj(value -> LottoNumber.get(value))
                .collect(Collectors.toList()));
    }

    public List<LottoNumber> get() {
        return new ArrayList<>(this.values);
    }

    private Set<LottoNumber> validate(final Set<LottoNumber> values) {
        if (TOTAL_LOTTO_COUNT != values.size()) {
            throw new IllegalArgumentException();
        }
        return values;
    }

    public long calculateCountOfWinningNumbers(final LottoNumbers winningLottoNumbers) {
        return this.values.stream()
                .filter(number -> winningLottoNumbers.isContains(number))
                .count();
    }

    private boolean isContains(final LottoNumber number) {
        return this.values.contains(number);
    }
}
