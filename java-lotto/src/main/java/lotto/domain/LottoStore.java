package lotto.domain;

import lotto.utils.StringUtils;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoStore {
    public static final int LOTTO_AMOUNT_UNIT = 1_000;

    public static Lottos purchase(final String amount) {
        final int count = convertAmountToCount(amount);
        return new Lottos(IntStream.rangeClosed(1, count)
                .mapToObj(i -> Lotto.create())
                .collect(Collectors.toList())
        );
    }

    private static int convertAmountToCount(final String amount) {
        return StringUtils.parseInt(amount) / LOTTO_AMOUNT_UNIT;
    }
}
