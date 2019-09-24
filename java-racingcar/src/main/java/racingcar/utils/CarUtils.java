package racingcar.utils;

public class CarUtils {
    public static final String NAME_SEPARATE_SYMBOL = ",";

    public static String[] separate(final String carsNames) {
        return carsNames.split(NAME_SEPARATE_SYMBOL);
    }
}
