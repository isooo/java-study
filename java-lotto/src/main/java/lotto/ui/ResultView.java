package lotto.ui;

import lotto.domain.Lotto;
import lotto.domain.Lottos;

public class ResultView {
    public static void printLottos(final Lottos lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        lottos.get()
                .stream()
                .map(lotto -> changeFormatToPrint(lotto))
                .forEach(System.out::println);
    }

    private static String changeFormatToPrint(final Lotto lotto) {
        return new StringBuilder()
                .append(lotto.getNumbers().get())
                .toString();
    }
}
