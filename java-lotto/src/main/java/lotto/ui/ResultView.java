package lotto.ui;

import lotto.domain.Lotto;
import lotto.domain.LottoPrize;
import lotto.domain.Lottos;
import lotto.domain.LottosResult;

import java.util.Comparator;
import java.util.Map;

public class ResultView {
    public static void printLottos(final Lottos lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        lottos.get()
                .stream()
                .map(lotto -> changeFormatToPrint(lotto))
                .forEach(System.out::println);
        System.out.println();
    }

    private static String changeFormatToPrint(final Lotto lotto) {
        return new StringBuilder()
                .append(lotto.getNumbers().get())
                .toString();
    }

    public static void printStatistics(final LottosResult winningStatistics) {
        System.out.println("\n당첨 통계");
        System.out.println("----------");
        winningStatistics.get().entrySet().stream()
                .filter(ele -> ele.getKey() != LottoPrize.ZERO)
                .sorted(Comparator.comparing(Map.Entry::getKey, Comparator.reverseOrder()))
                .forEach(ele -> System.out.println(changeFormatToPrint(ele)));
        System.out.println("총 수익률은 " + winningStatistics.getRoi() + "입니다.");
    }

    private static String changeFormatToPrint(final Map.Entry<LottoPrize, Integer> ele) {
        return new StringBuilder()
                .append(ele.getKey().getHitCount())
                .append("개 일치 (")
                .append(ele.getKey().getPrizeMoney())
                .append("원) - ")
                .append(ele.getValue())
                .append("개")
                .toString();
    }
}
