package lotto.validator;

public class BonusNumberValidator implements Validator {
    @Override
    public Boolean isValidate(String value) {
        return isValidRange(value);
    }

    private Boolean isValidRange(String value) {
        try {
            int intNum = Integer.parseInt(value);
            return 1 <= intNum && intNum <= 45;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
