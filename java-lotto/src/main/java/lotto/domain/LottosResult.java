package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottosResult {
    private final Map<LottoPrize, Integer> winningStatistics;

    private LottosResult(final List<LottoPrize> lottoPrizes) {
        this.winningStatistics = initialize(lottoPrizes);
    }

    public static LottosResult of(final List<LottoPrize> lottoPrizes) {
        return new LottosResult(lottoPrizes);
    }

    private static Map<LottoPrize, Integer> initialize(final List<LottoPrize> lottoPrizes) {
        final Map<LottoPrize, Integer> map = new HashMap<>();
        for (final LottoPrize lottoPrize : lottoPrizes) {
            int count = 0;
            if (map.containsKey(lottoPrize)) {
                count = map.get(lottoPrize);
            }
            map.put(lottoPrize, ++count);
        }
        return map;
    }

    public Map<LottoPrize, Integer> get() {
        return winningStatistics;
    }

    public long getRoi() {
        return getTotalPrizeMoney() / getAsset();
    }

    private long getAsset() {
        final long count = winningStatistics.values().stream()
                .mapToLong(Long::valueOf)
                .sum();
        return count * LottoStore.LOTTO_AMOUNT_UNIT;
    }

    private long getTotalPrizeMoney() {
        return winningStatistics.entrySet().stream()
                .mapToLong(ele -> ele.getKey().getPrizeMoney() * ele.getValue())
                .sum();
    }
}
