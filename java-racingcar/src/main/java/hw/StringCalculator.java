package hw;

import java.util.*;

public class StringCalculator {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            final String input = sc.nextLine();
            final Calculator calculator = new Calculator();
            final int result = calculator.execute(input);
            System.out.println("result : " + result);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}

class Calculator {
    private static final String WHITE_SPACE = " ";

    public int execute(String input) {
        if (OperationUtils.isEmpty(input)) {
            throw new IllegalArgumentException();
        }
        final String[] arr = input.split(WHITE_SPACE);
        int a = OperationUtils.parseInt(arr[0]);
        for (int i = 1; i < arr.length; i += 2) {
            String op = arr[i];
            int b = OperationUtils.parseInt(arr[i + 1]);
            a = execute(a, op, b);
        }
        return a;
    }

    private int execute(int a, String op, int b) {
        if (Operation.ADD.isSameSymbol(op)) {
            return a + b;
        }
        if (Operation.SUBTRACT.isSameSymbol(op)) {
            return a - b;
        }
        if (Operation.MULTIPLY.isSameSymbol(op)) {
            return a * b;
        }
        if (Operation.DIVIDE.isSameSymbol(op)) {
            return a / b;
        }
        throw new IllegalArgumentException("유효하지 않은 연산자입니다.");
    }
}

enum Operation {
    ADD("+"),
    SUBTRACT("-"),
    MULTIPLY("*"),
    DIVIDE("/");

    private final String symbol;

    Operation(String symbol) {
        this.symbol = symbol;
    }

    public boolean isSameSymbol(String op) {
        return this.symbol.equals(op);
    }
}

class OperationUtils {
    public static int parseInt(String s) {
        if (isEmpty(s)) {
            throw new IllegalArgumentException("유효하지 않은 인수입니다.");
        }
        return Integer.parseInt(s);
    }

    public static boolean isEmpty(String s) {
        return s == null || s.trim().length() == 0;
    }
}