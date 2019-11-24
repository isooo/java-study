package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

public class LottoNumbers {
    static final int TOTAL_LOTTO_COUNT = 6;

    // TODO 5: 요소의 중복을 방지하기 위해 컬렉션을 Set으로 변경
    private final Set<LottoNumber> values;

    public LottoNumbers(final List<LottoNumber> values) {
        validate(values);
        this.values = new LinkedHashSet<>(values);
    }

    LottoNumbers(int... values) {
        this(Arrays.stream(values)
                .mapToObj(value -> LottoNumber.get(value))
                .collect(Collectors.toList()));
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
