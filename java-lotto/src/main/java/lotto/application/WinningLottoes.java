package lotto.application;

import lotto.domain.MachedLottoes;

import java.util.List;

public class WinningLottoes {
    private final List<Integer> winningRates;

    WinningLottoes(final MachedLottoes matchedLottoes) {
        winningRates = getCounts(matchedLottoes);
    }

    private List<Integer> getCounts(final MachedLottoes matchedLottoes) {
        return matchedLottoes.getWinningRates();
    }

    List<Integer> get() {
        return winningRates;
    }

    public int getSize() {
        return winningRates.size();
    }

    public int getCountOfEachMatches(final int value) {
        return (int) winningRates.stream()
                .filter(result -> value == result)
                .count();
    }
}
