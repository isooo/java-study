package lotto.application;

import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.List;

public class PurchasedLottoes {
    private final List<Lotto> purchasedLottoes;

    public PurchasedLottoes(final List<Lotto> lottoList) {
        this.purchasedLottoes = new ArrayList<>(lottoList);
    }
}
