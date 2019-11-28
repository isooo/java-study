package lotto.domain;

import java.util.Arrays;

public enum LottoPrize {
    FIRST(6, 2_000_000_000L),
    SECOND(5, 30_000_000L),
    THIRD(5, 150_000L),
    FOURTH(4, 50_000L),
    FIFTH(3, 5_000L),
    ZERO(0, 0L);

    private final int hitCount;
    private final long prizeMoney;

    LottoPrize(final int hitCount, final Long prizeMoney) {
        this.hitCount = hitCount;
        this.prizeMoney = prizeMoney;
    }

    public static LottoPrize of(final long value, final boolean matchBonus) {
        if (value == THIRD.hitCount && matchBonus) {
            return SECOND;
        }
        return Arrays.stream(LottoPrize.values())
                .filter(rank -> rank.hitCount == value)
                .findFirst()
                .orElse(ZERO);
    }

    public int getHitCount() {
        return hitCount;
    }

    public Long getPrizeMoney() {
        return prizeMoney;
    }
}
