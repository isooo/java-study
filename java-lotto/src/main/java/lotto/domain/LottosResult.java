package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottosResult {
    private final Map<LottoPrize, Integer> winningStatistics;
    private final long roi;

    private LottosResult(final List<LottoPrize> lottoPrizes) {
        this.winningStatistics = initialize(lottoPrizes);
        this.roi = calculateRoi();
    }

    private long calculateRoi() {
        return getTotalPrizeMoney() / getAsset();
    }

    public static LottosResult of(final List<LottoPrize> lottoPrizes) {
        return new LottosResult(lottoPrizes);
    }

    private static Map<LottoPrize, Integer> initialize(final List<LottoPrize> lottoPrizes) {
        final Map<LottoPrize, Integer> map = new HashMap<>();
        for (final LottoPrize lottoPrize : lottoPrizes) {
            map.getOrDefault(lottoPrize, 0);
            map.put(lottoPrize, map.getOrDefault(lottoPrize, 0) + 1);
        }
        return map;
    }

    public Map<LottoPrize, Integer> get() {
        return new HashMap<>(winningStatistics);
    }

    public long getRoi() {
        return this.roi;
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
