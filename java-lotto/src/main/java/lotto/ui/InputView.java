package lotto.ui;

import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String GET_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String GET_WINNING_NUMBERS = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String GET_BONUS_NUMBER = "보너스 볼을 입력해 주세요.";

    static String getPurchaseAmount() {
        System.out.println(GET_PURCHASE_AMOUNT);
        return SCANNER.nextLine();
    }

    static String getWinningNumbers() {
        System.out.println(GET_WINNING_NUMBERS);
        return SCANNER.nextLine();
    }

    static String getBonusNumber() {
        System.out.println(GET_BONUS_NUMBER);
        return SCANNER.nextLine();
    }
}
