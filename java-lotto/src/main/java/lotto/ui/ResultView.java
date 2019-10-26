package lotto.ui;

import lotto.domain.Lottoes;

public class ResultView {
    public static void printLottoes(final Lottoes lottoes) {
        for (int i = 0; i < lottoes.getCount(); i++) {
            System.out.println(lottoes.getLotto(i));
        }
        System.out.println();
    }
}
