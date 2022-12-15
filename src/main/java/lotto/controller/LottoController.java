package lotto.controller;

import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.LottoAmount;
import lotto.domain.Rank;
import lotto.domain.WinningNumbers;
import lotto.util.Statistics;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.Map;

public class LottoController {

    protected InputView inputView;
    protected OutputView outputView;

    public LottoController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {
        try {
            start();
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e);
        }
    }

    private void start() {
        LottoAmount lottoAmount = inputAmount();
        List<List<Integer>> lotto = buyLotto(lottoAmount);
        Lotto lottoNumber = inputLotto();
        BonusNumber bonusNumber = inputBonusNumber();
        WinningNumbers winningNumbers = resultNumbers(lottoNumber.getLottoNumber(), bonusNumber.getBonusNumber());
        Statistics statistics = summingUp(winningNumbers, lotto);
        winningHistory(statistics);
        calculator(statistics, lottoAmount);
    }

    private LottoAmount inputAmount() {
        try {
            int number = inputView.getPurchaseAmount();
            LottoAmount lottoAmount = new LottoAmount(number);
            outputView.printBuyLottoTicket(number);
            return lottoAmount;
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e);
            return inputAmount();
        }
    }

    private List<List<Integer>> buyLotto(LottoAmount lottoAmount) {
        List<List<Integer>> lottoNumbers = lottoAmount.buyLotto();
        outputView.printBuyLotto(lottoNumbers);
        return lottoNumbers;
    }

    private Lotto inputLotto() {
        try {
            List<Integer> numbers = inputView.getWinningNumbers();
            return new Lotto(numbers);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e);
            return inputLotto();
        }
    }

    private BonusNumber inputBonusNumber() {
        try {
            int number = inputView.getBonusNumber();
            return new BonusNumber(number);
        } catch(IllegalArgumentException e) {
            outputView.printErrorMessage(e);
            return inputBonusNumber();
        }
    }

    private WinningNumbers resultNumbers(List<Integer> lottoNumber, int bonusNumber) {
        try {
            return new WinningNumbers(lottoNumber, bonusNumber);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e);
            return resultNumbers(lottoNumber, inputBonusNumber().getBonusNumber());
        }
    }

    private Statistics summingUp(WinningNumbers winningNumbers, List<List<Integer>> lottoNumber) {
        Statistics statistics = new Statistics();
        statistics.makeWinningStatistics(winningNumbers, lottoNumber);
        return statistics;
    }

    private void winningHistory(Statistics statistics) {
        Map<Rank, Integer> winningStatistics = statistics.getWinningStatistics();
        outputView.printStatistics(winningStatistics);
    }

    private void calculator(Statistics statistics, LottoAmount lottoAmount) {
        double revenueRatio = statistics.calculatorRevenueRatio(lottoAmount.getPurchaseAmount());
        outputView.printPercentage(revenueRatio);
    }
}