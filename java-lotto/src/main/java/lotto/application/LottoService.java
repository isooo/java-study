package lotto.application;

import lotto.domain.Lotto;
import lotto.domain.Lottoes;
import lotto.domain.MachedLottoes;

import java.util.List;

public class LottoService {
    public Lottoes getLottoes(final int amount) {
        return new Lottoes(amount);
    }

    public WinningLottoes matchingWinningNumbers(final List<Integer> winningNumbers, final Lottoes lottoes) {
        final MachedLottoes matchedLottoes = lottoes.getMatchedLottoes(new Lotto(winningNumbers));
        return new WinningLottoes(matchedLottoes);
    }
}
