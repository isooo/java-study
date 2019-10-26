package lotto.ui;

import lotto.application.LottoService;
import lotto.application.WinningLottoes;
import lotto.domain.Lottoes;
import lotto.domain.MachedLottoes;

import java.util.List;

public class LottoController {
    public static void run(final LottoService lottoService) {
        final int amount = InputView.getCount();
        final Lottoes lottoes = lottoService.getLottoes(amount);
        ResultView.printLottoes(lottoes);
        final List<Integer> winningNumbers = InputView.getWinningNumbers();
        final WinningLottoes winningLottoes = lottoService.matchingWinningNumbers(winningNumbers, lottoes);
        ResultView.printWinningRate(winningLottoes);
    }
}