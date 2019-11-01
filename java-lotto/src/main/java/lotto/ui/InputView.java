package lotto.ui;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String GET_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String INFO_PURCHASE_COUNT = "구입금액을 입력해 주세요.";
    private static final String GET_WINNING_NUMBERS = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String SEPARATE_SYMBOL = ", ";

    static int getCount() {
        System.out.println(GET_PURCHASE_AMOUNT);
        final String input = SCANNER.nextLine();
        final int count = getCount(input);
        System.out.println(count + INFO_PURCHASE_COUNT);
        return count;
    }

    private static int getCount(final String input) {
        final int amount = Integer.parseInt(input);
        return amount / 1000;
    }

    static List<Integer> getWinningNumbers() {
        System.out.println(GET_WINNING_NUMBERS);
        final String input = SCANNER.nextLine();
        final String[] split = input.split(SEPARATE_SYMBOL);
        return Arrays.stream(split)
                .map(s -> Integer.parseInt(s))
                .collect(Collectors.toList());
    }
}