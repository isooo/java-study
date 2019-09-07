package hw;

import java.util.*;
import java.util.function.*;

public class StringCalculator {
    public static void main(String[] args) {
        try {
            final Scanner sc = new Scanner(System.in);
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

    public int execute(final String input) {
        if (OperationUtils.isEmpty(input)) {
            throw new IllegalArgumentException();
        }
        final String[] arr = input.split(WHITE_SPACE);
        int result = OperationUtils.parseInt(arr[0]);
        for (int i = 1; i < arr.length; i += 2) {
            final int var = OperationUtils.parseInt(arr[i + 1]);
            result = Operation.operate(result, arr[i], var);
        }
        return result;
    }
}

enum Operation {
    ADD("+", (left, right) -> left + right),
    SUBTRACT("-", (left, right) -> left - right),
    MULTIPLY("*", (left, right) -> left * right),
    DIVIDE("/", (left, right) -> left / right);

    private final String symbol;
    private final BinaryOperator<Integer> execute;

    Operation(final String symbol, final BinaryOperator<Integer> execute) {
        this.symbol = symbol;
        this.execute = execute;
    }

    public boolean isSameSymbol(final String op) {
        return this.symbol.equals(op);
    }

    private int execute(final int left, final int right) {
        return execute.apply(left, right);
    }

    private static Operation from(final String op) {
        return Arrays.stream(Operation.values())
                .filter(o -> o.isSameSymbol(op))
                .findAny()
                .orElseThrow(IllegalArgumentException::new)
                ;
    }

    public static int operate(final int left, final String op, final int right) {
        final Operation operation = from(op);
        return operation.execute(left, right);
    }
}

class OperationUtils {
    public static int parseInt(final String s) {
        if (isEmpty(s)) {
            throw new IllegalArgumentException("유효하지 않은 인수입니다.");
        }
        return Integer.parseInt(s);
    }

    public static boolean isEmpty(final String s) {
        return s == null || s.trim().length() == 0;
    }
}