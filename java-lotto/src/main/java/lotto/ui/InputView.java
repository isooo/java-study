package lotto.ui;

import java.util.Scanner;

public class InputView {

    public static int askAmount() {
        Scanner sc = new Scanner(System.in);
        final String input = sc.nextLine();
        return Integer.parseInt(input);
    }

}