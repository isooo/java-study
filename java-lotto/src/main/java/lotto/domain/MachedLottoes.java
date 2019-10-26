package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class MachedLottoes {
    private final List<MatchedLotto> matchedLottoes;

    public MachedLottoes(final List<MatchedLotto> matchedLottoes) {
        this.matchedLottoes = matchedLottoes;
    }

    public List<Integer> getWinningRates() {
        return matchedLottoes.stream()
                .map(matchedLotto -> matchedLotto.getWinningRate())
                .collect(Collectors.toList());
    }
}
