package lotto.validator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BonusNumberValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"1", "45", "23"})
    void checkValidBonusNumber(String value) {
        Validator validator = new BonusNumberValidator();
        Assertions.assertThat(validator.isValidate(value)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "46", "2 3", "a"})
    void checkInvalidBonusNumber(String value) {
        Validator validator = new BonusNumberValidator();
        Assertions.assertThat(validator.isValidate(value)).isFalse();
    }
}