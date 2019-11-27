package stepone;

import java.util.*;
import java.util.regex.*;
import java.util.stream.*;

import static java.util.regex.Matcher.*;

/**
 * [기능 요구사항]
 * 1. 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열 전달시, 각 구분자를 기준으로 분리한 각 숫자의 합을 반환
 * 2. 기본 구분자 외 커스텀 구분자 지정 가능
 * > 커스텀 구분자는 문자열 앞 부분의 '//'와 '\n' 사이에 위치한 문자를 커스텀 구분자로 사용
 * > //;\n1;2;3  ==> 구분자는 ; 이며, 결과값은 6이다.
 * 3. 숫자 이외의 값 또는 음수 전달 시 'throw RuntimeException'
 *
 * [프로그래밍 요구사항]
 * - 들여쓰기는 1단계만
 * - 메소드의 크기는 최대 10라인을 넘지 않도록! (SRP)
 */
public class PlusCalculator {
    private static final String DEFAULT_DELIMITER = ":|,";
    private static final String CUSTOM_DELIMITER_PATTERN = "//(.)\\n(.*)";

    public static int execute(final String value) {
        if (value == null || value.isEmpty()) {
            return 0;
        }

        String input = value;
        String customDelimiter = DEFAULT_DELIMITER;
        final Matcher matcher = Pattern.compile(quoteReplacement(CUSTOM_DELIMITER_PATTERN)).matcher(value);
        if (matcher.matches()) {
            customDelimiter = quoteReplacement(matcher.group(1));
            input = matcher.group(2);
        }

        final String[] inputArray = input.split(customDelimiter);

        final List<Integer> numbers = Arrays.stream(inputArray)
                .map(number -> Integer.parseInt(number))
                .collect(Collectors.toList());

        int result = numbers.get(0);
        for (int i = 1; i < numbers.size(); i++) {
            result = plus(result, numbers.get(i));
        }

        return result;
    }

    private static int plus(final int x, final int y) {
        if (y < 0) {
            throw new RuntimeException();
        }
        return x + y;
    }
}
