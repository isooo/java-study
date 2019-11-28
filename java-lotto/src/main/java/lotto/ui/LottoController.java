package lotto.ui;

import lotto.application.LottoService;
import lotto.domain.Lottos;
import lotto.domain.LottosResult;

public class LottoController {
    public static void run(final LottoService lottoService) {
        final String amount = InputView.getPurchaseAmount();
        final Lottos lottos = lottoService.lottoPurchase(amount);
        ResultView.printLottos(lottos);
        final String winningNumbers = InputView.getWinningNumbers();
        final String bonusNumber = InputView.getBonusNumber();
        final LottosResult winningStatistics = lottoService.getWinningStatistics(lottos, winningNumbers, bonusNumber);
        ResultView.printStatistics(winningStatistics);
    }
}
