package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Lottos {
    private final List<Lotto> lottos;

    Lottos(final List<Lotto> lottos) {
        this.lottos = new ArrayList<>(lottos);
    }

    public List<Lotto> get() {
        return new ArrayList<>(this.lottos);
    }

    public int size() {
        return this.lottos.size();
    }

    public LottosResult calculateWinningStatistics(final LottoNumbers winningLottoNumbers, final LottoNumber bonusLottoNumber) {
        final boolean matchBonus = this.lottos.stream()
                .anyMatch(lotto -> lotto.contains(bonusLottoNumber));
        final List<LottoPrize> lottoPrizes = this.lottos.stream()
                .map(lotto -> lotto.calculateWinningStatistics(winningLottoNumbers, matchBonus))
                .collect(Collectors.toList());
        return LottosResult.of(lottoPrizes);
    }
}
