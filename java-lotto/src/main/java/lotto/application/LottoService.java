package lotto.application;

import lotto.domain.*;

import java.util.Arrays;
import java.util.stream.Collectors;

public class LottoService {
    private static final String SEPARATE_SYMBOL = ", ";

    public Lottos lottoPurchase(final String amount) {
        return LottoStore.purchase(amount);
    }

    public LottosResult getWinningStatistics(final Lottos lottos, final String winningNumbers) {
        final LottoNumbers winningLottoNumbers = getWinningLotto(winningNumbers);
        return lottos.calculateWinningStatistics(winningLottoNumbers);
    }

    private LottoNumbers getWinningLotto(final String winningNumbers) {
        return new LottoNumbers(Arrays.stream(winningNumbers.split(SEPARATE_SYMBOL))
                .map(s -> Integer.parseInt(s))
                .map(value -> LottoNumber.get(value))
                .collect(Collectors.toList()));
    }
}
