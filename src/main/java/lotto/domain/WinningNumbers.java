package lotto.domain;

import lotto.constant.Message;

import java.util.List;

public class WinningNumbers {

    private final int bonusNumber;
    private final List<Integer> lottoNumber;

    public WinningNumbers(List<Integer> lottoNumber, int bonusNumber) {
        validate(lottoNumber, bonusNumber);
        this.lottoNumber = lottoNumber;
        this.bonusNumber = bonusNumber;
    }

    private boolean isValidUnique(List<Integer> lottoNumber, int bonusNumber) {
        return !lottoNumber.contains(bonusNumber);
    }

    private void validate(List<Integer> lottoNumber, int bonusNumber) {
        if (!isValidUnique(lottoNumber, bonusNumber)) {
            throw new IllegalArgumentException(Message.DUPLICATE);
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public List<Integer> getLottoNumber() {
        return lottoNumber;
    }
}
