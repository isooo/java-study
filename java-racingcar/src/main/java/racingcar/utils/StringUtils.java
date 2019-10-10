package racingcar.utils;

public class StringUtils {
    public static final String NAME_SEPARATE_SYMBOL = ",";
    private static final String SPECIAL_CHARACTER_TAB = "\t";
    private static final String SPECIAL_CHARACTER_NEW_LINE = "\n";

    public static String[] separate(final String carsNames) {
        return carsNames.split(NAME_SEPARATE_SYMBOL);
    }

    public static boolean isEmpty(final String str) {
        if (isEmptyAndBlank(str) ||
                str.equals(SPECIAL_CHARACTER_TAB) ||
                str.equals(SPECIAL_CHARACTER_NEW_LINE)
        ) {
            return true;
        }
        return false;
    }

    private static boolean isEmptyAndBlank(final String str) {
        return org.apache.commons.lang3.StringUtils.isEmpty(str) ||
                org.apache.commons.lang3.StringUtils.isBlank(str.trim());
    }
}
