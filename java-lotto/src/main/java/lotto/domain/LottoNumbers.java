package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoNumbers {
    static final int TOTAL_LOTTO_COUNT = 6;

    private final List<LottoNumber> values;

    public LottoNumbers(final List<LottoNumber> values) {
        validate(values);
        this.values = new ArrayList<>(values);
    }

    public List<LottoNumber> get() {
        return new ArrayList<>(this.values);
    }

    private void validate(final List<LottoNumber> values) {
        checkDuplicate(values);
        checkTotalCount(values);
    }

    private void checkDuplicate(final List<LottoNumber> values) {
        final long count = values.stream()
                .distinct()
                .count();
        if (TOTAL_LOTTO_COUNT != count) {
            throw new IllegalArgumentException();
        }
    }

    private void checkTotalCount(final List<LottoNumber> values) {
        if (TOTAL_LOTTO_COUNT != values.size()) {
            throw new IllegalArgumentException();
        }
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
