package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class MatchedLottoes {
    private final List<MatchedLotto> matchedLottoes;

    public MatchedLottoes(final List<MatchedLotto> matchedLottoes) {
        this.matchedLottoes = matchedLottoes;
    }

    List<Integer> getWinningRates() {
        return matchedLottoes.stream()
                .map(matchedLotto -> matchedLotto.getWinningRate())
                .collect(Collectors.toList());
    }
}
