package lotto.validator;

import java.util.Arrays;
import java.util.stream.Collectors;

public class WinningNumbersValidator implements Validator {

    @Override
    public Boolean isValidate(String value) {
        return isValidSeparation(value) && isValidRange(value) && isUnique(value);
    }

    private Boolean isValidSeparation(String value) {
        return value.split(",").length == 6;
    }

    private Boolean isValidRange(String value) {
        return Arrays.stream(value.split(","))
                .allMatch(num -> {
                    try {
                        int intNum = Integer.parseInt(num);
                        return 1 <= intNum && intNum <= 45;
                    } catch (NumberFormatException e) {
                        return false;
                    }
                });
    }

    private Boolean isUnique(String value) {
        return Arrays.stream(value.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toSet())
                .size() == 6;
    }
}
