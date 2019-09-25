package racingcar.utils;

public class StringUtils {
    private static final String SPECIAL_CHARACTER_TAB = "\t";
    private static final String SPECIAL_CHARACTER_NEW_LINE = "\n";

    public static boolean isEmpty(final String str) {
        if (
                isEmptyAndBlank(str) ||
                        str.equals(SPECIAL_CHARACTER_TAB) ||
                        str.equals(SPECIAL_CHARACTER_NEW_LINE)
        ) {
            return true;
        }
        return false;
    }

    public static int convertToInteger(final String str) {
        if (isEmpty(str)) {
            throw new IllegalArgumentException("경기 수가 입력되지 않았습니다.");
        }
        return Integer.parseInt(str);
    }

    private static boolean isEmptyAndBlank(final String str) {
        return org.apache.commons.lang3.StringUtils.isEmpty(str) ||
                org.apache.commons.lang3.StringUtils.isBlank(str.trim());
    }
}
