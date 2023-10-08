package lotto.validator;

import java.util.regex.Pattern;

public class PurchaseAmountValidator implements Validator {
    private final String REGEXP_PATTERN_NUMBER = "^[\\d]+$";

    @Override
    public Boolean isValidate(String value) {
        return isValidType(value) && isValidRange(value) && isValidUnit(value);
    }

    private Boolean isValidType(String value) {
        return Pattern.matches(REGEXP_PATTERN_NUMBER, value);
    }

    private Boolean isValidRange(String value) {
        try {
            return 1000 <= Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private Boolean isValidUnit(String value) {
        return Integer.parseInt(value) % 1000 == 0;
    }
}
