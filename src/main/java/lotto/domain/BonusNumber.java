package lotto.domain;

import lotto.constant.Message;

public class BonusNumber {
    private final int bonusNumber;
    private static final int START_LOTTO_NUMBER = 1;
    private static final int END_LOTTO_NUMBER = 45;

    public BonusNumber(int number) {
        validate(number);
        this.bonusNumber = number;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private void validate(int number) {
        if (!isValidRange(number)) {
            throw new IllegalArgumentException(Message.NOT_VALID_RANGE_NUMBER);
        }
    }

    private boolean isValidRange(int number) {
        return START_LOTTO_NUMBER <= number && number <= END_LOTTO_NUMBER;
    }
}
