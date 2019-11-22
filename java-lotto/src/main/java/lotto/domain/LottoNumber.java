package lotto.domain;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {
    static final int MIN_NUMBER = 1;
    static final int MAX_NUMBER = 45;

    private final int value;

    private LottoNumber(final int value) {
        this.value = validate(value);
    }

    public static LottoNumber get(final int value) {
        return new LottoNumber(value);
    }

    private int validate(final int value) {
        if (value < MIN_NUMBER || value > MAX_NUMBER) {
            throw new IllegalArgumentException();
        }
        return value;
    }

    @Override
    public int compareTo(final LottoNumber o) {
        return Integer.compare(this.value, o.value);
    }

    @Override
    public String toString() {
        return String.valueOf(this.value);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof LottoNumber)) return false;
        final LottoNumber that = (LottoNumber) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
