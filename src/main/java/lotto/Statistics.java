package lotto;

import java.util.ArrayList;
import java.util.List;

public class Statistics {
    private final List<Integer> winningLotto;
    private final int bonusNumber;
    private int first = 0;
    private int second = 0;
    private int third = 0;
    private int fourth = 0;
    private int fifth = 0;

    public Statistics(List<Integer> winningLotto, int bonusNumber) {
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public void compare(List<List<Integer>> lottos, int purchaseAmount) {
        for (List<Integer> integers : lottos) {
            prize(integers);
        }
        List<Integer> result = new ArrayList<>(List.of(fifth, fourth, third, second, first));
        OutputView outputView = new OutputView(result, purchaseAmount);
    }

    private void prize(List<Integer> lotto) {
        boolean bonus = lotto.contains(bonusNumber);
        lotto.retainAll(winningLotto);
        int duplicate = lotto.size();

        if (duplicate==6) {
            first += 1;
        }
        if (duplicate == 5 && bonus) {
            second += 1;
        }
        if (duplicate == 5 && !bonus) {
            third += 1;
        }
        if (duplicate == 4) {
            fourth += 1;
        }
        if (duplicate == 3) {
            fifth += 1;
        }
    }
}
