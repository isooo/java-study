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
            a = Operation.operate(a, op, b);
        }
        return a;
    }
}

enum Operation {
    ADD("+") {
        int operate(int a, int b) {
            return a + b;
        }
    },
    SUBTRACT("-") {
        int operate(int a, int b) {
            return a - b;
        }
    },
    MULTIPLY("*") {
        int operate(int a, int b) {
            return a * b;
        }
    },
    DIVIDE("/") {
        int operate(int a, int b) {
            return a / b;
        }
    };

    private final String symbol;

    abstract int operate(int a, int b);

    Operation(String symbol) {
        this.symbol = symbol;
    }

    public boolean isSameSymbol(String op) {
        return this.symbol.equals(op);
    }

    public static int operate(int a, String s, int b) {
        final Operation operation = Arrays.stream(Operation.values())
                .filter(op -> op.isSameSymbol(s))
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
        return operation.operate(a, b);
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