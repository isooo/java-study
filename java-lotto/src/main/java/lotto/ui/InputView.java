package lotto.ui;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);

    static int getCount() {
        System.out.println("구입금액을 입력해 주세요.");
        final String input = SCANNER.nextLine();
        final int count = getCount(input);
        System.out.println(count + "개를 구매했습니다.");
        return count;
    }

    private static int getCount(final String input) {
        final int amount = Integer.parseInt(input);
        return amount / 1000;
    }

    static List<Integer> getWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        final String input = SCANNER.nextLine();
        final String[] split = input.split(", ");
        return Arrays.stream(split)
                .map(s -> Integer.parseInt(s))
                .collect(Collectors.toList());
    }
}