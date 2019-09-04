package hw;

import java.util.*;

public class StringCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final String input = sc.nextLine();
        final Calculator calculator = new Calculator();
        final int result = calculator.excute(input);
        System.out.println("result : " + result);
    }
}

class Calculator {
    public int excute(String input) {
        final String[] arr = input.split(" ");
        String a = arr[0];
        final Operation operation = new Operation();
        for (int i = 1; i < arr.length; i += 2) {
            String op = arr[i];
            String b = arr[i + 1];
            a = operation.execute(a, op, b);
        }
        return Integer.parseInt(a);
    }
}

class Operation {
    private static final String ADD = "+";
    private static final String SUBTRACT = "-";
    private static final String MULTIPLY = "*";
    private static final String DIVIDE = "/";

    public String execute(String a, String op, String b) {
        final int x = Integer.parseInt(a);
        final int y = Integer.parseInt(b);
        final int result = execute(x, op, y);
        return String.valueOf(result);
    }

    private int execute(int a, String op, int b) {
        if (ADD.equals(op)) {
            return a + b;
        }
        if (SUBTRACT.equals(op)) {
            return a - b;
        }
        if (MULTIPLY.equals(op)) {
            return a * b;
        }
        if (DIVIDE.equals(op)) {
            return a / b;
        }
        throw new IllegalArgumentException("유효하지 않은 연산자입니다.");
    }
}