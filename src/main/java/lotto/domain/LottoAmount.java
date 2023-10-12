package lotto.domain;

import lotto.constant.Message;
import lotto.util.LottoNumberGenerator;

import java.util.List;

public class LottoAmount {

    private static final int MIN_MONEY = 1000;
    private static final int MAX_MONEY = 100000;
    private static final int LOTTO_AMOUNT = 1000;
    private static final int ZERO = 0;
    private final int purchaseAmount;
    private final int lottoTickets;

    public LottoAmount(int number) {
        validate(number);
        this.purchaseAmount = number;
        this.lottoTickets = exchangeTicket(number);
    }

    public List<List<Integer>> buyLotto() {
        LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
        return lottoNumberGenerator.createRandomNumbers(lottoTickets);
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    private void validate(int number) {
        if (!validRange(number)) {
            throw new IllegalArgumentException(Message.NOT_VALID_RANGE_AMOUNT);
        }
        if (!validUnit(number)) {
            throw new IllegalArgumentException(Message.NOT_VALID_UNIT);
        }
    }

    private int exchangeTicket(int number) {
        return number / LOTTO_AMOUNT;
    }

    private boolean validUnit(int number) {
        return number % LOTTO_AMOUNT == ZERO;
    }

    private boolean validRange(int number) {
        return MIN_MONEY <= number && number <= MAX_MONEY;
    }
}
