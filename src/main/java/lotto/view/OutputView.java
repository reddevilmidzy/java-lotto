package lotto.view;

import java.util.List;

public class OutputView {
    public void printBought(Integer count, List<List<Integer>> lotto) {
        System.out.println(count + "개를 구매했습니다.");
        for (List<Integer> val : lotto) {
            System.out.println(val);
        }
    }
}
