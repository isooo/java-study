package lotto.ui;

import lotto.application.WinningLottoes;
import lotto.domain.Lottoes;

public class ResultView {
    public static void printLottoes(final Lottoes lottoes) {
        for (int i = 0; i < lottoes.getCount(); i++) {
            System.out.println(lottoes.getLotto(i));
        }
        System.out.println();
    }

    public static void printWinningRate(final WinningLottoes winningLottoes) {
        System.out.println("\n당첨 통계\n----------");
        printWinningRate(3, 5000, winningLottoes);
        printWinningRate(4, 50000, winningLottoes);
        printWinningRate(5, 1500000, winningLottoes);
        printWinningRate(6, 2000000000, winningLottoes);
    }

    private static void printWinningRate(final int value, final int money, final WinningLottoes winningLottoes) {
        System.out.println(value + "개 일치 (" + money + "원) - " + winningLottoes.getCountOfEachMatches(value));
    }
}
