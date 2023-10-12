package lotto.controller;

import lotto.util.LottoGenerator;
import lotto.validator.BonusNumberValidator;
import lotto.validator.PurchaseAmountValidator;
import lotto.validator.Validator;
import lotto.validator.WinningNumbersValidator;
import lotto.view.InputView;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoController {
    private final InputView inputView;

    public LottoController(InputView inputView) {
        this.inputView = inputView;
    }

    public void run() {
        String amount = inputView.readPurchaseAmount();
        validate(new PurchaseAmountValidator(), amount);
        List<List<Integer>> lotto = generate(Integer.parseInt(amount)/1000);
        String winningNumbers = inputView.readWinningNumbers();
        validate(new WinningNumbersValidator(), winningNumbers);
        String bonusNumber = inputView.readBonusNumber();
        validate(new BonusNumberValidator(), bonusNumber);
    }

    private void validate(Validator validator, String value) {
        if (!validator.isValidate(value)) {
            throw new IllegalArgumentException();
        }
    }

    private List<List<Integer>> generate(Integer amount) {
        return IntStream.range(0, amount)
                .mapToObj(i -> LottoGenerator.generate())
                .collect(Collectors.toList());
    }
}
