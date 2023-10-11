package lotto.validator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class WinningNumbersValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6", "3,5,7,2,12,45"})
    @DisplayName("올바른 당첨 번호 입력")
    void checkValidWinningNumber(String value) {
        Validator validator = new WinningNumbersValidator();
        Assertions.assertThat(validator.isValidate(value)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"2,3,4,5,6", "23,3,5,7,2,12,45", "0,-1,2,3,4,5", "1,2,3,4,5,1", "10,11,12,13,1 4,15"})
    @DisplayName("잘못된 당첨 번호 입력")
    void checkInvalidWinningNumber(String value) {
        Validator validator = new WinningNumbersValidator();
        Assertions.assertThat(validator.isValidate(value)).isFalse();
    }
}