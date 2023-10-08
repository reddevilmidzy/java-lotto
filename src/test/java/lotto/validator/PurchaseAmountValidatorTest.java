package lotto.validator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PurchaseAmountValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"1000", "2000", "50000"})
    @DisplayName("올바른 로또 구입 금액 입력 확인")
    void checkValidPurchaseAmount(String value) {
        Validator validator = new PurchaseAmountValidator();
        Assertions.assertThat(validator.isValidate(value)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1000", "0", "1000000000000000000"})
    @DisplayName("잘못된 로또 구입 금액 입력 확인")
    void checkInvalidPurchaseAmount(String value) {
        Validator validator = new PurchaseAmountValidator();
        Assertions.assertThat(validator.isValidate(value)).isFalse();
    }


}