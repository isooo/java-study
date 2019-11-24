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
            // TODO 1: Map에서 제공되는 API 활용하기 (getOrDefault)
            map.getOrDefault(lottoPrize, 0);
            map.put(lottoPrize, map.getOrDefault(lottoPrize, 0) + 1);
        }
        return map;
    }

    public Map<LottoPrize, Integer> get() {
        // TODO 2: 새로운 컬렉션 인스턴스 생성하여 넘기기
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
