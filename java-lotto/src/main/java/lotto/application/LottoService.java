package lotto.application;

import lotto.domain.LottoStore;
import lotto.domain.Lottos;

public class LottoService {
    public Lottos lottoPurchase(final String amount) {
        return LottoStore.purchase(amount);
    }
}
