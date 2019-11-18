package lotto.ui;

import lotto.application.LottoService;
import lotto.domain.Lottos;

public class LottoController {
    public static void run(final LottoService lottoService) {
        final String amount = InputView.getAmount();
        final Lottos lottos = lottoService.lottoPurchase(amount);
        ResultView.printLottos(lottos);
    }
}
