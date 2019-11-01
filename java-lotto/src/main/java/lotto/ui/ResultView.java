package lotto.ui;

import lotto.application.WinningLottoes;
import lotto.domain.Lottoes;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class ResultView {
    private static final String INFO_WINNING_RATE = "\n당첨 통계\n----------";
    private static final Map<Integer, Integer> PRIZE_MONEY_BY_COUNT = new HashMap<>();

    static {
        PRIZE_MONEY_BY_COUNT.put(3, 5000);
        PRIZE_MONEY_BY_COUNT.put(4, 50000);
        PRIZE_MONEY_BY_COUNT.put(5, 1500000);
        PRIZE_MONEY_BY_COUNT.put(6, 2000000000);
    }

    public static void printLottoes(final Lottoes lottoes) {
        for (int i = 0; i < lottoes.getCount(); i++) {
            System.out.println(lottoes.getLotto(i));
        }
        System.out.println();
    }

    public static void printWinningRate(final WinningLottoes winningLottoes) {
        System.out.println(INFO_WINNING_RATE);
        IntStream.rangeClosed(3, 6)
                .forEach(i -> printWinningRate(i, PRIZE_MONEY_BY_COUNT.get(i), winningLottoes));
    }

    private static void printWinningRate(final int value, final int money, final WinningLottoes winningLottoes) {
        System.out.println(value + "개 일치 (" + money + "원) - " + winningLottoes.getCountOfEachMatches(value));
    }
}
